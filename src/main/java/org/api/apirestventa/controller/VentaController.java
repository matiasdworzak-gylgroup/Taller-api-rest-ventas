package org.api.apirestventa.controller;

import jakarta.validation.Valid;
import org.api.apirestventa.dto.requestDto.VentaRequestDto;
import org.api.apirestventa.dto.responseDto.VentaResponseDto;
import org.api.apirestventa.service.VentaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    private final VentaService ventaService;

    public VentaController(VentaService ventaService) {
        this.ventaService = ventaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VentaResponseDto crear(@Valid @RequestBody VentaRequestDto dto) {
        return ventaService.crear(dto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<VentaResponseDto> listar(){
        return ventaService.listar();
    }

    @GetMapping("/{id}")
    public VentaResponseDto buscarPorId(@PathVariable Long id) {
        return ventaService.buscarPorId(id);
    }

    @GetMapping("/clientes/{id}")
    public List<VentaResponseDto> buscarVentasPorClienteId(@PathVariable Long id) {
        return ventaService.buscarVentasPorClienteId(id);
    }
}
