package org.api.apirestventa.controller;

import jakarta.validation.Valid;
import org.api.apirestventa.dto.VentaRequestDto;
import org.api.apirestventa.dto.VentaResponseDto;
import org.api.apirestventa.service.VentaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    private final VentaService ventaService;

    public VentaController(VentaService ventaService){
        this.ventaService = ventaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VentaResponseDto crear(@Valid @RequestBody VentaRequestDto dto) {
        return ventaService.crear(dto);
    }

}
