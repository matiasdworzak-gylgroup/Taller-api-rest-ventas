package org.api.apirestventa.service;

import org.api.apirestventa.dto.DetalleVentaResponseDto;
import org.api.apirestventa.dto.VentaRequestDto;
import org.api.apirestventa.dto.VentaResponseDto;

import java.util.List;

public interface VentaService {
    VentaResponseDto crear(VentaRequestDto dto);
}
