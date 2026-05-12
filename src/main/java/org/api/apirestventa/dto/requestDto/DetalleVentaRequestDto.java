package org.api.apirestventa.dto.requestDto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record DetalleVentaRequestDto(
        @NotNull(message = "El id del producto es obligatorio")
        Long idProducto,
        @Min(value = 1, message = "La cantidad debe ser al menos 1")
        int cantidad
) {
}
