package org.nexus.proyecto_fn_nexus.persistence.mapper;

import org.mapstruct.*;
import org.nexus.proyecto_fn_nexus.dominio.dto.DetalleProveedorDto;
import org.nexus.proyecto_fn_nexus.dominio.dto.ModDetalleProveedorDto;
import org.nexus.proyecto_fn_nexus.persistence.entity.DetalleProvedoresEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DetalleProveedorMapper {

    @Mapping(source = "evento.idEvento", target = "idEvento")
    @Mapping(source = "proveedor.idProveedor", target = "idProveedor")
    DetalleProveedorDto toDto(DetalleProvedoresEntity entity);

    List<DetalleProveedorDto> toDto(Iterable<DetalleProvedoresEntity> entities);

    @InheritInverseConfiguration
    DetalleProvedoresEntity toEntity(DetalleProveedorDto dto);

    @Mapping(source = "idEvento", target = "evento.idEvento")
    @Mapping(source = "idProveedor", target = "proveedor.idProveedor")
    void actualizarEntityDesdeDto(ModDetalleProveedorDto mod, @MappingTarget DetalleProvedoresEntity entity);
}