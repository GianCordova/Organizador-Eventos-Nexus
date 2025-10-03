package org.nexus.proyecto_fn_nexus.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "proveedores")
public class ProveedorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProveedor")
    private Long idProveedor;

    @Column(nullable = false, unique = true, length = 128)
    private String nombreProveedor;

    @Column(nullable = false, length = 100)
    private String servicio;

    @Column(nullable = false, unique = true, length = 255)
    private String contacto;
}
