package org.nexus.proyecto_fn_nexus.persistence.crud;

import org.nexus.proyecto_fn_nexus.persistence.entity.DetalleProvedoresEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudDetalleProvedoresEntity  extends CrudRepository<DetalleProvedoresEntity, Long> {
    // En esta parte creamos el DAO o el acceso al CRUD de la entidad de los detalleRecursos

    DetalleProvedoresEntity countDetalleProvedoresEntitiesBy(String cantidad);

}
