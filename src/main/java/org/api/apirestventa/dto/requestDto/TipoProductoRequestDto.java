package org.api.apirestventa.dto.requestDto;

import jakarta.validation.constraints.NotBlank;

public record TipoProductoRequestDto(
        @NotBlank(message = "El nombre es obligatorio")
        String nombre,

        @NotBlank(message = "La descripcion es obligatorio")
        String descripcion
)
{
    public static record LoginRequestDTO(
            @NotBlank(message = "El nombre de usuario es obligatorio y no puede estar vacío")
            String username,
            @NotBlank(message = "La contraseña es obligatoria y no puede estar vacía")
            String password
    ) {}

    public static record RegistroRequestDTO (
            @NotBlank(message = "El nombre de usuario es obligatorio y no puede estar vacío")
            String username,
            @NotBlank(message = "La contraseña es obligatoria y no puede estar vacía")
            String password
    ) {}
}
