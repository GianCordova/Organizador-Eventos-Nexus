package org.nexus.proyecto_fn_nexus.web.jsf.dto;

import lombok.Data;
import org.nexus.proyecto_fn_nexus.dominio.CategoriaRecurso;

import java.math.BigDecimal;

@Data
public class RecursoJsfDto {
    private Integer idRecurso;
    private String resourceName;
    private CategoriaRecurso category;
    private Integer stock;
    private BigDecimal rentalPrice;
}
