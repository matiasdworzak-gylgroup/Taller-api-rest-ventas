package org.api.apirestventa.mapper;

import org.api.apirestventa.dto.DetalleVentaRequestDto;
import org.api.apirestventa.dto.DetalleVentaResponseDto;
import org.api.apirestventa.entity.DetalleVenta;

public class DetalleVentaMapper {

    private DetalleVentaMapper() {}


    public static DetalleVenta toEntity(DetalleVentaRequestDto dto) {
        DetalleVenta detalle = new DetalleVenta();
        detalle.setCantidad(dto.cantidad());
        return detalle;
    }

    public static DetalleVentaResponseDto toResponseDto(DetalleVenta detalle) {
        return new DetalleVentaResponseDto(
                detalle.getIdDetalleVenta(),
                detalle.getCantidad(),
                detalle.getPrecioUnitario(),
                detalle.getSubtotal(),
                detalle.getVenta().getIdVenta(),
                detalle.getProducto().getIdProducto(),
                detalle.getProducto().getNombre()
        );
    }
}

