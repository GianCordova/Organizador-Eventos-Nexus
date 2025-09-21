package org.nexus.proyecto_fn_nexus.web.jsf;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.nexus.proyecto_fn_nexus.dominio.Estado;
import org.nexus.proyecto_fn_nexus.dominio.TipoEvento;
import org.nexus.proyecto_fn_nexus.dominio.dto.EventoDto;
import org.nexus.proyecto_fn_nexus.dominio.dto.ModEventoDto;
import org.nexus.proyecto_fn_nexus.dominio.service.EventoService;
import org.nexus.proyecto_fn_nexus.web.jsf.dto.EventoJsfDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Named
@ViewScoped
public class EventoBean implements Serializable {

    @Autowired
    private EventoService eventoService;

    private List<EventoJsfDto> listaEventos;
    private EventoDto eventoSeleccionado;

    // Para creación/edición
    private Long idEvento;
    private String nombreEvento;
    private String descripcion;
    private LocalDate fecha;
    private String lugar;
    private Estado estado; // como string para binding, luego convertir
    private LocalTime duracion;
    private TipoEvento tipoEvento;
    private BigDecimal costoEvento;
    private Long idUsuario;

    private boolean modoEdicion = false;

    public Estado[] getEstadosDisponibles() {
        return Estado.values();
    }
// En EventoBean

    public TipoEvento[] getTiposEventoDisponibles() {
        return TipoEvento.values();
    }


    @PostConstruct
    public void init() {
        cargarEventos();
    }

    public void cargarEventos() {
        List<EventoDto> eventos = eventoService.obtenerTodo();
        // Convertir a DTO específico de JSF
        this.listaEventos = eventos.stream()
                .map(ev -> new EventoJsfDto(
                        ev.idEvento(),
                        ev.nombreEvento(),
                        ev.descripcion(),
                        ev.fecha(),
                        ev.lugar(),
                        ev.estado(),
                        ev.duracion(),
                        ev.tipoEvento(),
                        ev.costoEvento(),
                        ev.idUsuario()
                ))
                .toList();
    }


    public void prepararNuevo() {
        limpiarFormulario();
        this.modoEdicion = false;
    }

    public void prepararEdicion(EventoJsfDto evento) {
        this.modoEdicion = true;
        this.idEvento = evento.getIdEvento();
        this.nombreEvento = evento.getNombreEvento();
        this.descripcion = evento.getDescripcion();
        this.fecha = evento.getFecha();
        this.lugar = evento.getLugar();
        this.estado = evento.getEstado(); // default
        this.duracion = evento.getDuracion();
        this.tipoEvento = evento.getTipoEvento(); // default
        this.costoEvento = evento.getCostoEvento();
        this.idUsuario = evento.getIdUsuario();
    }

    public void guardar() {
        if (modoEdicion) {
            ModEventoDto mod = new ModEventoDto(
                    nombreEvento, descripcion, fecha, lugar,
                    estado,
                    duracion,
                    tipoEvento,
                    costoEvento,
                    idUsuario
            );
            eventoService.modificarEvento(idEvento, mod);
        } else {
            EventoDto nuevo = new EventoDto(
                    null, nombreEvento, descripcion, fecha, lugar,
                    estado,
                    duracion,
                    tipoEvento,
                    costoEvento,
                    idUsuario
            );
            eventoService.guardarEvento(nuevo);
        }
        cargarEventos();
    }

    public void eliminar() {
        if (idEvento != null) {
            eventoService.eliminarEvento(idEvento);
            cargarEventos();
        }
    }



    private void limpiarFormulario() {
        idEvento = null;
        nombreEvento = null;
        descripcion = null;
        fecha = null;
        lugar = null;
        estado = null;
        duracion = null;
        tipoEvento = null;
        costoEvento = null;
        idUsuario = null;
    }

    // Getters y setters
    public List<EventoJsfDto> getListaEventos() { return listaEventos; }
    public boolean isModoEdicion() { return modoEdicion; }
    public String getNombreEvento() { return nombreEvento; }
    public void setNombreEvento(String nombreEvento) { this.nombreEvento = nombreEvento; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public String getLugar() { return lugar; }
    public void setLugar(String lugar) { this.lugar = lugar; }
    public Estado getEstado() { return estado; }
    public void setEstado(Estado estado) { this.estado = estado; }
    public LocalTime getDuracion() { return duracion; }
    public void setDuracion(LocalTime duracion) { this.duracion = duracion; }
    public TipoEvento getTipoEvento() { return tipoEvento; }
    public void setTipoEvento(TipoEvento tipoEvento) { this.tipoEvento = tipoEvento; }
    public BigDecimal getCostoEvento() { return costoEvento; }
    public void setCostoEvento(BigDecimal costoEvento) { this.costoEvento = costoEvento; }
    public Long getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Long idUsuario) { this.idUsuario = idUsuario; }
    public Long getIdEvento() {return idEvento;}
    public void setIdEvento(Long idEvento) {this.idEvento = idEvento;}
}
