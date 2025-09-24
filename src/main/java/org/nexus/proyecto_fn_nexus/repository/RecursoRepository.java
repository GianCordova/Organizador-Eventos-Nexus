package org.nexus.proyecto_fn_nexus.repository;

import org.nexus.proyecto_fn_nexus.dominio.dto.ModificarRecursoDto;
import org.nexus.proyecto_fn_nexus.dominio.dto.RecursoDto;
import org.nexus.proyecto_fn_nexus.persistence.entity.RecursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecursoRepository {
    List<RecursoDto> obtenerTodo();
    RecursoDto buscarPorId(Integer idRecurso);
    RecursoDto guardarRecurso(RecursoDto recursoDto);
    RecursoDto modificarRecurso(Integer idRecurso, ModificarRecursoDto modRecursoDto);
    void eliminarRecurso(Integer idRecurso);
}
