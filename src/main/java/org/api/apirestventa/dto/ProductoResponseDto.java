package org.api.apirestventa.dto;

import java.math.BigDecimal;

public record ProductoResponseDto(
        Long id,
        String nombre,
        BigDecimal precio,
        int stock,
        Long idTipoProducto,
        String nombreTipoProducto
) {}
