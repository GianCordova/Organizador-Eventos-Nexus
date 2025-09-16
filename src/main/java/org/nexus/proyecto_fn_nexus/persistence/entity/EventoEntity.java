package org.nexus.proyecto_fn_nexus.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.nexus.proyecto_fn_nexus.dominio.Estado;
import org.nexus.proyecto_fn_nexus.dominio.TipoEvento;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Eventos")
@Data
public class EventoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEvento")
    private Long idEvento;

    @Column(name = "nombreEvento", length = 100, nullable = false)
    private String nombreEvento;

    @Column(name = "descripcion", length = 255, nullable = false)
    private String descripcion;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "lugar", length = 100, nullable = false)
    private String lugar;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", length = 20, nullable = false)
    private Estado estado; // pendiente, en progreso, completada

    @Column(name = "duracion", nullable = false)
    private LocalTime duracion;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipoEvento", length = 20, nullable = false)
    private TipoEvento tipoEvento; // social, corporativo, cultural, recreativo, otro

    @Column(name = "costoEvento", precision = 10, scale = 2, nullable = false)
    private BigDecimal costoEvento;

    // Relación con Usuario (organizador)
    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private UsuarioEntity usuario;
}
