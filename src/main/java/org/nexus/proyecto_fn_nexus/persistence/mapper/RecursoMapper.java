package org.nexus.proyecto_fn_nexus.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.nexus.proyecto_fn_nexus.dominio.dto.RecursoDto;
import org.nexus.proyecto_fn_nexus.persistence.entity.RecursoEntity;
import org.nexus.proyecto_fn_nexus.dominio.dto.ModificarRecursoDto;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoriaRecursoMapper.class})
public interface RecursoMapper {

    @Mapping(source = "nombreRecurso", target = "resourceName")
    @Mapping(source = "categoria", target = "category", qualifiedByName = "generarCategory")
    @Mapping(source = "stock", target = "stock")
    @Mapping(source = "precioAlquiler", target = "rentalPrice")
    RecursoDto toDto(RecursoEntity entity);

    List<RecursoDto> toDto(Iterable<RecursoEntity> entities);

    @InheritInverseConfiguration
    @Mapping(source = "category", target = "categoria", qualifiedByName = "generarCategoria")
    RecursoEntity toEntity(RecursoDto dto);

    @Mapping(source = "stock", target = "stock")
    @Mapping(source = "rentalPrice", target = "precioAlquiler")
    void modificarEntityFromDto(ModificarRecursoDto mod, @MappingTarget RecursoEntity entity);
}
