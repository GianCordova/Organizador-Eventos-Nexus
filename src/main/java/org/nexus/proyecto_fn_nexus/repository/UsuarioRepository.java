package org.nexus.proyecto_fn_nexus.repository;

import org.nexus.proyecto_fn_nexus.dominio.dto.UsuarioDto;
import org.nexus.proyecto_fn_nexus.dominio.dto.ModUsuarioDto;

import java.util.List;

public interface UsuarioRepository {

    // Obtener todos los usuarios
    List<UsuarioDto> obtenerTodo();

    // Buscar un usuarios por su ID
    UsuarioDto buscarPorId(Long idUsuario);

    // Guardar un nuevo usuarios
    UsuarioDto guardarUsuario(UsuarioDto usuarioDto);

    // Modificar un usuarios existente
    UsuarioDto modificarUsuario(Long idUsuario, ModUsuarioDto modUsuario);



    // Eliminar un usuarios por ID
    void eliminarUsuario(Long idUsuario);



}
