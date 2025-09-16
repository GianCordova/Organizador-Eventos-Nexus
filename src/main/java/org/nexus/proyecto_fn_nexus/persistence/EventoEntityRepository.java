package org.nexus.proyecto_fn_nexus.persistence;

import org.nexus.proyecto_fn_nexus.dominio.dto.EventoDto;
import org.nexus.proyecto_fn_nexus.dominio.dto.ModEventoDto;
import org.nexus.proyecto_fn_nexus.dominio.exception.EventoNoExisteException;
import org.nexus.proyecto_fn_nexus.dominio.exception.EventoYaExisteException;
import org.nexus.proyecto_fn_nexus.persistence.crud.CrudEventoEntity;
import org.nexus.proyecto_fn_nexus.persistence.entity.EventoEntity;
import org.nexus.proyecto_fn_nexus.persistence.mapper.EventoMapper;
import org.nexus.proyecto_fn_nexus.repository.EventoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EventoEntityRepository implements EventoRepository {

    private final CrudEventoEntity crudEventoEntity;
    private final EventoMapper eventoMapper;

    public EventoEntityRepository(CrudEventoEntity crudEventoEntity, EventoMapper eventoMapper) {
        this.crudEventoEntity = crudEventoEntity;
        this.eventoMapper = eventoMapper;
    }

    @Override
    public List<EventoDto> obtenerTodo() {
        return this.eventoMapper.toDto(this.crudEventoEntity.findAll());
    }

    @Override
    public EventoDto buscarPorId(Long idEvento) {
        return this.eventoMapper.toDto(this.crudEventoEntity.findById(idEvento).orElse(null));
    }

    @Override
    public EventoDto guardarEvento(EventoDto eventoDto) {
        if (this.crudEventoEntity.findFirstByNombreEvento(eventoDto.nombreEvento()) != null) {
            throw new EventoYaExisteException(eventoDto.nombreEvento());
        }

        // Convertimos DTO a Entity
        EventoEntity evento = this.eventoMapper.toEntity(eventoDto);

        // Guardamos en la base de datos
        this.crudEventoEntity.save(evento);

        // Retornamos como DTO
        return this.eventoMapper.toDto(evento);
    }

    @Override
    public EventoDto modificarEvento(Long idEvento, ModEventoDto modEvento) {
        EventoEntity evento = this.crudEventoEntity.findById(idEvento).orElse(null);

        if (evento == null) {
            throw new EventoNoExisteException(idEvento);
        }

        // Actualizamos entidad con datos del DTO
        this.eventoMapper.modificarEntityFromDto(modEvento, evento);

        return this.eventoMapper.toDto(this.crudEventoEntity.save(evento));
    }

    @Override
    public void eliminarEvento(Long idEvento) {
        EventoEntity evento = this.crudEventoEntity.findById(idEvento).orElse(null);

        if (evento == null) {
            throw new EventoNoExisteException(idEvento);
        }

        this.crudEventoEntity.delete(evento);
    }
}
