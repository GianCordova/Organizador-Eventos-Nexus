package org.nexus.proyecto_fn_nexus.dominio.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;

public record DetalleProveedorDto(

        Long idDetalleProveedor,

        @NotNull(message = "El id del evento es obligatorio")
        Long idEvento,

        @NotNull(message = "El id del proveedor es obligatorio")
        Long idProveedor,

        @NotNull(message = "El costo es obligatorio")
        @DecimalMin(value = "0.0", message = "El costo no puede ser negativo")
        BigDecimal costo,

        @Size(max = 255, message = "Las observaciones no pueden exceder 255 caracteres")
        String observaciones

) {}
