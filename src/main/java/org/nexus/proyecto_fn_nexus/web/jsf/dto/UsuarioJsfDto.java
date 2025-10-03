package org.nexus.proyecto_fn_nexus.web.jsf.dto;

import org.nexus.proyecto_fn_nexus.dominio.Rol;



public class UsuarioJsfDto {

    private Long idUsuario;
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private Rol rol;


    public UsuarioJsfDto(Long idUsuario, String nombre, String apellido,
                         String email, String password, Rol rol) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.rol = rol;


    }

    public Long getidUsuario() {
        return idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Rol getRol() {
        return rol;
    }
}