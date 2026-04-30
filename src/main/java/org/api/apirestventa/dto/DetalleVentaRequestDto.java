package org.api.apirestventa.dto;

public record DetalleVentaRequestDto(
        Long idProducto,
        int cantidad
) {
}
