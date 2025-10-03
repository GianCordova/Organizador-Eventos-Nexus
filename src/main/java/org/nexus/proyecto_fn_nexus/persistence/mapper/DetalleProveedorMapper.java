package org.nexus.proyecto_fn_nexus.persistence.mapper;

import org.mapstruct.*;
import org.nexus.proyecto_fn_nexus.dominio.dto.DetalleProveedorDto;
import org.nexus.proyecto_fn_nexus.dominio.dto.ModDetalleProveedorDto;
import org.nexus.proyecto_fn_nexus.persistence.entity.DetalleProveedorEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DetalleProveedorMapper {

    @Mapping(source = "evento.idEvento", target = "idEvento")
    @Mapping(source = "proveedor.idProveedor", target = "idProveedor")
    @Mapping(source = "costo", target = "costo")
    @Mapping(source = "observaciones", target = "observaciones")

    DetalleProveedorDto toDto(DetalleProveedorEntity entity);

    List<DetalleProveedorDto> toDto(Iterable<DetalleProveedorEntity> entities);

    @InheritInverseConfiguration
    DetalleProveedorEntity toEntity(DetalleProveedorDto dto);

    @Mapping(source = "idEvento", target = "evento.idEvento")
    @Mapping(source = "idProveedor", target = "proveedor.idProveedor")
    @Mapping(source = "costo", target = "costo")
    @Mapping(source = "observaciones", target = "observaciones")
    void actualizarEntityDesdeDto(ModDetalleProveedorDto mod, @MappingTarget DetalleProveedorEntity entity);
}