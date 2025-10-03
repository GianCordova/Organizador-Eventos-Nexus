package org.nexus.proyecto_fn_nexus.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
    private Estado estado;

    @Column(name = "duracion", nullable = false)
    private LocalTime duracion;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipoEvento", length = 20, nullable = false)
    private TipoEvento tipoEvento;

    @Column(name = "costoEvento", precision = 10, scale = 2, nullable = false)
    private BigDecimal costoEvento;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private UsuarioEntity idUsuario;
}
