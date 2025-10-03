package org.nexus.proyecto_fn_nexus.dominio.service;


import org.nexus.proyecto_fn_nexus.dominio.dto.DetalleProveedorDto;
import org.nexus.proyecto_fn_nexus.dominio.dto.ModDetalleProveedorDto;
import org.nexus.proyecto_fn_nexus.repository.DetalleProveedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleProveedorService {

    private final DetalleProveedorRepository detalleProveedorRepository;

    public DetalleProveedorService(DetalleProveedorRepository detalleProveedorRepository) {
        this.detalleProveedorRepository = detalleProveedorRepository;
    }

    public List<DetalleProveedorDto> obtenerTodo() {
        return this.detalleProveedorRepository.obtenerTodo();
    }

    public DetalleProveedorDto buscarPorId(Long idDetalleProveedor) {
        return this.detalleProveedorRepository.buscarPorId(idDetalleProveedor);
    }

    public DetalleProveedorDto guardarDetalleProveedor(DetalleProveedorDto detalleProveedorDto) {
        return this.detalleProveedorRepository.guardarDetalleProveedor(detalleProveedorDto);
    }

    public DetalleProveedorDto modificarDetalleProveedor(Long idDetalleProveedor,  ModDetalleProveedorDto modDetalleProveedor) {
        return this.detalleProveedorRepository.modificarDetalleProveedor(idDetalleProveedor, modDetalleProveedor);
    }

    public void eliminarDetalleProveedor(Long idDetalleProveedor) {
        this.detalleProveedorRepository.eliminarDetalleProveedor(idDetalleProveedor);
    }

}
