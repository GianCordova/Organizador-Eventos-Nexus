package org.nexus.proyecto_fn_nexus.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import org.nexus.proyecto_fn_nexus.dominio.dto.EventoDto;
import org.nexus.proyecto_fn_nexus.dominio.dto.ModEventoDto;
import org.nexus.proyecto_fn_nexus.persistence.entity.EventoEntity;

import java.util.List;

@Mapper(componentModel = "spring", uses = {EstadoMapper.class, TipoEventoMapper.class})
public interface EventoMapper {

    // Mapea EventoEntity a EventoDto
    @Mapping(source = "nombreEvento", target = "nombreEvento")
    @Mapping(source = "descripcion", target = "descripcion")
    @Mapping(source = "fecha", target = "fecha")
    @Mapping(source = "lugar", target = "lugar")
    @Mapping(source = "estado", target = "estado", qualifiedByName = "stringToEstado")
    @Mapping(source = "duracion", target = "duracion")
    @Mapping(source = "tipoEvento", target = "tipoEvento", qualifiedByName = "stringToTipoEvento")
    @Mapping(source = "costoEvento", target = "costoEvento")
    @Mapping(source = "usuario.idUsuario", target = "idUsuario")
    EventoDto toDto(EventoEntity entity);

    // Mapea lista de entidades a lista de DTOs
    List<EventoDto> toDto(Iterable<EventoEntity> entities);

    // Mapea EventoDto a EventoEntity
    @InheritInverseConfiguration
    @Mapping(source = "estado", target = "estado", qualifiedByName = "estadoToString")
    @Mapping(source = "tipoEvento", target = "tipoEvento", qualifiedByName = "tipoEventoToString")
    EventoEntity toEntity(EventoDto dto);

    // Modifica una entidad existente con datos de ModEventoDto
    @Mapping(source = "nombreEvento", target = "nombreEvento")
    @Mapping(source = "descripcion", target = "descripcion")
    @Mapping(source = "fecha", target = "fecha")
    @Mapping(source = "lugar", target = "lugar")
    @Mapping(source = "estado", target = "estado", qualifiedByName = "stringToEstado")
    @Mapping(source = "duracion", target = "duracion")
    @Mapping(source = "tipoEvento", target = "tipoEvento", qualifiedByName = "stringToTipoEvento")
    @Mapping(source = "costoEvento", target = "costoEvento")
    void modificarEntityFromDto(ModEventoDto mod, @MappingTarget EventoEntity entity);
}
