package org.nexus.proyecto_fn_nexus.dominio.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public record ModificarRecursoDto (
        @NotNull(message = "El stock no puede ser nulo")
        @Min(value = 0, message = "El stock no puede ser menor a 0")
        Integer stock,
        @NotNull(message = "El precio de alquiler no puede ser nulo")
        @DecimalMin(value = "0.0", message = "El precio de alquiler no puede ser negativo")
        BigDecimal precioAlquiler

){
}
