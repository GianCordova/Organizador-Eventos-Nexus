package org.nexus.proyecto_fn_nexus.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.nexus.proyecto_fn_nexus.dominio.dto.InvitadoDto;
import org.nexus.proyecto_fn_nexus.dominio.dto.ModInvitadoDto;
import org.nexus.proyecto_fn_nexus.persistence.entity.InvitadoEntity;

import java.util.List;

@Mapper(componentModel = "spring", uses = {EstadoAsistenciaMapper.class})
public interface InvitadoMapper {

    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "apellido", target = "apellido")
    @Mapping(source = "correo", target = "correo")
    @Mapping(source = "telefono", target = "telefono")
    @Mapping(source = "estadoAsistencia", target = "estadoAsistencia", qualifiedByName = "generarEstado")
    @Mapping(source = "idEvento", target = "idEvento")
    InvitadoDto toDto(InvitadoEntity entity);

    List<InvitadoDto> toDto(Iterable<InvitadoEntity> entities);

    @InheritInverseConfiguration
    @Mapping(source = "estadoAsistencia", target = "estadoAsistencia", qualifiedByName = "generarEstadoString")
    InvitadoEntity toEntity(InvitadoDto dto);

    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "apellido", target = "apellido")
    @Mapping(source = "correo", target = "correo")
    @Mapping(source = "telefono", target = "telefono")
    @Mapping(source = "estadoAsistencia", target = "estadoAsistencia", qualifiedByName = "generarEstadoString")
    @Mapping(source = "idEvento", target = "idEvento")
    void modificarEntityFromDto(ModInvitadoDto mod, @MappingTarget InvitadoEntity entity);
}