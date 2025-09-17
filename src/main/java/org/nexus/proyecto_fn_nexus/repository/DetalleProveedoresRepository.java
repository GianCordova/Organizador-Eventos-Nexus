package org.nexus.proyecto_fn_nexus.repository;


import org.nexus.proyecto_fn_nexus.dominio.dto.DetalleProveedorDto;
import org.nexus.proyecto_fn_nexus.dominio.dto.ModDetalleProveedorDto;

import java.util.List;

public interface DetalleProveedoresRepository {

    List<DetalleProveedorDto> obtenerTodo();

    DetalleProveedorDto buscarPorId(Long idDetalleProveedor);

    DetalleProveedorDto guardarDetalleProveedor(DetalleProveedorDto detalleProveedorDto);

    DetalleProveedorDto modificarDetalleProveedor(Long idDetalleProveedor, ModDetalleProveedorDto modDetalleProveedorDto);

    void eliminarDetalleProveedor(Long idDetalleProveedor);
}
