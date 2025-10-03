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
import org.nexus.proyecto_fn_nexus.dominio.EstadoAsistencia;

@Entity
@Table(name = "Invitados")
@Data
public class InvitadoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInvitado;

    @Column(length = 50, nullable = false)
    private String nombre;

    @Column(length = 50, nullable = false)
    private String apellido;

    @Column(length = 100)
    private String correo;

    @Column(length = 20)
    private String telefono;

    @Enumerated(EnumType.STRING)
    @Column(name = "estadoAsistencia", length = 20, nullable = false)
    private EstadoAsistencia estadoAsistencia;

    @ManyToOne
    @JoinColumn(name = "idEvento", nullable = false)
    private EventoEntity idEvento;
}
