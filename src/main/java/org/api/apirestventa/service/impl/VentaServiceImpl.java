package org.api.apirestventa.service.impl;

import jakarta.transaction.Transactional;
import org.api.apirestventa.dto.VentaRequestDto;
import org.api.apirestventa.dto.VentaResponseDto;
import org.api.apirestventa.entity.Cliente;
import org.api.apirestventa.entity.DetalleVenta;
import org.api.apirestventa.entity.Producto;
import org.api.apirestventa.entity.Venta;
import org.api.apirestventa.exception.*;
import org.api.apirestventa.mapper.DetalleVentaMapper;
import org.api.apirestventa.mapper.VentaMapper;
import org.api.apirestventa.repository.ClienteRepository;
import org.api.apirestventa.repository.ProductoRepository;
import org.api.apirestventa.repository.VentaRepository;
import org.api.apirestventa.service.VentaService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class VentaServiceImpl implements VentaService {
   private ClienteRepository clienteRepository;
   private ProductoRepository productoRepository;
   private VentaRepository ventaRepository;

   public VentaServiceImpl(ClienteRepository clienteRepository, ProductoRepository productoRepository, VentaRepository ventaRepository ){
       this.clienteRepository = clienteRepository;
       this.productoRepository = productoRepository;
       this.ventaRepository = ventaRepository;
   }
    @Transactional
    @Override
    public VentaResponseDto crear(VentaRequestDto dto) {
        //Validar:
        //Cliente existe Listo
        //Productos tienen stock Listo
        //Lista de detalle venta no esta vacia Listo
        //Productos existen en la dbS Listo
        Venta nuevaVenta = new Venta();

        Cliente clienteEncontrado = clienteRepository.findById(dto.idCliente()).
                orElseThrow(() -> new CienteNoEncontradoException("El cliente no esta registrado o no existe."));
        if (dto.detalles().isEmpty()){ throw new VentaVaciaException("No se puede cargar una venta vacia");}

        List<DetalleVenta> detalles = dto.detalles().stream()
                .map(detalleDto -> {
                    DetalleVenta detalle = DetalleVentaMapper.toEntity(detalleDto);
                    if (detalle.getCantidad() < 1) {
                        throw new ErrorGenericoException("La cantidad tiene que ser mayor a 0");
                    }

                    Producto producto = productoRepository.findById(detalleDto.idProducto())
                            .orElseThrow(() -> new RecursoNoEncontradosException("Producto no encontrado"));

                    if (detalle.getCantidad() > producto.getStock()) {
                        throw new ProductoFaltanteDeStockException("El producto no cuenta con el stock suficiente para hacer esta compra");
                    }
                    detalle.setProducto(producto);
                    detalle.setPrecioUnitario(producto.getPrecio());
                    detalle.setSubtotal(producto.getPrecio().multiply(BigDecimal.valueOf(detalle.getCantidad())));
                    producto.setStock(producto.getStock()-detalle.getCantidad());
                    detalle.setVenta(nuevaVenta);

                    return detalle;
                }).toList();

        nuevaVenta.setDetalleVentas(detalles);
        nuevaVenta.setCliente(clienteEncontrado);
        nuevaVenta.setFechaVenta(LocalDateTime.now());
        nuevaVenta.setTotal(getTotalVenta(detalles));
        Venta ventaGuardada = ventaRepository.save(nuevaVenta);

        return VentaMapper.toResponseDto(ventaGuardada);
    }

    @Override
    public List<VentaResponseDto> listar() {
            return ventaRepository.findAll().stream().
                    map(VentaMapper::toResponseDto).toList();
    }

    @Override
    public VentaResponseDto buscarPorId(Long id) {
        return ventaRepository.findById(id).map(VentaMapper::toResponseDto)
                .orElseThrow(() -> new RecursoNoEncontradosException("No se encontro venta para este id"));
    }

    @Override
    public List<VentaResponseDto> buscarVentasPorClienteId(Long idCliente) {
        System.out.println("Buscando ventas para el cliente: " + idCliente);
        return ventaRepository.findByCliente_IdCliente(idCliente)
        .stream().map(VentaMapper::toResponseDto).toList();
    }

    private BigDecimal getTotalVenta(List<DetalleVenta>detalles){
       BigDecimal total = BigDecimal.ZERO;
       for(DetalleVenta d : detalles){
           total = total.add(d.getSubtotal());
       }
       return total;
    }
}
