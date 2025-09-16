package org.nexus.proyecto_fn_nexus.dominio.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record InvitadoDto (
        Integer idInvitado,
        @NotNull(message = "El nombre del invitado es obligatorio")
        String nombre,
        String apellido,
        String correo,
        String telefono,
        @NotNull(message = "El estado de asistencia es obligatorio")
        String estadoAsistencia,
        @Min(value = 1, message = "El idEvento debe ser mayor a 0")
        Integer idEvento
){}