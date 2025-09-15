package org.nexus.proyecto_fn_nexus.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import org.mapstruct.MappingTarget;
import org.nexus.proyecto_fn_nexus.dominio.dto.ModUsuarioDto;
import org.nexus.proyecto_fn_nexus.dominio.dto.UsuarioDto;
import org.nexus.proyecto_fn_nexus.persistence.entity.UsuarioEntity;

import java.util.List;

@Mapper(componentModel = "spring", uses = {RolMapper.class})
public interface UsuarioMapper {

    // Mapea UsuariosEntity a UsuarioDto
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "apellido", target = "apellido")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "rol", target = "rol", qualifiedByName = "stringToRol")
    UsuarioDto toDto(UsuarioEntity usuario);

    // Mapea lista de entidades a lista de DTOs
    List<UsuarioDto> toDto(Iterable<UsuarioEntity> entities);

    // Mapea UsuarioDto a UsuarioEntity
    @InheritInverseConfiguration
    @Mapping(source = "rol", target = "rol", qualifiedByName = "rolToString")
    UsuarioEntity toEntity(UsuarioDto dto);

    // Modifica una entidad existente con datos de ModUsuarioDto
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "apellido", target = "apellido")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "rol", target = "rol", qualifiedByName = "stringToRol")
    void modificarEntityFromDto(ModUsuarioDto mod, @MappingTarget UsuarioEntity entity);

}
