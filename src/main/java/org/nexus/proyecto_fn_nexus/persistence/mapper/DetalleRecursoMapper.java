package org.nexus.proyecto_fn_nexus.persistence.mapper;

import org.mapstruct.*;
import org.nexus.proyecto_fn_nexus.dominio.dto.DetalleRecursoDto;
import org.nexus.proyecto_fn_nexus.dominio.dto.ModDetalleRecursoDto;
import org.nexus.proyecto_fn_nexus.persistence.entity.DetalleRecursoEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DetalleRecursoMapper {

    @Mapping(source = "evento.idEvento", target = "idEvento")
    @Mapping(source = "recurso.idRecurso", target = "idRecurso")
    DetalleRecursoDto toDto(DetalleRecursoEntity entity);

    List<DetalleRecursoDto> toDto(Iterable<DetalleRecursoEntity> entities);

    @InheritInverseConfiguration
    DetalleRecursoEntity toEntity(DetalleRecursoDto dto);

    @Mapping(source = "idEvento", target = "evento.idEvento")
    @Mapping(source = "idRecurso", target = "recurso.idRecurso")
    void actualizarEntityDesdeDto(ModDetalleRecursoDto mod, @MappingTarget DetalleRecursoEntity entity);
}