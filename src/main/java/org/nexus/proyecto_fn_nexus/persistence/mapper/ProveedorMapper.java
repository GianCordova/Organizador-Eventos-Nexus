package org.nexus.proyecto_fn_nexus.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.nexus.proyecto_fn_nexus.dominio.dto.ModProveedorDto;
import org.nexus.proyecto_fn_nexus.dominio.dto.ProveedorDto;
import org.nexus.proyecto_fn_nexus.persistence.entity.ProveedorEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProveedorMapper {

    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "direccion", target = "direccion")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "telefono", target = "telefono")
    ProveedorDto toDto(ProveedorEntity entity);

    List<ProveedorDto> toDto(Iterable<ProveedorEntity> entities);

    @InheritInverseConfiguration
    ProveedorEntity toEntity(ProveedorDto dto);

    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "direccion", target = "direccion")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "telefono", target = "telefono")
    void modificarEntityFromDto(ModProveedorDto mod, @MappingTarget ProveedorEntity entity);

}
