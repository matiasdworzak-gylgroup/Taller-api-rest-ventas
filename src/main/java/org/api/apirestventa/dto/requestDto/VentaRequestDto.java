package org.api.apirestventa.dto.requestDto;

import java.util.List;

public record VentaRequestDto (
        Long idCliente,
        List<DetalleVentaRequestDto> detalles
){
}
