package org.nexus.proyecto_fn_nexus.dominio.service;

import org.nexus.proyecto_fn_nexus.dominio.dto.DetalleRecursoDto;
import org.nexus.proyecto_fn_nexus.dominio.dto.ModDetalleRecursoDto;
import org.nexus.proyecto_fn_nexus.repository.DetalleRecursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleRecursoService {

    private final DetalleRecursoRepository detalleRecursoRepository;

    public DetalleRecursoService(DetalleRecursoRepository detalleRecursoRepository) {
        this.detalleRecursoRepository = detalleRecursoRepository;
    }

    public List<DetalleRecursoDto> obtenerTodo(){
        return this.detalleRecursoRepository.obtenerTodo();
    }

    public DetalleRecursoDto buscarPorId(Integer idDetalleRecurso){
        return this.detalleRecursoRepository.buscarPorId(idDetalleRecurso.longValue());
    }

    public DetalleRecursoDto guardarDetalleRecurso(DetalleRecursoDto detalleRecursoDto){
        return this.detalleRecursoRepository.guardarDetalleRecurso(detalleRecursoDto);
    }

    public DetalleRecursoDto modificarDetalleRecurso(Long idDetallerRecurso, ModDetalleRecursoDto modDetalleRecurso){
        return this.detalleRecursoRepository.modificarDetalleRecurso(idDetallerRecurso, modDetalleRecurso);
    }

    public void eliminarDetalleRecurso(Long idDetalleRecurso){
        this.detalleRecursoRepository.eliminarDetalleRecurso(idDetalleRecurso);
    }


}
