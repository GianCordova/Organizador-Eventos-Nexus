package org.nexus.proyecto_fn_nexus.persistence.crud;

import org.nexus.proyecto_fn_nexus.persistence.entity.DetalleRecursoEntity;

import org.springframework.data.repository.CrudRepository;


public interface CrudDetalleRecursoEntity extends CrudRepository <DetalleRecursoEntity, Long> {
    // En esta parte creamos el DAO o el acceso al CRUD de la entidad de los detalleRecursos

    DetalleRecursoEntity findDetalleRecursoEntitiesByCantidad(Integer cantidad);

}
