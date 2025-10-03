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
import java.math.BigDecimal;

@Entity
@Table(name = "DetalleProveedores")
@Data
public class DetalleProveedorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDetalleProveedor")
    private Long idDetalleProveedor;

    @ManyToOne
    @JoinColumn(name = "idEvento", nullable = false)
    private EventoEntity evento;

    @ManyToOne
    @JoinColumn(name = "idProveedor", nullable = false)
    private ProveedorEntity proveedor;

    @Column(name = "costo", precision = 10, scale = 2, nullable = false)
    private BigDecimal costo;

    @Column(name = "observaciones", length = 100, nullable = false)
    private String observaciones;
}
