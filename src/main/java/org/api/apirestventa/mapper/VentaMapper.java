package org.api.apirestventa.mapper;

import org.api.apirestventa.dto.VentaRequestDto;
import org.api.apirestventa.dto.VentaResponseDto;
import org.api.apirestventa.entity.Venta;

import java.util.stream.Collectors;

public class VentaMapper {

    private VentaMapper() {}

    public static Venta toEntity(VentaRequestDto dto) {
        Venta venta = new Venta();

        return venta;
    }

    public static VentaResponseDto toResponseDto(Venta venta) {
        return new VentaResponseDto(
                venta.getIdVenta(),
                venta.getFechaVenta(),
                venta.getTotal(),
                venta.getCliente().getIdCliente(),
                venta.getDetalleVentas().stream()
                        .map(DetalleVentaMapper::toResponseDto)
                        .toList()
        );
    }

}
