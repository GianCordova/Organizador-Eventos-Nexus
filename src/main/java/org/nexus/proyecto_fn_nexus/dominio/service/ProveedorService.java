package org.nexus.proyecto_fn_nexus.dominio.service;

import org.nexus.proyecto_fn_nexus.dominio.dto.ProveedorDto;
import org.nexus.proyecto_fn_nexus.dominio.dto.ModProveedorDto;
import org.nexus.proyecto_fn_nexus.repository.ProveedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorService {

    private final ProveedorRepository proveedorRepository;

    public ProveedorService(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    // Obtener todos los proveedores
    public List<ProveedorDto> obtenerTodo() {
        return this.proveedorRepository.obtenerTodo();
    }

    // Buscar proveedor por ID
    public ProveedorDto buscarPorId(Long idProveedor) {
        return this.proveedorRepository.buscarPorId(idProveedor);
    }

    // Guardar un nuevo proveedor
    public ProveedorDto guardarProveedor(ProveedorDto proveedorDto) {
        return this.proveedorRepository.guardarProveedor(proveedorDto);
    }

    // Modificar un proveedor existente
    public ProveedorDto modificarProveedor(Long idProveedor, ModProveedorDto modProveedorDto) {
        return this.proveedorRepository.modificarProveedor(idProveedor, modProveedorDto);
    }

    // Eliminar un proveedor
    public void eliminarProveedor(Long idProveedor) {
        this.proveedorRepository.eliminarProveedor(idProveedor);
    }
}
