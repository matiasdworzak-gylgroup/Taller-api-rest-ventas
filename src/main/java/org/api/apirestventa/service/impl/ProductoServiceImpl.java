package org.api.apirestventa.service.impl;

import org.api.apirestventa.dto.requestDto.ProductoRequestDto;
import org.api.apirestventa.dto.responseDto.ProductoResponseDto;
import org.api.apirestventa.entity.Producto;
import org.api.apirestventa.entity.TipoProducto;
import org.api.apirestventa.exception.RecursoNoEncontradosException;
import org.api.apirestventa.mapper.ProductoMapper;
import org.api.apirestventa.repository.ProductoRepository;
import org.api.apirestventa.repository.TipoProductoRepository;
import org.api.apirestventa.service.ProductoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;
    private final TipoProductoRepository tipoProductoRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository, TipoProductoRepository tipoProductoRepository) {
        this.productoRepository = productoRepository;
        this.tipoProductoRepository = tipoProductoRepository;
    }

    @Override
    public ProductoResponseDto crear(ProductoRequestDto dto) {
        TipoProducto tipo = tipoProductoRepository.findById(dto.idTipoProducto())
                .orElseThrow(() -> new RecursoNoEncontradosException("Tipo de producto no encontrado"));

        Producto producto = ProductoMapper.toEntity(dto);
        producto.setTipoProducto(tipo);

        return ProductoMapper.toResponseDto(productoRepository.save(producto));
    }

    @Override
    public List<ProductoResponseDto> listar() {
        return productoRepository.findAll().stream()
                .map(ProductoMapper::toResponseDto).toList();
    }

    @Override
    public ProductoResponseDto buscarPorId(Long id) {
        return productoRepository.findById(id)
                .map(ProductoMapper::toResponseDto)
                .orElseThrow(() -> new RecursoNoEncontradosException("Producto no encontrado"));
    }

    @Override
    public ProductoResponseDto actualizar(Long id, ProductoRequestDto dto) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradosException("Producto no encontrado"));

        TipoProducto tipo = tipoProductoRepository.findById(dto.idTipoProducto())
                .orElseThrow(() -> new RecursoNoEncontradosException("Tipo de producto no encontrado"));

        ProductoMapper.updateEntity(producto, dto);
        producto.setTipoProducto(tipo);

        return ProductoMapper.toResponseDto(productoRepository.save(producto));
    }

    @Override
    public void eliminar(Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradosException("Producto no encontrado"));
        productoRepository.delete(producto);
    }
}