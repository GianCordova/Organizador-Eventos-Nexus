package org.nexus.proyecto_fn_nexus.persistence;



import org.nexus.proyecto_fn_nexus.dominio.dto.ModUsuarioDto;
import org.nexus.proyecto_fn_nexus.dominio.dto.UsuarioDto;

import org.nexus.proyecto_fn_nexus.dominio.exception.EventoNoExisteException;
import org.nexus.proyecto_fn_nexus.dominio.exception.UsuarioNoExisteException;
import org.nexus.proyecto_fn_nexus.dominio.exception.UsuarioYaExisteException;
import org.nexus.proyecto_fn_nexus.persistence.crud.CrudUsuarioEntity;
import org.nexus.proyecto_fn_nexus.persistence.entity.UsuarioEntity;
import org.nexus.proyecto_fn_nexus.persistence.mapper.UsuarioMapper;
import org.nexus.proyecto_fn_nexus.repository.UsuarioRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UsuarioEntityRepository implements UsuarioRepository {

    private final CrudUsuarioEntity crudUsuarioEntity;
    private final UsuarioMapper usuarioMapper;


    public UsuarioEntityRepository(CrudUsuarioEntity crudUsuarioEntity, UsuarioMapper usuarioMapper) {
        this.crudUsuarioEntity = crudUsuarioEntity;

        this.usuarioMapper = usuarioMapper;

    }
    @Override
    public List<UsuarioDto> obtenerTodo() {
        return this.usuarioMapper.toDto(this.crudUsuarioEntity.findAll());
    }

    @Override
    public UsuarioDto buscarPorId(Long idUsuario) {
        return this.usuarioMapper.toDto(this.crudUsuarioEntity.findById(idUsuario).orElse(null));
    }

    @Override
    public UsuarioDto guardarUsuario(UsuarioDto usuarioDto) {
        if (this.crudUsuarioEntity.findUsuarioEntitiesByNombre(usuarioDto.nombre()) != null) {
            throw new UsuarioYaExisteException(usuarioDto.nombre());
        }

        // Convertimos DTO a Entity
        UsuarioEntity usuario = this.usuarioMapper.toEntity(usuarioDto);

        // Guardamos en la base de datos
        this.crudUsuarioEntity.save(usuario);

        // Retornamos como DTO
        return this.usuarioMapper.toDto(usuario);
    }

    @Override
    public UsuarioDto modificarUsuario(Long idUsuario, ModUsuarioDto modUsuario) {
        UsuarioEntity usuario = this.crudUsuarioEntity.findById(idUsuario).orElse(null);

        if (usuario == null) {
            throw new UsuarioNoExisteException(idUsuario);
        }

        // Actualizamos entidad con datos del DTO
        this.usuarioMapper.modificarEntityFromDto(modUsuario, usuario);

        return this.usuarioMapper.toDto(this.crudUsuarioEntity.save(usuario));
    }

    @Override
    public void eliminarUsuario(Long idUsuario) {
        UsuarioEntity usuario = this.crudUsuarioEntity.findById(idUsuario).orElse(null);

        if (usuario == null) {
            throw new EventoNoExisteException(idUsuario);
        }

        this.crudUsuarioEntity.delete(usuario);
    }
}
