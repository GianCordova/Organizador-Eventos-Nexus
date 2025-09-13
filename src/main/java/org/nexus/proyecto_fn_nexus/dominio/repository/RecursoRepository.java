package org.nexus.proyecto_fn_nexus.dominio.repository;

import org.nexus.proyecto_fn_nexus.dominio.dto.ModificarRecursoDto;
import org.nexus.proyecto_fn_nexus.dominio.dto.RecursoDto;

import java.util.List;

public interface RecursoRepository {
    List<RecursoDto> obtenerTodo();
    RecursoDto buscarPorId(Long id);
    RecursoDto guardarRecurso(RecursoDto recursoDto);
    RecursoDto modificarRecurso(Long id, ModificarRecursoDto modRecurso);
    void eliminarRecurso(Long id);
}
