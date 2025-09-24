package org.nexus.proyecto_fn_nexus.dominio.dto;

import jakarta.validation.constraints.*;
import org.nexus.proyecto_fn_nexus.dominio.Estado;
import org.nexus.proyecto_fn_nexus.dominio.TipoEvento;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public record ModEventoDto (
        @NotNull(message = "El nombre del evento no puede estar vacío")
        String nombreEvento,

        @NotNull(message = "La descripcion es obligatoria")
        String descripcion,

        @NotNull(message = "La fecha es obligatoria")
        @FutureOrPresent(message = "La fecha del evento debe ser hoy o futura")
        LocalDate fecha,

        @NotNull(message = "El lugar es obligatorio")
        String lugar,

        @NotNull(message = "El estado es obligatorio")
        Estado estado,

        @NotNull(message = "La duracion es obligatoria")
        LocalTime duracion,

        @NotNull(message = "El tipo de evento es obligatorio")
        TipoEvento tipoEvento,

        @NotNull(message = "El costo es obligatorio")
        @DecimalMin(value = "0.0", message = "El costo no puede ser negativo")
        BigDecimal costoEvento,

        @NotNull(message = "El id del usuario organizador es obligatorio")
        Long idUsuario
) {}
