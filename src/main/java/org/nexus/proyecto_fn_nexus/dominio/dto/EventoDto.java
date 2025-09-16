package org.nexus.proyecto_fn_nexus.dominio.dto;

import jakarta.validation.constraints.*;
import org.nexus.proyecto_fn_nexus.dominio.Estado;
import org.nexus.proyecto_fn_nexus.dominio.TipoEvento;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public record EventoDto (
        Long idEvento,

        @NotNull(message = "El nombre del evento es obligatorio")
        String nombreEvento,

        @NotNull(message = "La descripcion es obligatoria")
        String descripcion,

        @NotNull(message = "La fecha es obligatoria")
        @FutureOrPresent(message = "La fecha del evento debe ser hoy o futura")
        LocalDate fecha,

        @NotNull(message = "El lugar es obligatorio")
        String lugar,

        @NotNull(message = "El estado es obligatorio")
        Estado estado, // pendiente, en progreso, completada

        @NotNull(message = "La duracion es obligatoria")
        LocalTime duracion,

        @NotNull(message = "El tipo de evento es obligatorio")
        TipoEvento tipoEvento, // social, corporativo, cultural, recreativo, otro

        @NotNull(message = "El costo es obligatorio")
        @DecimalMin(value = "0.0", message = "El costo no puede ser negativo")
        BigDecimal costoEvento,

        @NotNull(message = "El id del usuario organizador es obligatorio")
        Long idUsuario
) {}
