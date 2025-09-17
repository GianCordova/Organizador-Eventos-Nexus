package org.nexus.proyecto_fn_nexus.persistence;

import org.nexus.proyecto_fn_nexus.dominio.dto.DetalleRecursoDto;
import org.nexus.proyecto_fn_nexus.dominio.dto.ModDetalleRecursoDto;
import org.nexus.proyecto_fn_nexus.dominio.exception.DetalleRecursoNoExisteException;
import org.nexus.proyecto_fn_nexus.dominio.exception.DetalleRecursoYaExisteException;
import org.nexus.proyecto_fn_nexus.persistence.entity.DetalleRecursoEntity;
import org.nexus.proyecto_fn_nexus.persistence.mapper.DetalleRecursoMapper;
import org.nexus.proyecto_fn_nexus.repository.DetalleRecursoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DetalleRecursoEntityRepository implements DetalleRecursoRepository {

    private final org.nexus.proyecto_fn_nexus.persistence.crud.CrudDetalleRecursoEntity CrudDetalleRecursoEntity;
    private final DetalleRecursoMapper detalleRecursoMapper;

    public DetalleRecursoEntityRepository(org.nexus.proyecto_fn_nexus.persistence.crud.CrudDetalleRecursoEntity crudDetalleRecursoEntity, DetalleRecursoMapper detalleRecursoMapper) {
        this.CrudDetalleRecursoEntity = crudDetalleRecursoEntity;
        this.detalleRecursoMapper = detalleRecursoMapper;
    }

    @Override
    public List<DetalleRecursoDto> obtenerTodo() {
        return this.detalleRecursoMapper.toDto(this.CrudDetalleRecursoEntity.findAll());
    }

    @Override
    public DetalleRecursoDto buscarPorId(Long idDetalleRecurso) {
        return this.detalleRecursoMapper.toDto(this.CrudDetalleRecursoEntity.findById(idDetalleRecurso).orElse(null));
    }

    @Override
    public DetalleRecursoDto guardarDetalleRecurso(DetalleRecursoDto detalleRecursoDto) {
        // Verificamos si el detalle de recurso ya existe en el sistema
        if (this.CrudDetalleRecursoEntity.findDetalleRecursoEntitiesByCantidad(detalleRecursoDto.cantidad().toString()) != null) {
            throw new DetalleRecursoYaExisteException(detalleRecursoDto.toString());
        }

        // Convertimos el DTO a una entidad
        DetalleRecursoEntity detalleRecursoEntity = this.detalleRecursoMapper.toEntity(detalleRecursoDto);

        // Guardamos el detalle de recurso en la base de datos
        this.CrudDetalleRecursoEntity.save(detalleRecursoEntity);

        // Retornamos la entidad guardada como DTO
        return this.detalleRecursoMapper.toDto(detalleRecursoEntity);
    }

    @Override
    public DetalleRecursoDto modificarDetalleRecurso(Long idDetalleRecurso, ModDetalleRecursoDto modDetalleRecursoDto) {
        // Buscamos el detalle de recurso por ID
        DetalleRecursoEntity detalleRecursoEntity = this.CrudDetalleRecursoEntity.findById(idDetalleRecurso).orElse(null);

        // Si no existe, lanzamos la excepción correspondiente
        if (detalleRecursoEntity == null) {
            throw new DetalleRecursoNoExisteException(idDetalleRecurso);
        }

        // Modificamos la entidad con los datos del DTO
        this.detalleRecursoMapper.actualizarEntityDesdeDto(modDetalleRecursoDto, detalleRecursoEntity);

        // Guardamos los cambios y retornamos el DTO actualizado
        return this.detalleRecursoMapper.toDto(this.CrudDetalleRecursoEntity.save(detalleRecursoEntity));
    }

    @Override
    public void eliminarDetalleRecurso(Long idDetalleRecurso) {
        // Buscamos el detalle de recurso por ID
        DetalleRecursoEntity detalleRecursoEntity = this.CrudDetalleRecursoEntity.findById(idDetalleRecurso).orElse(null);

        // Si no existe, lanzamos la excepción correspondiente
        if (detalleRecursoEntity == null) {
            throw new DetalleRecursoNoExisteException(idDetalleRecurso);
        }

        // Eliminamos el detalle de recurso de la base de datos
        this.CrudDetalleRecursoEntity.delete(detalleRecursoEntity);
    }
}
