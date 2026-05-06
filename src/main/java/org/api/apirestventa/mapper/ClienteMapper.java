package org.api.apirestventa.mapper;

import org.api.apirestventa.dto.requestDto.ClienteRequestDto;
import org.api.apirestventa.dto.responseDto.ClienteResponseDto;
import org.api.apirestventa.entity.Cliente;

public class ClienteMapper {

    private ClienteMapper() {}

    public static Cliente toEntity(ClienteRequestDto dto){
        Cliente cliente = new Cliente();
        cliente.setNombre(dto.nombre());
        cliente.setApellido(dto.apellido());
        cliente.setCorreo(dto.correo());
        cliente.setTelefono(dto.telefono());
        cliente.setDireccion(dto.direccion());
        return cliente;
    }

    public static ClienteResponseDto toResponseDto(Cliente cliente){
        return new ClienteResponseDto(
                cliente.getIdCliente(),
                cliente.getNombre(),
                cliente.getApellido(),
                cliente.getCorreo(),
                cliente.getTelefono(),
                cliente.getDireccion()
        );
    }

    public static void updateEntity(Cliente cliente, ClienteRequestDto dto){
        cliente.setNombre(dto.nombre());
        cliente.setApellido(dto.apellido());
        cliente.setCorreo(dto.correo());
        cliente.setTelefono(dto.telefono());
        cliente.setDireccion(dto.direccion());
    }
}
