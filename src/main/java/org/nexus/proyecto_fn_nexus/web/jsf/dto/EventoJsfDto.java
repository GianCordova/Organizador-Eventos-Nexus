package org.nexus.proyecto_fn_nexus.web.jsf.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import org.nexus.proyecto_fn_nexus.dominio.Estado;
import org.nexus.proyecto_fn_nexus.dominio.TipoEvento;

public class EventoJsfDto {

    private Long idEvento;
    private String nombreEvento;
    private String descripcion;
    private LocalDate fecha;
    private String lugar;
    private Estado estado;
    private LocalTime duracion;
    private TipoEvento tipoEvento;
    private BigDecimal costoEvento;
    private Long idUsuario;

    public EventoJsfDto(Long idEvento, String nombreEvento, String descripcion, LocalDate fecha,
                        String lugar, Estado estado, LocalTime duracion, TipoEvento tipoEvento,
                        BigDecimal costoEvento, Long idUsuario) {
        this.idEvento = idEvento;
        this.nombreEvento = nombreEvento;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.lugar = lugar;
        this.estado = estado;
        this.duracion = duracion;
        this.tipoEvento = tipoEvento;
        this.costoEvento = costoEvento;
        this.idUsuario = idUsuario;
    }

    // Getters convencionales para JSF
    public Long getIdEvento() { return idEvento; }
    public String getNombreEvento() { return nombreEvento; }
    public String getDescripcion() { return descripcion; }
    public LocalDate getFecha() { return fecha; }
    public String getLugar() { return lugar; }
    public Estado getEstado() { return estado; }
    public LocalTime getDuracion() { return duracion; }
    public TipoEvento getTipoEvento() { return tipoEvento; }
    public BigDecimal getCostoEvento() { return costoEvento; }
    public Long getIdUsuario() { return idUsuario; }
}
