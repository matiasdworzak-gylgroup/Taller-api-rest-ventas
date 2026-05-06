package org.api.apirestventa.service;

import org.api.apirestventa.dto.requestDto.VentaRequestDto;
import org.api.apirestventa.dto.responseDto.VentaResponseDto;

import java.util.List;

public interface VentaService {
    VentaResponseDto crear(VentaRequestDto dto);
    List<VentaResponseDto> listar();
    VentaResponseDto buscarPorId(Long id);
    List<VentaResponseDto> buscarVentasPorClienteId(Long idCliente);
}
