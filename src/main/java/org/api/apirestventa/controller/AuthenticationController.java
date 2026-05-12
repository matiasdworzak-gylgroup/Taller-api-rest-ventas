package org.api.apirestventa.controller;

import org.api.apirestventa.dto.requestDto.LoginRequestDTO;
import org.api.apirestventa.dto.requestDto.RegistroRequestDTO;
import org.api.apirestventa.dto.responseDto.RegistroResponseDTO;
import org.api.apirestventa.dto.responseDto.TokenResponseDTO;
import org.api.apirestventa.service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public RegistroResponseDTO registrar(@Valid @RequestBody RegistroRequestDTO dto) {
        return authenticationService.registrar(dto);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public TokenResponseDTO autenticar(@Valid @RequestBody LoginRequestDTO dto) {
        return authenticationService.login(dto);
    }
}