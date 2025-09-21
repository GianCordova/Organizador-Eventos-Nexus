package org.nexus.proyecto_fn_nexus.web.jsf.dto;

import org.nexus.proyecto_fn_nexus.dominio.EstadoAsistencia;

public class InvitadoJsfDto {
    private Integer idInvitado;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String estadoAsistencia;
    private Integer idEvento;

    public InvitadoJsfDto(Integer idInvitado, String nombre, String apellido, String correo,
                          String telefono, String estadoAsistencia, Integer idEvento) {
        this.idInvitado = idInvitado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.estadoAsistencia = estadoAsistencia;
        this.idEvento = idEvento;
    }

    // Getters
    public Integer getIdInvitado() { return idInvitado; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getCorreo() { return correo; }
    public String getTelefono() { return telefono; }
    public String getEstadoAsistencia() { return estadoAsistencia; }
    public Integer getIdEvento() { return idEvento; }
}