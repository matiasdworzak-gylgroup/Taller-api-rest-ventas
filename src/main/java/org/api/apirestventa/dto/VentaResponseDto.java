package org.api.apirestventa.dto;

import org.api.apirestventa.entity.Cliente;
import org.api.apirestventa.entity.DetalleVenta;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public record VentaResponseDto(
        Long idVenta,
        Date fechaVenta,
        BigDecimal total,
        Long idCliente,
        List<DetalleVenta> detalles

) {

}
