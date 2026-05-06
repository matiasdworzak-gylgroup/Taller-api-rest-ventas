package org.api.apirestventa.dto.requestDto;

public record DetalleVentaRequestDto(
        Long idProducto,
        int cantidad
) {
}
