package org.nexus.proyecto_fn_nexus.web.jsf.dto;

public class DetalleRecursoJsfDto {

    private Long idDetalleRecurso;
    private Long idEvento;
    private Long idRecurso;
    private Integer cantidad;

    public DetalleRecursoJsfDto(Long idDetalleRecurso, Long idEvento, Long idRecurso, Integer cantidad) {
        this.idDetalleRecurso = idDetalleRecurso;
        this.idEvento = idEvento;
        this.idRecurso = idRecurso;
        this.cantidad = cantidad;
    }

    public Long getIdDetalleRecurso() {
        return idDetalleRecurso;
    }

    public Long getIdEvento() {
        return idEvento;
    }

    public Long getIdRecurso() {
        return idRecurso;
    }

    public Integer getCantidad() {
        return cantidad;
    }
}
