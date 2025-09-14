package org.nexus.proyecto_fn_nexus.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.nexus.proyecto_fn_nexus.dominio.CategoriaRecurso;

import java.math.BigDecimal;

@Entity
@Table(name = "Recursos")
@Data
public class RecursoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRecurso;
    @Column(length = 150, unique = true, nullable = false)
    private String nombreRecurso;
    @Enumerated(EnumType.STRING)
    @Column(name = "categoria", length = 40, nullable = false)
    private CategoriaRecurso categoria;
    @Column(nullable = false)
    private Integer stock;
    @Column(name = "precioAlquiler", precision = 10, scale = 2, nullable = false)
    private BigDecimal precioAlquiler;
}
