package org.nexus.proyecto_fn_nexus.persistence.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.nexus.proyecto_fn_nexus.dominio.Estado;
import org.nexus.proyecto_fn_nexus.dominio.TipoEvento;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "DetalleRecursos")
@Data
public class DetalleRecursoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDetalleRecurso")
    private Long idDetalleRecurso;

    // Relación con evento (organizador)
    @ManyToOne
    @JoinColumn(name = "idEvento", nullable = false)
    private EventoEntity evento;

    // Relación con recurso (organizador)
    @ManyToOne
    @JoinColumn(name = "idRecurso", nullable = false)
    private RecursoEntity recurso;

    @Column(nullable = false)
    private Integer cantidad;





}
