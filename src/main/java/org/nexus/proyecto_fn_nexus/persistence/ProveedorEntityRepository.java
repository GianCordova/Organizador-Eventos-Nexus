package org.nexus.proyecto_fn_nexus.persistence;

import org.nexus.proyecto_fn_nexus.dominio.dto.ModProveedorDto;
import org.nexus.proyecto_fn_nexus.dominio.dto.ProveedorDto;
import org.nexus.proyecto_fn_nexus.dominio.exception.ProveedorNoExisteException;
import org.nexus.proyecto_fn_nexus.dominio.exception.ProveedorYaExisteException;
import org.nexus.proyecto_fn_nexus.persistence.crud.CrudProveedorEntity;
import org.nexus.proyecto_fn_nexus.persistence.entity.ProveedorEntity;
import org.nexus.proyecto_fn_nexus.persistence.mapper.ProveedorMapper;
import org.nexus.proyecto_fn_nexus.repository.ProveedorRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProveedorEntityRepository implements ProveedorRepository {

    private final CrudProveedorEntity crudProveedorEntity;
    private final ProveedorMapper proveedorMapper;

    public ProveedorEntityRepository(CrudProveedorEntity crudProveedorEntity, ProveedorMapper proveedorMapper) {
        this.crudProveedorEntity = crudProveedorEntity;
        this.proveedorMapper = proveedorMapper;
    }

    @Override
    public List<ProveedorDto> obtenerTodo() {
        return this.proveedorMapper.toDto(this.crudProveedorEntity.findAll());
    }

    @Override
    public ProveedorDto buscarPorId(Long idProveedor) {
        return this.proveedorMapper.toDto(this.crudProveedorEntity.findById(idProveedor).orElse(null));
    }

    @Override
    public ProveedorDto guardarProveedor(ProveedorDto proveedorDto) {
        if (this.crudProveedorEntity.findProveedorEntityBynombreProveedor(proveedorDto.nombreProveedor()) != null) {
            throw new ProveedorYaExisteException(proveedorDto.nombreProveedor());
        }

        ProveedorEntity proveedor = this.proveedorMapper.toEntity(proveedorDto);
        this.crudProveedorEntity.save(proveedor);
        return this.proveedorMapper.toDto(proveedor);
    }

    @Override
    public ProveedorDto modificarProveedor(Long idProveedor, ModProveedorDto modProveedorDto) {
        ProveedorEntity proveedor = this.crudProveedorEntity.findById(idProveedor).orElse(null);

        if (proveedor == null) {
            throw new ProveedorNoExisteException(idProveedor);
        }

        this.proveedorMapper.modificarEntityFromDto(modProveedorDto, proveedor);
        return this.proveedorMapper.toDto(this.crudProveedorEntity.save(proveedor));
    }

    @Override
    public void eliminarProveedor(Long idProveedor) {
        ProveedorEntity proveedor = this.crudProveedorEntity.findById(idProveedor).orElse(null);

        if (proveedor == null) {
            throw new ProveedorNoExisteException(idProveedor);
        }

        this.crudProveedorEntity.delete(proveedor);
    }
}
