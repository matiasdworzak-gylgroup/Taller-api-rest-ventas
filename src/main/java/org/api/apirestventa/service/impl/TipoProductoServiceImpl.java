package org.api.apirestventa.service.impl;

import org.api.apirestventa.dto.requestDto.TipoProductoRequestDto;
import org.api.apirestventa.dto.responseDto.TipoProductoResponseDto;
import org.api.apirestventa.entity.TipoProducto;
import org.api.apirestventa.exception.RecursoNoEncontradosException;
import org.api.apirestventa.mapper.TipoProductoMapper;
import org.api.apirestventa.repository.TipoProductoRepository;
import org.api.apirestventa.service.TipoProductoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoProductoServiceImpl implements TipoProductoService {
    private final TipoProductoRepository tipoProductoRepository;

    public TipoProductoServiceImpl(TipoProductoRepository tipoProductoRepository) {
        this.tipoProductoRepository = tipoProductoRepository;
    }

    @Override
    public TipoProductoResponseDto crear(TipoProductoRequestDto dto) {
        TipoProducto tipo = TipoProductoMapper.toEntity(dto);
        TipoProducto guardado = tipoProductoRepository.save(tipo);
        return TipoProductoMapper.toResponseDto(guardado);
    }

    @Override
    public List<TipoProductoResponseDto> listar() {
        return tipoProductoRepository.findAll()
                .stream()
                .map(TipoProductoMapper::toResponseDto)
                .toList();
    }

    @Override
    public TipoProductoResponseDto buscarPorId(Long id) {
        return tipoProductoRepository.findById(id)
                .map(TipoProductoMapper::toResponseDto)
                .orElseThrow(() -> new RecursoNoEncontradosException(
                        "No se encontró el tipo de producto con id: " + id
                ));
    }

    @Override
    public TipoProductoResponseDto actualizar(Long id, TipoProductoRequestDto dto) {
        TipoProducto tipo = tipoProductoRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradosException(
                        "No se encontró el tipo de producto con id: " + id
                ));

        TipoProductoMapper.updateEntity(tipo, dto);
        TipoProducto guardado = tipoProductoRepository.save(tipo);
        return TipoProductoMapper.toResponseDto(guardado);
    }

    @Override
    public void eliminar(Long id) {
        TipoProducto tipo = tipoProductoRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradosException(
                        "No se encontró el tipo de producto con id: " + id
                ));

        tipoProductoRepository.delete(tipo);
    }

    @Override
    public List<TipoProductoResponseDto> buscarPorNombre(String nombre) {
        return tipoProductoRepository.findByNombre(nombre)
                .stream()
                .map(TipoProductoMapper::toResponseDto)
                .toList();
    }

}
