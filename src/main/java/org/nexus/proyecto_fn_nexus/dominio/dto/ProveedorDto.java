package org.nexus.proyecto_fn_nexus.dominio.dto;

import jakarta.validation.constraints.NotNull;

public record ProveedorDto(

        Long idProveedor,

        @NotNull(message = "El nombre del proveedor no puede estar vacío")
        String nombreProveedor,

        @NotNull(message = "El apellido del proveedor es obligatorio")
        String servicio,

        @NotNull(message = "El email del proveedor es obligatorio")
        String contacto
) {}
