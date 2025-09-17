package org.nexus.proyecto_fn_nexus.persistence.crud;

import org.nexus.proyecto_fn_nexus.persistence.entity.DetalleProveedorEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudDetalleProveedorEntity extends CrudRepository<DetalleProveedorEntity, Long> {
    // En esta parte creamos el DAO o el acceso al CRUD de la entidad de los detalleRecursos

    DetalleProveedorEntity countDetalleProvedoresEntitiesByObservaciones(String observaciones);

}
