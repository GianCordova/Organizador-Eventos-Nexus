package org.nexus.proyecto_fn_nexus.persistence.crud;

import org.nexus.proyecto_fn_nexus.persistence.entity.UsuarioEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudUsuarioEntity extends CrudRepository <UsuarioEntity, Long>{

    UsuarioEntity findUsuarioEntitiesByNombre(String nombre);
}
