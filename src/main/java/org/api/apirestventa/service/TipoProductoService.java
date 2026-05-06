package org.api.apirestventa.service;

import org.api.apirestventa.dto.requestDto.TipoProductoRequestDto;
import org.api.apirestventa.dto.responseDto.TipoProductoResponseDto;

import java.util.List;

public interface TipoProductoService {
    TipoProductoResponseDto crear(TipoProductoRequestDto dto);

    List<TipoProductoResponseDto> listar();

    TipoProductoResponseDto buscarPorId(Long id);

    TipoProductoResponseDto actualizar(Long id, TipoProductoRequestDto dto);

    void eliminar(Long id);

    List<TipoProductoResponseDto> buscarPorNombre(String nombre);}
