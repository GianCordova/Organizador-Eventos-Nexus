package org.nexus.proyecto_fn_nexus.dominio.dto;

import jakarta.validation.constraints.NotNull;

public record ModProveedorDto(

        @NotNull(message = "El nombre del proveedor no puede estar vacío")
        String nombre,

        @NotNull(message = "El apellido del proveedor es obligatorio")
        String apellido,

        @NotNull(message = "El email del proveedor es obligatorio")
        String email,

        @NotNull(message = "La contraseña del proveedor es obligatoria")
        String password,

        @NotNull(message = "El tipo de proveedor es obligatorio")
        String tipo

) {}
