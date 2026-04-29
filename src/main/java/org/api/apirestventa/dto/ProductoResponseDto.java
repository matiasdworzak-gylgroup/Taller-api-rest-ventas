package org.api.apirestventa.dto;

import java.math.BigDecimal;

public record ProductoResponseDto(
        Long id,
        String nombre,
        BigDecimal precio,
        int stock,
        Long idTipoProducto,
        String nombreTipoProducto // Sumamos esto para que el Front no tenga que adivinar qué es el ID
) {}
