package org.api.apirestventa.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public record VentaResponseDto(
        Long idVenta,
        LocalDateTime fechaVenta,
        BigDecimal total,
        Long idCliente,
        List<DetalleVentaResponseDto> detalles

) {

}
