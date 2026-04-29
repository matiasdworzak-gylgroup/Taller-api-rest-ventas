package org.api.apirestventa.mapper;

import org.api.apirestventa.dto.ClienteRequestDto;
import org.api.apirestventa.dto.ClienteResponseDto;
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
                cliente.getId_cliente(),
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
