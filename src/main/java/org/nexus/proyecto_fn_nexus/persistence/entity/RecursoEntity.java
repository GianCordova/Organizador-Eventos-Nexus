package org.nexus.proyecto_fn_nexus.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.nexus.proyecto_fn_nexus.dominio.CategoriaRecurso;
import java.math.BigDecimal;

@Entity
@Table(name = "Recursos")
@Data
public class RecursoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRecurso;

    @Column(name = "nombreRecurso", length = 150, nullable = false)
    private String nombreRecurso;

    @Enumerated(EnumType.STRING)
    @Column(name = "categoria", length = 40, nullable = false)
    private CategoriaRecurso categoria;

    @Column(name = "stock", nullable = false)
    private Integer stock;

    @Column(name = "precioAlquiler", precision = 10, scale = 2, nullable = false)
    private BigDecimal precioAlquiler;
}
