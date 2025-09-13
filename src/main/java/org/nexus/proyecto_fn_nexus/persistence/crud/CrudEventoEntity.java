package org.nexus.proyecto_fn_nexus.persistence.crud;

import org.nexus.proyecto_fn_nexus.persistence.entity.EventoEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudEventoEntity extends CrudRepository<EventoEntity, Long> {
    // Creamos el "DAO" o acceso al CRUD de la entidad Evento

    EventoEntity findFirstByNombreEvento(String nombreEvento);
}
