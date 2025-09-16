package org.nexus.proyecto_fn_nexus.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Invitados")
@Data
public class InvitadoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idInvitado;
    @Column(length = 50, nullable = false)
    private String nombre;
    @Column(length = 50, nullable = false)
    private String apellido;
    @Column(length = 100)
    private String correo;
    @Column(length = 20)
    private String telefono;
    @Column(length = 10, nullable = false)
    private String estadoAsistencia;
    @Column(nullable = false)
    private Integer idEvento;


}