package org.nexus.proyecto_fn_nexus.dominio.service;

import org.nexus.proyecto_fn_nexus.dominio.dto.ModificarRecursoDto;
import org.nexus.proyecto_fn_nexus.dominio.dto.RecursoDto;
import org.nexus.proyecto_fn_nexus.dominio.repository.RecursoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RecursoService {

    private final RecursoRepository recursoRepository;

    public RecursoService(RecursoRepository recursoRepository) {
        this.recursoRepository = recursoRepository;
    }

    public List<RecursoDto> obtenerTodo(){
        return this.recursoRepository.obtenerTodo();
    }

    public RecursoDto buscarPorId(Integer idRecurso){
        return this.recursoRepository.buscarPorId(idRecurso);
    }

    public RecursoDto guardarRecurso(RecursoDto recursoDto){
        return this.recursoRepository.guardarRecurso(recursoDto);
    }

    public RecursoDto modificarRecurso(Integer idRecurso, ModificarRecursoDto modRecursoDto){
        return this.recursoRepository.modificarRecurso(idRecurso, modRecursoDto);
    }

    public void eliminarRecurso(Integer idRecurso){
        this.recursoRepository.eliminarRecurso(idRecurso);
    }
}
