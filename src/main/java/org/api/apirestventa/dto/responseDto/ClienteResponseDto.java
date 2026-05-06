package org.api.apirestventa.dto.responseDto;

public record ClienteResponseDto(
        Long idCliente,
        String nombre,
        String apellido,
        String correo,
        String telefono,
        String direccion
) {

}
