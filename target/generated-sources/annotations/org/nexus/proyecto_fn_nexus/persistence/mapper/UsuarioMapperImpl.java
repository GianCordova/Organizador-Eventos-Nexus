package org.nexus.proyecto_fn_nexus.persistence.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.nexus.proyecto_fn_nexus.dominio.Rol;
import org.nexus.proyecto_fn_nexus.dominio.dto.ModUsuarioDto;
import org.nexus.proyecto_fn_nexus.dominio.dto.UsuarioDto;
import org.nexus.proyecto_fn_nexus.persistence.entity.UsuarioEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-24T11:25:25-0600",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21 (Oracle Corporation)"
)
@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public UsuarioDto toDto(UsuarioEntity usuario) {
        if ( usuario == null ) {
            return null;
        }

        String nombre = null;
        String apellido = null;
        String email = null;
        String password = null;
        Rol rol = null;
        Long idUsuario = null;

        nombre = usuario.getNombre();
        apellido = usuario.getApellido();
        email = usuario.getEmail();
        password = usuario.getPassword();
        if ( usuario.getRol() != null ) {
            rol = RolMapper.stringToRol( usuario.getRol().name() );
        }
        if ( usuario.getIdUsuario() != null ) {
            idUsuario = usuario.getIdUsuario().longValue();
        }

        UsuarioDto usuarioDto = new UsuarioDto( idUsuario, nombre, apellido, email, password, rol );

        return usuarioDto;
    }

    @Override
    public List<UsuarioDto> toDto(Iterable<UsuarioEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<UsuarioDto> list = new ArrayList<UsuarioDto>();
        for ( UsuarioEntity usuarioEntity : entities ) {
            list.add( toDto( usuarioEntity ) );
        }

        return list;
    }

    @Override
    public UsuarioEntity toEntity(UsuarioDto dto) {
        if ( dto == null ) {
            return null;
        }

        UsuarioEntity usuarioEntity = new UsuarioEntity();

        if ( dto.rol() != null ) {
            usuarioEntity.setRol( Enum.valueOf( Rol.class, RolMapper.rolToString( dto.rol() ) ) );
        }
        usuarioEntity.setNombre( dto.nombre() );
        usuarioEntity.setApellido( dto.apellido() );
        usuarioEntity.setEmail( dto.email() );
        usuarioEntity.setPassword( dto.password() );
        if ( dto.idUsuario() != null ) {
            usuarioEntity.setIdUsuario( dto.idUsuario().intValue() );
        }

        return usuarioEntity;
    }

    @Override
    public void modificarEntityFromDto(ModUsuarioDto mod, UsuarioEntity entity) {
        if ( mod == null ) {
            return;
        }

        entity.setNombre( mod.nombre() );
        entity.setApellido( mod.apellido() );
        entity.setEmail( mod.email() );
        entity.setPassword( mod.password() );
        if ( mod.rol() != null ) {
            entity.setRol( RolMapper.stringToRol( mod.rol().name() ) );
        }
        else {
            entity.setRol( null );
        }
    }
}
