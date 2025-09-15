package org.nexus.proyecto_fn_nexus.persistence.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.nexus.proyecto_fn_nexus.dominio.EstadoAsistencia;
import org.nexus.proyecto_fn_nexus.dominio.dto.InvitadoDto;
import org.nexus.proyecto_fn_nexus.dominio.dto.ModInvitadoDto;
import org.nexus.proyecto_fn_nexus.persistence.entity.InvitadoEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-14T19:11:38-0600",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.7 (Oracle Corporation)"
)
@Component
public class InvitadoMapperImpl implements InvitadoMapper {

    @Override
    public InvitadoDto toDto(InvitadoEntity entity) {
        if ( entity == null ) {
            return null;
        }

        String nombre = null;
        String apellido = null;
        String correo = null;
        String telefono = null;
        String estadoAsistencia = null;
        Integer idEvento = null;
        Integer idInvitado = null;

        nombre = entity.getNombre();
        apellido = entity.getApellido();
        correo = entity.getCorreo();
        telefono = entity.getTelefono();
        if ( entity.getEstadoAsistencia() != null ) {
            estadoAsistencia = EstadoAsistenciaMapper.generarEstado( entity.getEstadoAsistencia() ).name();
        }
        idEvento = entity.getIdEvento();
        idInvitado = entity.getIdInvitado();

        InvitadoDto invitadoDto = new InvitadoDto( idInvitado, nombre, apellido, correo, telefono, estadoAsistencia, idEvento );

        return invitadoDto;
    }

    @Override
    public List<InvitadoDto> toDto(Iterable<InvitadoEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<InvitadoDto> list = new ArrayList<InvitadoDto>();
        for ( InvitadoEntity invitadoEntity : entities ) {
            list.add( toDto( invitadoEntity ) );
        }

        return list;
    }

    @Override
    public InvitadoEntity toEntity(InvitadoDto dto) {
        if ( dto == null ) {
            return null;
        }

        InvitadoEntity invitadoEntity = new InvitadoEntity();

        if ( dto.estadoAsistencia() != null ) {
            invitadoEntity.setEstadoAsistencia( EstadoAsistenciaMapper.generarEstadoString( Enum.valueOf( EstadoAsistencia.class, dto.estadoAsistencia() ) ) );
        }
        invitadoEntity.setNombre( dto.nombre() );
        invitadoEntity.setApellido( dto.apellido() );
        invitadoEntity.setCorreo( dto.correo() );
        invitadoEntity.setTelefono( dto.telefono() );
        invitadoEntity.setIdEvento( dto.idEvento() );
        invitadoEntity.setIdInvitado( dto.idInvitado() );

        return invitadoEntity;
    }

    @Override
    public void modificarEntityFromDto(ModInvitadoDto mod, InvitadoEntity entity) {
        if ( mod == null ) {
            return;
        }

        entity.setNombre( mod.nombre() );
        entity.setApellido( mod.apellido() );
        entity.setCorreo( mod.correo() );
        entity.setTelefono( mod.telefono() );
        if ( mod.estadoAsistencia() != null ) {
            entity.setEstadoAsistencia( EstadoAsistenciaMapper.generarEstadoString( Enum.valueOf( EstadoAsistencia.class, mod.estadoAsistencia() ) ) );
        }
        else {
            entity.setEstadoAsistencia( null );
        }
        entity.setIdEvento( mod.idEvento() );
    }
}
