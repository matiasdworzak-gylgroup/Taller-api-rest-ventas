package org.api.apirestventa.dto;

import org.api.apirestventa.entity.DetalleVenta;

import java.util.List;

public record VentaRequestDto (
        Long idCliente,
        List<DetalleVentaRequestDto> detalles
){
}
