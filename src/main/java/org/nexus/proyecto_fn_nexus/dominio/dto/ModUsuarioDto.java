package org.nexus.proyecto_fn_nexus.dominio.dto;

import jakarta.validation.constraints.*;
import org.nexus.proyecto_fn_nexus.dominio.Rol;


public record ModUsuarioDto(
        @NotNull(message = "El nombre del evento no puede estar vacío")
        String nombre,

        @NotNull(message = "El apellido es obligatoria")
        String apellido,

        @NotNull(message = "El email es obligatoria")
        String email,

        @NotNull (message = "La contraseña es obligatoria")
            String password,

        @NotNull(message = "El rol es obligatorio y porfavor unicamente poner cliente y administrador")
        Rol rol

) {}






