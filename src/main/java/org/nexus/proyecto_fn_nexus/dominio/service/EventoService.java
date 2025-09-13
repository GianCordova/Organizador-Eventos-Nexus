package org.nexus.proyecto_fn_nexus.dominio.service;

import org.nexus.proyecto_fn_nexus.dominio.dto.EventoDto;
import org.nexus.proyecto_fn_nexus.dominio.dto.ModEventoDto;
import org.nexus.proyecto_fn_nexus.repository.EventoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {

    private final EventoRepository eventoRepository;

    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    // Obtener todos los eventos
    public List<EventoDto> obtenerTodo() {
        return this.eventoRepository.obtenerTodo();
    }

    // Buscar evento por ID
    public EventoDto buscarPorId(Long idEvento) {
        return this.eventoRepository.buscarPorId(idEvento);
    }

    // Guardar un nuevo evento
    public EventoDto guardarEvento(EventoDto eventoDto) {
        return this.eventoRepository.guardarEvento(eventoDto);
    }

    // Modificar un evento existente
    public EventoDto modificarEvento(Long idEvento, ModEventoDto modEvento) {
        return this.eventoRepository.modificarEvento(idEvento, modEvento);
    }

    // Eliminar un evento
    public void eliminarEvento(Long idEvento) {
        this.eventoRepository.eliminarEvento(idEvento);
    }
}
