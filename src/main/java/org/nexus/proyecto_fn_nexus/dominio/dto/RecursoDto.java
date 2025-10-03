package org.nexus.proyecto_fn_nexus.dominio.dto;


import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.nexus.proyecto_fn_nexus.dominio.CategoriaRecurso;
import java.math.BigDecimal;

public record RecursoDto (

    Long idRecurso,

    @NotNull(message = "El titulo nuevo no puede estar vacio")
    String nombreRecurso,

    @NotNull(message = "La categoría es obligatoria")
    CategoriaRecurso categoria,

    @DecimalMin(value = "0", message = "El stock no puede ser negativo")
    Integer stock,

    @NotNull(message = "El precio de alquiler es obligatorio")
    @DecimalMin(value = "0.0", message = "El precio de alquiler no puede ser negativo")
    BigDecimal precioAlquiler
) {}
