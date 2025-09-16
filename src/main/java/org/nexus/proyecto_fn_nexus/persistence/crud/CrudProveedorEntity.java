package org.nexus.proyecto_fn_nexus.persistence.crud;

import org.nexus.proyecto_fn_nexus.persistence.entity.ProveedorEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudProveedorEntity extends CrudRepository<ProveedorEntity, Long> {
    // En esta parte creamos el DAO o el acceso al CRUD de la entidad de los Proveedores

    ProveedorEntity findProveedorEntityBynombreProveedor(String nombreProveedor);
}
