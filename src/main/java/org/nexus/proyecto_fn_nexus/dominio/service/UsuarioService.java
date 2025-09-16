package org.nexus.proyecto_fn_nexus.dominio.service;

import org.nexus.proyecto_fn_nexus.dominio.dto.UsuarioDto;
import org.nexus.proyecto_fn_nexus.dominio.dto.ModUsuarioDto;
import org.nexus.proyecto_fn_nexus.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Obtener todos los eventos
    public List<UsuarioDto> obtenerTodo() {
        return this.usuarioRepository.obtenerTodo();
    }

    // Buscar evento por ID
    public UsuarioDto buscarPorId(Long idUsuario) {
        return this.usuarioRepository.buscarPorId(idUsuario);
    }

    // Guardar un nuevo evento
    public UsuarioDto guardarUsuario(UsuarioDto usuarioDto) {
        return this.usuarioRepository.guardarUsuario(usuarioDto);
    }

    // Modificar un evento existente
    public UsuarioDto modificarUsuario(Long idUsuario, ModUsuarioDto modUsuario) {
        return this.usuarioRepository.modificarUsuario(idUsuario, modUsuario);
    }

    // Eliminar un Usuario
    public void eliminarUsuario(Long idUsuario) {this.usuarioRepository.eliminarUsuario(idUsuario);
    }
}

