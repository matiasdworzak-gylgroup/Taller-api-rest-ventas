package org.api.apirestventa.dto;

import java.math.BigDecimal;

public record DetalleVentaResponseDto(
        Long idDetalleVenta,
        int cantidad,
        BigDecimal precioUnitario,
        BigDecimal subtotal,
        Long idVenta,
        Long idProducto,
        String nombreProducto
) {
}
