package org.api.apirestventa.dto;

import jakarta.validation.constraints.NotBlank;

public record TipoProductoRequestDto(
        @NotBlank(message = "El nombre es obligatorio")
        String nombre,

        @NotBlank(message = "La descripcion es obligatorio")
        String descripcion
)
{
}
