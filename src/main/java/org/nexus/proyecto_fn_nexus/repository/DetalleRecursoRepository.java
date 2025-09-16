package org.nexus.proyecto_fn_nexus.repository;

import org.nexus.proyecto_fn_nexus.dominio.dto.DetalleRecursoDto;
import org.nexus.proyecto_fn_nexus.dominio.dto.ModDetalleRecursoDto;

import java.util.List;

public interface DetalleRecursoRepository {

    List<DetalleRecursoDto> obtenerTodo();

    DetalleRecursoDto buscarPorId(Long idDetalleRecurso);

    DetalleRecursoDto guardarDetalleRecurso(DetalleRecursoDto detalleRecursoDto);

    DetalleRecursoDto modificarDetalleRecurso(Long idDetalleRecurso, ModDetalleRecursoDto modDetalleRecurso);

    void eliminarDetalleRecurso(Long idDetalleRecurso);
}
