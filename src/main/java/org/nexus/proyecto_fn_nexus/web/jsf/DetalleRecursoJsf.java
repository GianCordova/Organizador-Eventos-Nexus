package org.nexus.proyecto_fn_nexus.web.jsf;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.nexus.proyecto_fn_nexus.dominio.dto.DetalleRecursoDto;
import org.nexus.proyecto_fn_nexus.dominio.dto.ModDetalleRecursoDto;
import org.nexus.proyecto_fn_nexus.dominio.service.DetalleRecursoService;
import org.nexus.proyecto_fn_nexus.web.jsf.dto.DetalleRecursoJsfDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class DetalleRecursoJsf implements Serializable {

    @Autowired
    private DetalleRecursoService detalleRecursoService;

    private List<DetalleRecursoJsfDto> listaDetalleRecursos;
    private DetalleRecursoDto detalleRecursoSeleccionado;

    // Para creación/edición
    private Long idDetalleRecurso;
    private Long idEvento;
    private Long idRecurso;
    private Integer cantidad;

    private boolean modoEdicion = false;

    @PostConstruct
    public void init() {
        cargarDetalleRecursos();
    }

    public void cargarDetalleRecursos() {
        List<DetalleRecursoDto> detalles = detalleRecursoService.obtenerTodo();
        this.listaDetalleRecursos = detalles.stream()
                .map(d -> new DetalleRecursoJsfDto(
                        d.idDetalleRecurso(),
                        d.idEvento(),
                        d.idRecurso(),
                        d.cantidad()
                ))
                .toList();
    }

    public void prepararNuevo() {
        limpiarFormulario();
        this.modoEdicion = false;
    }

    public void prepararEdicion(DetalleRecursoJsfDto detalle) {
        this.modoEdicion = true;
        this.idDetalleRecurso = detalle.getIdDetalleRecurso();
        this.idEvento = detalle.getIdEvento();
        this.idRecurso = detalle.getIdRecurso();
        this.cantidad = detalle.getCantidad();
    }

    public void guardar() {
        if (modoEdicion) {
            ModDetalleRecursoDto mod = new ModDetalleRecursoDto(
                    idEvento,
                    idRecurso,
                    cantidad
            );
            detalleRecursoService.modificarDetalleRecurso(idDetalleRecurso, mod);
        } else {
            DetalleRecursoDto nuevo = new DetalleRecursoDto(
                    null,
                    idEvento,
                    idRecurso,
                    cantidad
            );
            detalleRecursoService.guardarDetalleRecurso(nuevo);
        }
        cargarDetalleRecursos();
    }

    public void eliminar() {
        if (idDetalleRecurso != null) {
            detalleRecursoService.eliminarDetalleRecurso(idDetalleRecurso);
            cargarDetalleRecursos();
        }
    }

    private void limpiarFormulario() {
        idDetalleRecurso = null;
        idEvento = null;
        idRecurso = null;
        cantidad = null;
    }

    // Getters y setters
    public List<DetalleRecursoJsfDto> getListaDetalleRecursos() {
        return listaDetalleRecursos;
    }

    public boolean isModoEdicion() {
        return modoEdicion;
    }

    public Long getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Long idEvento) {
        this.idEvento = idEvento;
    }

    public Long getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(Long idRecurso) {
        this.idRecurso = idRecurso;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Long getIdDetalleRecurso() {
        return idDetalleRecurso;
    }

    public void setIdDetalleRecurso(Long idDetalleRecurso) {
        this.idDetalleRecurso = idDetalleRecurso;
    }
}
