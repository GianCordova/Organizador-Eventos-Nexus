package org.nexus.proyecto_fn_nexus.dominio.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;

public record DetalleRecursoDto (
        Long idDetalleRecurso,

        @NotNull(message = "El id del evento es obligatorio")
        Long idEvento,

        @NotNull(message = "El id del recurso es obligatorio")
        Long idRecurso,

        @NotNull(message = "La cantidad es obligatoria")
        @Min(value = 1, message = "La cantidad debe ser al menos 1")
        Integer cantidad
) {}
