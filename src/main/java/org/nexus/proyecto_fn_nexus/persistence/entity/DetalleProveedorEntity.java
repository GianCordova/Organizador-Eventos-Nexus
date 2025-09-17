package org.nexus.proyecto_fn_nexus.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "DetalleProveedores")
@Data
public class DetalleProveedorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDetalleProveedor")
    private Long idDetalleProveedor;

    // Relación con evento (organizador)
    @ManyToOne
    @JoinColumn(name = "idEvento", nullable = false)
    private InvitadoEntity evento;

    // Relación con proveedor (organizador)
    @ManyToOne
    @JoinColumn(name = "idProveedor", nullable = false)
    private RecursoEntity proveedor;


    @Column(name = "costo", precision = 10, scale = 2, nullable = false)
    private BigDecimal costo;


    @Column(name = "observaciones", length = 100, nullable = false)
    private String observaciones;
}

