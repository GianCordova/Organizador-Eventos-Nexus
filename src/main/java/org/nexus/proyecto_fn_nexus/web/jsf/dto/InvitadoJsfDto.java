package org.nexus.proyecto_fn_nexus.web.jsf.dto;

import org.nexus.proyecto_fn_nexus.dominio.EstadoAsistencia;

public class InvitadoJsfDto {

    private Long idInvitado;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private EstadoAsistencia estadoAsistencia;
    private Long idEvento;

    public InvitadoJsfDto(Long idInvitado, String nombre, String apellido, String correo,
                          String telefono, EstadoAsistencia estadoAsistencia, Long idEvento) {
        this.idInvitado = idInvitado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.estadoAsistencia = estadoAsistencia;
        this.idEvento = idEvento;
    }

    public Long getIdInvitado() {
        return idInvitado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public EstadoAsistencia getEstadoAsistencia() {
        return estadoAsistencia;
    }

    public Long getIdEvento() {
        return idEvento;
    }
}