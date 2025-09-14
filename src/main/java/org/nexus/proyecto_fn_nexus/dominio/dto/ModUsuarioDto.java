package org.nexus.proyecto_fn_nexus.dominio.dto;

import jakarta.validation.constraints.*;


public record ModUsuarioDto(
        @NotNull(message = "El nombre del evento no puede estar vacío")
        String nombre,

        @NotNull(message = "El apellido es obligatoria")
        String apellido,

        @NotNull(message = "El email es obligatoria")
        String email,

        @NotNull(message = "El rol es obligatorio y porfavor unicamente poner cliente y administrador")
        String rol

) {}






