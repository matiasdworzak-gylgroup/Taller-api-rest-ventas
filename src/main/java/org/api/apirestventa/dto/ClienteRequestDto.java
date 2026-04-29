package org.api.apirestventa.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ClienteRequestDto(
        @NotBlank(message = "El nombre no puede estar vacio")
        String nombre,

        @NotBlank(message = "El nombre no puede estar vacio")
        String apellido,

        @Email(message = "El mail tiene que contener @ y terminar con .com")
        @NotBlank(message = "El correo no puede estar vacio")
        String correo,

        @NotBlank(message = "El telefono no puede estar vacio")
        String telefono,

        @NotBlank(message = "La direccion no puede estar vacio")
        String direccion
) {
}
