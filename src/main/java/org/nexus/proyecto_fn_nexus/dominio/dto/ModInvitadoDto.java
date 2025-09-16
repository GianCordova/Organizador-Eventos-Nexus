package org.nexus.proyecto_fn_nexus.dominio.dto;
import jakarta.validation.constraints.*;

public record ModInvitadoDto (
        @NotNull(message = "El nombre no puede estar vacío")
        String nombre,

        @NotNull(message = "El apellido no puede estar vacío")
        String apellido,

        String correo,

        String telefono,

        @NotNull(message = "El estado de asistencia no puede ser nulo")
        String estadoAsistencia,

        @NotNull(message = "El idEvento no puede ser nulo")
        Integer idEvento
){
}