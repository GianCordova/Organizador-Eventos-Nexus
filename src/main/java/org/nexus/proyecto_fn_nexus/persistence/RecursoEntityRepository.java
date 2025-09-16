package org.nexus.proyecto_fn_nexus.persistence;


import org.nexus.proyecto_fn_nexus.dominio.dto.ModificarRecursoDto;
import org.nexus.proyecto_fn_nexus.dominio.dto.RecursoDto;
import org.nexus.proyecto_fn_nexus.dominio.exception.RecursoNoExisteException;
import org.nexus.proyecto_fn_nexus.dominio.exception.RecursoYaExisteException;
import org.nexus.proyecto_fn_nexus.repository.RecursoRepository;
import org.nexus.proyecto_fn_nexus.persistence.crud.CrudRecursoEntity;
import org.nexus.proyecto_fn_nexus.persistence.entity.RecursoEntity;
import org.nexus.proyecto_fn_nexus.persistence.mapper.RecursoMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RecursoEntityRepository implements RecursoRepository {

    private final CrudRecursoEntity crudRecursoEntity;
    private final RecursoMapper recursoMapper;

    public RecursoEntityRepository(CrudRecursoEntity crudRecursoEntity, RecursoMapper recursoMapper) {
        this.crudRecursoEntity = crudRecursoEntity;
        this.recursoMapper = recursoMapper;
    }


    @Override
    public List<RecursoDto> obtenerTodo() {
        return this.recursoMapper.toDto(this.crudRecursoEntity.findAll());
    }

    @Override
    public RecursoDto buscarPorId(Integer idRecurso) {
        return this.recursoMapper.toDto(this.crudRecursoEntity.findById(idRecurso).orElse(null));
    }

    @Override
    public RecursoDto guardarRecurso(RecursoDto recursoDto) {
        if (this.crudRecursoEntity.findFirstByNombreRecurso(recursoDto.resourceName()) != null){
        throw new RecursoYaExisteException(recursoDto.resourceName());
        }
        RecursoEntity recurso = new RecursoEntity();
        recurso = this.recursoMapper.toEntity(recursoDto);
        recurso.setNombreRecurso(recursoDto.resourceName());
        this.crudRecursoEntity.save(recurso);
        return this.recursoMapper.toDto(recurso);
    }

    @Override
    public RecursoDto modificarRecurso(Integer idRecurso, ModificarRecursoDto modRecurso) {
        RecursoEntity recurso = this.crudRecursoEntity.findById(idRecurso).orElse(null);
        recurso.setNombreRecurso(modRecurso.resourceName());
        recurso.setStock(modRecurso.stock());
        recurso.setPrecioAlquiler(modRecurso.rentalPrice());

        if (recurso == null) {
            throw new RecursoNoExisteException(idRecurso);
        }

        this.recursoMapper.modificarEntityFromDto(modRecurso, recurso);
        return this.recursoMapper.toDto(this.crudRecursoEntity.save(recurso));
    }

    @Override
    public void eliminarRecurso(Integer idRecurso) {

    }
}
