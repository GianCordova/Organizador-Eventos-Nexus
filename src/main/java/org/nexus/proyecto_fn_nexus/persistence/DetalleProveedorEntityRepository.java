package org.nexus.proyecto_fn_nexus.persistence;

import org.nexus.proyecto_fn_nexus.dominio.dto.DetalleProveedorDto;
import org.nexus.proyecto_fn_nexus.dominio.dto.ModDetalleProveedorDto;
import org.nexus.proyecto_fn_nexus.dominio.exception.DetalleProveedorNoExisteException;
import org.nexus.proyecto_fn_nexus.dominio.exception.DetalleProveedorYaExisteException;
import org.nexus.proyecto_fn_nexus.persistence.entity.DetalleProveedorEntity;
import org.nexus.proyecto_fn_nexus.persistence.mapper.DetalleProveedorMapper;
import org.nexus.proyecto_fn_nexus.repository.DetalleProveedoresRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DetalleProveedorEntityRepository implements DetalleProveedoresRepository {

    private final org.nexus.proyecto_fn_nexus.persistence.crud.CrudDetalleProveedorEntity crudDetalleProveedorEntity;
    private final DetalleProveedorMapper detalleProveedorMapper;

    public DetalleProveedorEntityRepository(org.nexus.proyecto_fn_nexus.persistence.crud.CrudDetalleProveedorEntity crudDetalleProveedorEntity, DetalleProveedorMapper detalleProveedorMapper) {
        this.crudDetalleProveedorEntity = crudDetalleProveedorEntity;
        this.detalleProveedorMapper = detalleProveedorMapper;
    }

    @Override
    public List<DetalleProveedorDto> obtenerTodo() {
        return this.detalleProveedorMapper.toDto(this.crudDetalleProveedorEntity.findAll());
    }

    @Override
    public DetalleProveedorDto buscarPorId(Long idDetalleProveedor) {
        Optional<DetalleProveedorEntity> entity = this.crudDetalleProveedorEntity.findById(idDetalleProveedor);
        return entity.map(detalleProveedorMapper::toDto).orElse(null);
    }

    @Override
    public DetalleProveedorDto guardarDetalleProveedor(DetalleProveedorDto detalleProveedorDto) {
        // Verificamos si el detalle de proveedor ya existe en el sistema
        if (this.crudDetalleProveedorEntity.countDetalleProvedoresEntitiesByCantidad(detalleProveedorDto.observaciones().toString()) != null) {
            throw new DetalleProveedorYaExisteException(detalleProveedorDto.toString());
        }

        // Convertimos el DTO a una entidad
        DetalleProveedorEntity detalleProveedorEntity = this.detalleProveedorMapper.toEntity(detalleProveedorDto);

        // Guardamos el detalle de proveedor en la base de datos
        this.crudDetalleProveedorEntity.save(detalleProveedorEntity);

        // Retornamos la entidad guardada como DTO
        return this.detalleProveedorMapper.toDto(detalleProveedorEntity);
    }

    @Override
    public DetalleProveedorDto modificarDetalleProveedor(Long idDetalleProveedor, ModDetalleProveedorDto modDetalleProveedorDto) {
        // Buscamos el detalle de proveedor por ID
        DetalleProveedorEntity detalleProveedorEntity = this.crudDetalleProveedorEntity.findById(idDetalleProveedor)
                .orElseThrow(() -> new DetalleProveedorNoExisteException(idDetalleProveedor));

        // Modificamos la entidad con los datos del DTO
        this.detalleProveedorMapper.actualizarEntityDesdeDto(modDetalleProveedorDto, detalleProveedorEntity);

        // Guardamos los cambios y retornamos el DTO actualizado
        return this.detalleProveedorMapper.toDto(this.crudDetalleProveedorEntity.save(detalleProveedorEntity));
    }

    @Override
    public void eliminarDetalleProveedor(Long idDetalleProveedor) {
        // Buscamos el detalle de proveedor por ID
        DetalleProveedorEntity detalleProveedorEntity = this.crudDetalleProveedorEntity.findById(idDetalleProveedor)
                .orElseThrow(() -> new DetalleProveedorNoExisteException(idDetalleProveedor));

        // Eliminamos el detalle de proveedor de la base de datos
        this.crudDetalleProveedorEntity.delete(detalleProveedorEntity);
    }
}
