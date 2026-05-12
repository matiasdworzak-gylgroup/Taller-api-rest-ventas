package org.api.apirestventa.mapper;

import org.api.apirestventa.dto.requestDto.LoginRequestDTO;
import org.api.apirestventa.dto.requestDto.RegistroRequestDTO;
import org.api.apirestventa.entity.Role;
import org.api.apirestventa.entity.Usuario;

public class UsuarioMapper {
    public UsuarioMapper() {}

    public static Usuario toEntity(RegistroRequestDTO dto, String password) {
        Usuario usuario = new Usuario();

        usuario.setUsername(dto.username());
        usuario.setPassword(password);
        usuario.setRol(Role.USER);

        return usuario;
    }

    public static void actualizarEntidad(Usuario usuario, LoginRequestDTO dto) {
        usuario.setUsername(dto.username());
        usuario.setPassword(dto.password());
    }
}