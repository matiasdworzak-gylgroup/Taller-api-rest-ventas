package org.api.apirestventa.controller;


import jakarta.validation.Valid;
import org.api.apirestventa.dto.TipoProductoRequestDto;
import org.api.apirestventa.dto.TipoProductoResponseDto;
import org.api.apirestventa.service.TipoProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/api/tipo-producto")
    public class TipoProductoController {

        private final TipoProductoService tipoProductoService;

        public TipoProductoController(TipoProductoService tipoProductoService) {
            this.tipoProductoService = tipoProductoService;
        }

        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public TipoProductoResponseDto crear(@Valid @RequestBody TipoProductoRequestDto dto) {
            return tipoProductoService.crear(dto);
        }

        @GetMapping
        public List<TipoProductoResponseDto> listar() {
            return tipoProductoService.listar();
        }

        @GetMapping("/{id}")
        public TipoProductoResponseDto buscarPorId(@PathVariable Long id) {
            return tipoProductoService.buscarPorId(id);
        }

        @GetMapping("/nombre")
        public List<TipoProductoResponseDto> buscarPorNombre(@RequestParam String nombre) {
            return tipoProductoService.buscarPorNombre(nombre);
        }

        @PutMapping("/{id}")
        public TipoProductoResponseDto actualizar(@PathVariable Long id, @Valid @RequestBody TipoProductoRequestDto dto) {
            return tipoProductoService.actualizar(id, dto);
        }

        @DeleteMapping("/{id}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void eliminar(@PathVariable Long id) {
            tipoProductoService.eliminar(id);
        }

}
