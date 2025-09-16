package org.nexus.proyecto_fn_nexus.repository;

import org.nexus.proyecto_fn_nexus.dominio.dto.ProveedorDto;
import org.nexus.proyecto_fn_nexus.dominio.dto.ModProveedorDto;

import java.util.List;

public interface ProveedorRepository {

    // Obtener todos los proveedores
    List<ProveedorDto> obtenerTodo();

    // Buscar un proveedor por su ID
    ProveedorDto buscarPorId(Long idProveedor);

    // Guardar un nuevo proveedor
    ProveedorDto guardarProveedor(ProveedorDto proveedorDto);

    // Modificar un proveedor existente
    ProveedorDto modificarProveedor(Long idProveedor, ModProveedorDto modProveedor);

    // Eliminar un proveedor por ID
    void eliminarProveedor(Long idProveedor);

}
