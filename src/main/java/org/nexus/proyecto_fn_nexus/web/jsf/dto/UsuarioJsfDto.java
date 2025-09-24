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
                        String email, String password,Rol rol) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.rol = rol;

        
    }

    // Getters convencionales para JSF
    public Long getidUsuario() { return idUsuario; }
    public String getnombre() { return nombre; }
    public String getapellido() { return apellido; }
    public String getemail() { return email; }
    public String getpassword() { return password; }
    public Rol getrol() { return rol; }

    
}
