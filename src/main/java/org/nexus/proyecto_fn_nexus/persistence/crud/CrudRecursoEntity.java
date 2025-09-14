package org.nexus.proyecto_fn_nexus.persistence.crud;

import org.nexus.proyecto_fn_nexus.persistence.entity.RecursoEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudRecursoEntity extends CrudRepository<RecursoEntity, Integer> {

    RecursoEntity findFirstByNombreRecurso(String nombreRecurso);
}
