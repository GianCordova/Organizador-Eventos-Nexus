package org.nexus.proyecto_fn_nexus.dominio.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.nexus.proyecto_fn_nexus.dominio.CategoriaRecurso;
import java.math.BigDecimal;

public record RecursoDto (
    Long id,
    @NotNull(message = "El nombre del recurso es obligatorio")
    String resourceName,
    CategoriaRecurso category,
    @Min(value = 0, message = "El stock no puede ser menor a 0")
    Integer stock,
    BigDecimal rentalPrice
){}
