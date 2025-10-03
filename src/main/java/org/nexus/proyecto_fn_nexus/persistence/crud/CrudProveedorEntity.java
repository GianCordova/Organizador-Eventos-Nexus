package org.nexus.proyecto_fn_nexus.persistence.crud;

import org.nexus.proyecto_fn_nexus.persistence.entity.ProveedorEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudProveedorEntity extends CrudRepository<ProveedorEntity, Long> {

    ProveedorEntity findProveedorEntityBynombreProveedor(String nombreProveedor);
}
