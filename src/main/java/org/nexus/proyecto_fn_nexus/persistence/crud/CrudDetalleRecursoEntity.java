package org.nexus.proyecto_fn_nexus.persistence.crud;

import org.nexus.proyecto_fn_nexus.persistence.entity.DetalleRecursoEntity;

import org.springframework.data.repository.CrudRepository;


public interface CrudDetalleRecursoEntity extends CrudRepository <DetalleRecursoEntity, Long> {

    DetalleRecursoEntity findFirstByCantidad(Integer cantidad);

}
