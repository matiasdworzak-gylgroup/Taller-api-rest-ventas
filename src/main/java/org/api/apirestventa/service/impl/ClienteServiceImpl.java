package org.api.apirestventa.service.impl;

import org.api.apirestventa.dto.requestDto.ClienteRequestDto;
import org.api.apirestventa.dto.responseDto.ClienteResponseDto;
import org.api.apirestventa.entity.Cliente;
import org.api.apirestventa.exception.RecursoNoEncontradosException;
import org.api.apirestventa.mapper.ClienteMapper;
import org.api.apirestventa.repository.ClienteRepository;
import org.api.apirestventa.service.ClienteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    @Override
    public ClienteResponseDto crear(ClienteRequestDto dto) {
        Cliente cliente = ClienteMapper.toEntity(dto);
        Cliente guardado = clienteRepository.save(cliente);
        return ClienteMapper.toResponseDto(guardado);
    }

    @Override
    public List<ClienteResponseDto> listar() {
        return clienteRepository.findAll()
                .stream()
                .map(ClienteMapper::toResponseDto)
                .toList();
    }

    @Override
    public ClienteResponseDto buscarPorId(Long id) {
        return clienteRepository.findById(id)
                .map(ClienteMapper::toResponseDto)
                .orElseThrow(() -> new RecursoNoEncontradosException(
                        "No se encontró el id: " + id
                ));
    }


    @Override
    public ClienteResponseDto actualizar(Long id, ClienteRequestDto dto){
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradosException(
                        "No se encontró el id: " + id
                ));

        ClienteMapper.updateEntity(cliente,dto);
        Cliente guardado = clienteRepository.save(cliente);
        return ClienteMapper.toResponseDto(guardado);

    }

    @Override
    public void eliminar(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradosException(
                        "No se encontró el id: " + id
                ));

        clienteRepository.delete(cliente);
    }

    @Override
    public List<ClienteResponseDto> buscarPorNombre(String nombre) {
        return Optional.of(clienteRepository.findByNombre(nombre))
                .filter(lista -> !lista.isEmpty())
                .orElseThrow(() -> new RecursoNoEncontradosException("No se encontraron clientes"))
                .stream()
                .map(ClienteMapper::toResponseDto)
                .toList();
    }

}
