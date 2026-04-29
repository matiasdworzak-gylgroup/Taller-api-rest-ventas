package org.api.apirestventa.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductoRequestDto(

        @NotBlank(message = "El nombre es obligatorio")
        String nombre,

        @NotNull(message = "El precio es obligatorio")
        @DecimalMin(value = "0.01", message = "El precio debe ser mayor a cero")
        BigDecimal precio,

        @Min(value = 0, message = "El stock no puede ser negativo")
        int stock,

        @NotNull(message = "El id del tipo de producto es obligatorio")
        Long idTipoProducto
) {}