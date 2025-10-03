package org.nexus.proyecto_fn_nexus.persistence.crud;

import org.nexus.proyecto_fn_nexus.persistence.entity.InvitadoEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudInvitadoEntity extends CrudRepository<InvitadoEntity, Long> {

    InvitadoEntity findFirstByNombre(String nombre);
}
