package org.api.apirestventa.service;

import org.api.apirestventa.dto.requestDto.LoginRequestDTO;
import org.api.apirestventa.dto.requestDto.RegistroRequestDTO;
import org.api.apirestventa.dto.responseDto.RegistroResponseDTO;
import org.api.apirestventa.dto.responseDto.TokenResponseDTO;

public interface AuthenticationService {
    RegistroResponseDTO registrar(RegistroRequestDTO dto);

    TokenResponseDTO login(LoginRequestDTO dto);
}