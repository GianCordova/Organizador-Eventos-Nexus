package org.nexus.proyecto_fn_nexus.dominio.service;


import org.nexus.proyecto_fn_nexus.dominio.dto.DetalleProveedorDto;
import org.nexus.proyecto_fn_nexus.dominio.dto.ModDetalleProveedorDto;
import org.nexus.proyecto_fn_nexus.repository.DetalleProveedoresRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleProveedoresService {

    private final DetalleProveedoresRepository detalleProveedoresRepository;

    public DetalleProveedoresService(DetalleProveedoresRepository detalleProveedoresRepository) {
        this.detalleProveedoresRepository = detalleProveedoresRepository;
    }

    public List<DetalleProveedorDto> obtenerTodo() {
        return this.detalleProveedoresRepository.obtenerTodo();
    }

    public DetalleProveedorDto buscarPorId(Long idDetalleProveedor) {
        return this.detalleProveedoresRepository.buscarPorId(idDetalleProveedor);
    }

    public DetalleProveedorDto guardarDetalleProveedor(DetalleProveedorDto detalleProveedorDto) {
        return this.detalleProveedoresRepository.guardarDetalleProveedor(detalleProveedorDto);
    }

    public DetalleProveedorDto modificarDetalleProveedor(Long idDetalleProveedor,  ModDetalleProveedorDto modDetalleProveedor) {
        return this.detalleProveedoresRepository.modificarDetalleProveedor(idDetalleProveedor, modDetalleProveedor);
    }

    public void eliminarDetalleProveedor(Long idDetalleProveedor) {
        this.detalleProveedoresRepository.eliminarDetalleProveedor(idDetalleProveedor);
    }

}
