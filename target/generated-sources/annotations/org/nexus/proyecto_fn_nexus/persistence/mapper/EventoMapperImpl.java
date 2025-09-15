package org.nexus.proyecto_fn_nexus.persistence.mapper;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.nexus.proyecto_fn_nexus.dominio.Estado;
import org.nexus.proyecto_fn_nexus.dominio.TipoEvento;
import org.nexus.proyecto_fn_nexus.dominio.dto.EventoDto;
import org.nexus.proyecto_fn_nexus.dominio.dto.ModEventoDto;
import org.nexus.proyecto_fn_nexus.persistence.entity.EventoEntity;
import org.nexus.proyecto_fn_nexus.persistence.entity.UsuarioEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-14T18:19:22-0600",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.7 (Oracle Corporation)"
)
@Component
public class EventoMapperImpl implements EventoMapper {

    @Override
    public EventoDto toDto(EventoEntity entity) {
        if ( entity == null ) {
            return null;
        }

        String nombreEvento = null;
        String descripcion = null;
        LocalDate fecha = null;
        String lugar = null;
        Estado estado = null;
        LocalTime duracion = null;
        TipoEvento tipoEvento = null;
        BigDecimal costoEvento = null;
        Long idUsuario = null;
        Long idEvento = null;

        nombreEvento = entity.getNombreEvento();
        descripcion = entity.getDescripcion();
        fecha = entity.getFecha();
        lugar = entity.getLugar();
        if ( entity.getEstado() != null ) {
            estado = EstadoMapper.stringToEstado( entity.getEstado().name() );
        }
        duracion = entity.getDuracion();
        if ( entity.getTipoEvento() != null ) {
            tipoEvento = TipoEventoMapper.stringToTipoEvento( entity.getTipoEvento().name() );
        }
        costoEvento = entity.getCostoEvento();
        Integer idUsuario1 = entityUsuarioIdUsuario( entity );
        if ( idUsuario1 != null ) {
            idUsuario = idUsuario1.longValue();
        }
        idEvento = entity.getIdEvento();

        EventoDto eventoDto = new EventoDto( idEvento, nombreEvento, descripcion, fecha, lugar, estado, duracion, tipoEvento, costoEvento, idUsuario );

        return eventoDto;
    }

    @Override
    public List<EventoDto> toDto(Iterable<EventoEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<EventoDto> list = new ArrayList<EventoDto>();
        for ( EventoEntity eventoEntity : entities ) {
            list.add( toDto( eventoEntity ) );
        }

        return list;
    }

    @Override
    public EventoEntity toEntity(EventoDto dto) {
        if ( dto == null ) {
            return null;
        }

        EventoEntity eventoEntity = new EventoEntity();

        eventoEntity.setUsuario( eventoDtoToUsuarioEntity( dto ) );
        if ( dto.estado() != null ) {
            eventoEntity.setEstado( Enum.valueOf( Estado.class, EstadoMapper.estadoToString( dto.estado() ) ) );
        }
        if ( dto.tipoEvento() != null ) {
            eventoEntity.setTipoEvento( Enum.valueOf( TipoEvento.class, TipoEventoMapper.tipoEventoToString( dto.tipoEvento() ) ) );
        }
        eventoEntity.setNombreEvento( dto.nombreEvento() );
        eventoEntity.setDescripcion( dto.descripcion() );
        eventoEntity.setFecha( dto.fecha() );
        eventoEntity.setLugar( dto.lugar() );
        eventoEntity.setDuracion( dto.duracion() );
        eventoEntity.setCostoEvento( dto.costoEvento() );
        eventoEntity.setIdEvento( dto.idEvento() );

        return eventoEntity;
    }

    @Override
    public void modificarEntityFromDto(ModEventoDto mod, EventoEntity entity) {
        if ( mod == null ) {
            return;
        }

        entity.setNombreEvento( mod.nombreEvento() );
        entity.setDescripcion( mod.descripcion() );
        entity.setFecha( mod.fecha() );
        entity.setLugar( mod.lugar() );
        entity.setEstado( EstadoMapper.stringToEstado( mod.estado() ) );
        entity.setDuracion( mod.duracion() );
        entity.setTipoEvento( TipoEventoMapper.stringToTipoEvento( mod.tipoEvento() ) );
        entity.setCostoEvento( mod.costoEvento() );
    }

    private Integer entityUsuarioIdUsuario(EventoEntity eventoEntity) {
        UsuarioEntity usuario = eventoEntity.getUsuario();
        if ( usuario == null ) {
            return null;
        }
        return usuario.getIdUsuario();
    }

    protected UsuarioEntity eventoDtoToUsuarioEntity(EventoDto eventoDto) {
        if ( eventoDto == null ) {
            return null;
        }

        UsuarioEntity usuarioEntity = new UsuarioEntity();

        if ( eventoDto.idUsuario() != null ) {
            usuarioEntity.setIdUsuario( eventoDto.idUsuario().intValue() );
        }

        return usuarioEntity;
    }
}
