package org.nexus.proyecto_fn_nexus.web.jsf;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.nexus.proyecto_fn_nexus.dominio.Estado;
import org.nexus.proyecto_fn_nexus.dominio.Rol;
import org.nexus.proyecto_fn_nexus.dominio.TipoEvento;
import org.nexus.proyecto_fn_nexus.dominio.dto.EventoDto;
import org.nexus.proyecto_fn_nexus.dominio.dto.ModEventoDto;
import org.nexus.proyecto_fn_nexus.dominio.dto.UsuarioDto;
import org.nexus.proyecto_fn_nexus.dominio.dto.ModUsuarioDto;
import org.nexus.proyecto_fn_nexus.dominio.service.EventoService;
import org.nexus.proyecto_fn_nexus.dominio.service.UsuarioService;

import org.nexus.proyecto_fn_nexus.web.jsf.dto.UsuarioJsfDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Named
@ViewScoped
public class UsuarioJsf implements Serializable {


    @Autowired
    private UsuarioService usuarioService;

    private List<UsuarioJsfDto> listaUsuarios;
    private UsuarioDto usuarioSeleccionado;

    // Para creación/edición
    private Long idUsuario;
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private Rol rol;

    private boolean modoEdicion = false;

    @PostConstruct
    public void init() {
        cargarUsuarios();
    }

    public void cargarUsuarios() {
        List<UsuarioDto> usuarios = usuarioService.obtenerTodo();
        // Convertir a DTO específico de JSF
        this.listaUsuarios = usuarios.stream()
                .map(ev -> new UsuarioJsfDto(
                        ev.idUsuario(),
                        ev.nombre(),
                        ev.apellido(),
                        ev.email(),
                        ev.password(),
                        ev.rol()
                ))
                .toList();
    }


    public void prepararNuevo() {
        limpiarFormulario();
        this.modoEdicion = false;
    }

    public void prepararEdicion(UsuarioJsfDto usuario) {
        this.modoEdicion = true;
        this.idUsuario = usuario.getidUsuario();
        this.nombre = usuario.getNombre();
        this.apellido = usuario.getApellido();
        this.email = usuario.getEmail();
        this.password = usuario.getPassword();
        this.rol = usuario.getRol();
    }

    public void guardar() {
        if (modoEdicion) {
            ModUsuarioDto mod = new ModUsuarioDto(
                    nombre,
                    apellido,
                    email,
                    password,
                    rol
            );
            usuarioService.modificarUsuario(idUsuario, mod);
        } else {
            UsuarioDto nuevo = new UsuarioDto(
                    null, nombre, apellido,
                    email,
                    password,
                    rol
            );
            usuarioService.guardarUsuario(nuevo);
        }
        cargarUsuarios();
    }

    public void eliminar() {
        if (idUsuario != null) {
            usuarioService.eliminarUsuario(idUsuario);
            cargarUsuarios();
        }
    }


    private void limpiarFormulario() {
        idUsuario = null;
        nombre = null;
        apellido = null;
        email = null;
        password = null;
        rol = null;
    }

    // Getters y setters
    public List<UsuarioJsfDto> getListaUsuarios() {
        return listaUsuarios;
    }

    public boolean isModoEdicion() {
        return modoEdicion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }


    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Rol[] getusuariosDisponibles() {
        return Rol.values();
    }
}