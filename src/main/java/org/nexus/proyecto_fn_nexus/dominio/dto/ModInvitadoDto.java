package org.nexus.proyecto_fn_nexus.dominio.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import org.nexus.proyecto_fn_nexus.dominio.EstadoAsistencia;

public record ModInvitadoDto(

        @NotNull(message = "El nombre del invitado es obligatorio")
        String nombre,

        @NotNull(message = "El apellido del invitado es obligatorio")
        String apellido,

        @NotNull(message = "El correo del invitado es obligatorio")
        String correo,

        @NotNull(message = "El telefono del invitado es obligatorio")
        String telefono,

        @NotNull(message = "El estado de asistencia es obligatorio")
        EstadoAsistencia estadoAsistencia,

        @NotNull(message = "El idEvento es obligatorio")
        @Min(value = 1, message = "El idEvento debe ser mayor a 0")
        Long idEvento

) {}
