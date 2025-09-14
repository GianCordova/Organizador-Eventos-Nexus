package org.nexus.proyecto_fn_nexus.persistence.crud;

import org.nexus.proyecto_fn_nexus.persistence.entity.UsuarioEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudUsuariosEntity extends CrudRepository <UsuarioEntity, Long>{
    // En esta parte creamos el DAO o el acceso al CRUD de la entidad de los Usuarios

    UsuarioEntity findUsuarioEntitiesByNombre(String nombre);
}
