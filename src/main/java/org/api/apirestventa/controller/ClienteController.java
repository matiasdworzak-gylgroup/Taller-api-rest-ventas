package org.api.apirestventa.controller;

import jakarta.validation.Valid;
import org.api.apirestventa.dto.requestDto.ClienteRequestDto;
import org.api.apirestventa.dto.responseDto.ClienteResponseDto;
import org.api.apirestventa.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public  ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteResponseDto crear(@Valid @RequestBody ClienteRequestDto dto){
        return clienteService.crear(dto);
    }

    @GetMapping
    public List<ClienteResponseDto> listar(){
        return clienteService.listar();
    }

    @GetMapping("/{id}")
    public ClienteResponseDto buscarPorId(@PathVariable Long id){
        return clienteService.buscarPorId(id);
    }

    @GetMapping("/nombre")
    public List<ClienteResponseDto> buscarPorNombre(@RequestParam String nombre){
        return clienteService.buscarPorNombre(nombre);
    }

    @PutMapping("/{idBuscado}")
    public ClienteResponseDto actualizar(@PathVariable Long idBuscado, @Valid @RequestBody ClienteRequestDto dto) {
        return clienteService.actualizar(idBuscado, dto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{idBuscado}")
    public void eliminar(@PathVariable Long idBuscado) {
        clienteService.eliminar(idBuscado);
    }

}
