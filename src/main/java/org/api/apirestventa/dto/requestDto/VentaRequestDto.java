package org.api.apirestventa.dto.requestDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record VentaRequestDto (
        @NotNull(message = "El id del cliente es obligatorio")
        Long idCliente,
        @NotEmpty(message = "La lista de detalles no puede estar vacía")
        @Valid
        List<DetalleVentaRequestDto> detalles
){
        public static record RegistroResponseDTO(String usuario,
                                                 String passEncript
        ) {}

        public static record TokenResponseDTO(String tokenJwt) {}
}
