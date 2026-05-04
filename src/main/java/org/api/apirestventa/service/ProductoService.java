package org.api.apirestventa.service;

import org.api.apirestventa.dto.ProductoRequestDto;
import org.api.apirestventa.dto.ProductoResponseDto;

import java.util.List;

public interface ProductoService {
    ProductoResponseDto crear(ProductoRequestDto dto);
    List<ProductoResponseDto> listar();
    ProductoResponseDto buscarPorId(Long id);
    ProductoResponseDto actualizar(Long id, ProductoRequestDto dto);
    void eliminar(Long id);
}