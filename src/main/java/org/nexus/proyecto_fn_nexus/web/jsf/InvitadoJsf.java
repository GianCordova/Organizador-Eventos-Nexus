package org.nexus.proyecto_fn_nexus.web.jsf;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.nexus.proyecto_fn_nexus.dominio.dto.InvitadoDto;
import org.nexus.proyecto_fn_nexus.dominio.dto.ModInvitadoDto;
import org.nexus.proyecto_fn_nexus.dominio.service.InvitadoService;
import org.nexus.proyecto_fn_nexus.web.jsf.dto.InvitadoJsfDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class InvitadoJsf implements Serializable {

    @Autowired
    private InvitadoService invitadoService;

    private List<InvitadoJsfDto> listaInvitados;
    private InvitadoDto invitadoSeleccionado;

    // Para creación/edición
    private Integer idInvitado;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String estadoAsistencia; // ahora String
    private Integer idEvento;

    private boolean modoEdicion = false;

    public String[] getEstadosDisponibles() {
        // Si quieres, puedes definir un array de Strings fijos o tomarlo de un enum
        return new String[] {"PENDIENTE", "CONFIRMADO", "RECHAZADO"};
    }

    @PostConstruct
    public void init() {
        cargarInvitados();
    }

    public void cargarInvitados() {
        List<InvitadoDto> invitados = invitadoService.obtenerTodo();
        this.listaInvitados = invitados.stream()
                .map(inv -> new InvitadoJsfDto(
                        inv.idInvitado(),        // Integer
                        inv.nombre(),
                        inv.apellido(),
                        inv.correo(),
                        inv.telefono(),
                        inv.estadoAsistencia(),  // String
                        inv.idEvento()           // Integer
                ))
                .toList();
    }

    public void prepararNuevo() {
        limpiarFormulario();
        this.modoEdicion = false;
    }

    public void prepararEdicion(InvitadoJsfDto invitado) {
        this.modoEdicion = true;
        this.idInvitado = invitado.getIdInvitado();
        this.nombre = invitado.getNombre();
        this.apellido = invitado.getApellido();
        this.correo = invitado.getCorreo();
        this.telefono = invitado.getTelefono();
        this.estadoAsistencia = invitado.getEstadoAsistencia();
        this.idEvento = invitado.getIdEvento();
    }

    public void guardar() {
        if (modoEdicion) {
            ModInvitadoDto mod = new ModInvitadoDto(
                    nombre, apellido, correo, telefono,
                    estadoAsistencia,
                    idEvento
            );
            invitadoService.modificarInvitado(idInvitado, mod);
        } else {
            InvitadoDto nuevo = new InvitadoDto(
                    null, nombre, apellido, correo, telefono,
                    estadoAsistencia,
                    idEvento
            );
            invitadoService.guardarInvitado(nuevo);
        }
        cargarInvitados();
    }

    public void eliminar() {
        if (idInvitado != null) {
            invitadoService.eliminarInvitado(idInvitado);
            cargarInvitados();
        }
    }

    private void limpiarFormulario() {
        idInvitado = null;
        nombre = null;
        apellido = null;
        correo = null;
        telefono = null;
        estadoAsistencia = null;
        idEvento = null;
    }

    // Getters y setters
    public List<InvitadoJsfDto> getListaInvitados() { return listaInvitados; }
    public boolean isModoEdicion() { return modoEdicion; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getEstadoAsistencia() { return estadoAsistencia; }
    public void setEstadoAsistencia(String estadoAsistencia) { this.estadoAsistencia = estadoAsistencia; }
    public Integer getIdEvento() { return idEvento; }
    public void setIdEvento(Integer idEvento) { this.idEvento = idEvento; }
    public Integer getIdInvitado() { return idInvitado; }
    public void setIdInvitado(Integer idInvitado) { this.idInvitado = idInvitado; }
}