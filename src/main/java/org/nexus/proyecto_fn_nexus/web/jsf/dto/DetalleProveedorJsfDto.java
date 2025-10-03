package org.nexus.proyecto_fn_nexus.web.jsf.dto;

import java.math.BigDecimal;

public class DetalleProveedorJsfDto {

    private Long idDetalleProveedor;
    private Long idEvento;
    private Long idProveedor;
    private BigDecimal costo;
    private String observaciones;

    public DetalleProveedorJsfDto(Long idDetalleProveedor, Long idEvento, Long idProveedor,
                                  BigDecimal costo, String observaciones) {
        this.idDetalleProveedor = idDetalleProveedor;
        this.idEvento = idEvento;
        this.idProveedor = idProveedor;
        this.costo = costo;
        this.observaciones = observaciones;
    }

    public Long getIdDetalleProveedor() {
        return idDetalleProveedor;
    }

    public Long getIdEvento() {
        return idEvento;
    }

    public Long getIdProveedor() {
        return idProveedor;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public String getObservaciones() {
        return observaciones;
    }
}
