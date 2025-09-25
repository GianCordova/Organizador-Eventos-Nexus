package org.nexus.proyecto_fn_nexus.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.nexus.proyecto_fn_nexus.dominio.dto.RecursoDto;
import org.nexus.proyecto_fn_nexus.dominio.dto.ModificarRecursoDto;
import org.nexus.proyecto_fn_nexus.persistence.entity.RecursoEntity;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoriaRecursoMapper.class})
public interface RecursoMapper {

    // Entity -> DTO
    @Mapping(source = "nombreRecurso", target = "resourceName")
    @Mapping(source = "categoria", target = "category", qualifiedByName = "generarCategoria") // CategoriaRecurso -> String
    @Mapping(source = "stock", target = "stock")
    @Mapping(source = "precioAlquiler", target = "rentalPrice")
    RecursoDto toDto(RecursoEntity entity);

    List<RecursoDto> toDto(Iterable<RecursoEntity> entities);

    // DTO -> Entity
    @InheritInverseConfiguration
    @Mapping(source = "category", target = "categoria", qualifiedByName = "generarCategory") // String -> CategoriaRecurso
    RecursoEntity toEntity(RecursoDto dto);

    // Modificación parcial
    @Mapping(source = "resourceName", target = "nombreRecurso")
    @Mapping(source = "category", target = "categoria", qualifiedByName = "generarCategoria") // String -> CategoriaRecurso
    @Mapping(source = "stock", target = "stock")
    @Mapping(source = "rentalPrice", target = "precioAlquiler")
    void modificarEntityFromDto(ModificarRecursoDto mod, @MappingTarget RecursoEntity entity);
}
