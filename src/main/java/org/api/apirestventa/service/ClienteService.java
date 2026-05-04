package org.api.apirestventa.service;

import org.api.apirestventa.dto.ClienteRequestDto;
import org.api.apirestventa.dto.ClienteResponseDto;

import java.util.List;

public interface ClienteService {

    ClienteResponseDto crear(ClienteRequestDto dto);

    List<ClienteResponseDto> listar();

    ClienteResponseDto buscarPorId(Long id);

    ClienteResponseDto actualizar(Long id, ClienteRequestDto dto);

    void eliminar(Long id);

    List<ClienteResponseDto> buscarPorNombre(String nombre);
}
