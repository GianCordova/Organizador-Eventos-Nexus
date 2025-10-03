package org.nexus.proyecto_fn_nexus.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "DetalleRecursos")
@Data
public class DetalleRecursoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDetalleRecurso")
    private Long idDetalleRecurso;

    @ManyToOne
    @JoinColumn(name = "idEvento", nullable = false)
    private EventoEntity evento;

    @ManyToOne
    @JoinColumn(name = "idRecurso", nullable = false)
    private RecursoEntity recurso;

    @Column(nullable = false)
    private Integer cantidad;
}
