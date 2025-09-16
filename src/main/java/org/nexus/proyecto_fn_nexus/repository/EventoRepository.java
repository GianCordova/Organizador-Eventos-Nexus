package org.nexus.proyecto_fn_nexus.repository;

import org.nexus.proyecto_fn_nexus.dominio.dto.EventoDto;
import org.nexus.proyecto_fn_nexus.dominio.dto.ModEventoDto;

import java.util.List;

public interface EventoRepository {

    // Obtener todos los eventos
    List<EventoDto> obtenerTodo();

    // Buscar un evento por su ID
    EventoDto buscarPorId(Long idEvento);

    // Guardar un nuevo evento
    EventoDto guardarEvento(EventoDto eventoDto);

    // Modificar un evento existente
    EventoDto modificarEvento(Long idEvento, ModEventoDto modEvento);

    // Eliminar un evento por ID
    void eliminarEvento(Long idEvento);
}
