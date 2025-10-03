package org.nexus.proyecto_fn_nexus.web.jsf;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.nexus.proyecto_fn_nexus.dominio.CategoriaRecurso;
import org.nexus.proyecto_fn_nexus.dominio.dto.ModificarRecursoDto;
import org.nexus.proyecto_fn_nexus.dominio.dto.RecursoDto;
import org.nexus.proyecto_fn_nexus.dominio.service.RecursoService;
import org.nexus.proyecto_fn_nexus.web.jsf.dto.RecursoJsfDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Named
@ViewScoped
public class RecursoJsf implements Serializable {

    @Autowired
    private RecursoService recursoService;

    private List<RecursoJsfDto> listaRecursos;

    // Para creación/edición
    private Long idRecurso;
    private String nombreRecurso;
    private CategoriaRecurso categoria;
    private Integer stock;
    private BigDecimal precioAlquiler;

    private boolean modoEdicion = false;

    @PostConstruct
    public void init() {
        cargarRecursos();
    }

    public void cargarRecursos() {
        List<RecursoDto> recursos = recursoService.obtenerTodo();
        this.listaRecursos = recursos.stream()
                .map(r -> new RecursoJsfDto(
                        r.idRecurso(),
                        r.nombreRecurso(),
                        r.categoria(),
                        r.stock(),
                        r.precioAlquiler()
                ))
                .toList();
    }

    public void prepararNuevo() {
        limpiarFormulario();
        this.modoEdicion = false;
    }

    public void prepararEdicion(RecursoJsfDto recurso) {
        this.modoEdicion = true;
        this.idRecurso = recurso.getIdRecurso();
        this.nombreRecurso = recurso.getNombreRecurso();
        this.categoria = recurso.getCategoria();
        this.stock = recurso.getStock();
        this.precioAlquiler = recurso.getPrecioAlquiler();
    }

    public void guardar() {
        if (modoEdicion) {
            ModificarRecursoDto mod = new ModificarRecursoDto(
                    nombreRecurso, categoria, stock, precioAlquiler
            );
            recursoService.modificarRecurso(idRecurso, mod);
        } else {
            RecursoDto nuevo = new RecursoDto(
                    null, nombreRecurso, categoria, stock, precioAlquiler
            );
            recursoService.guardarRecurso(nuevo);
        }
        cargarRecursos();
    }

    public void eliminar() {
        if (idRecurso != null) {
            recursoService.eliminarRecurso(idRecurso);
            cargarRecursos();
        }
    }

    private void limpiarFormulario() {
        idRecurso = null;
        nombreRecurso = null;
        categoria = null;
        stock = null;
        precioAlquiler = null;
    }

    // Getters y setters
    public List<RecursoJsfDto> getListaRecursos() {
        return listaRecursos;
    }

    public boolean isModoEdicion() {
        return modoEdicion;
    }

    public Long getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(Long idRecurso) {
        this.idRecurso = idRecurso;
    }

    public String getNombreRecurso() {
        return nombreRecurso;
    }

    public void setNombreRecurso(String nombreRecurso) {
        this.nombreRecurso = nombreRecurso;
    }

    public CategoriaRecurso getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaRecurso categoria) {
        this.categoria = categoria;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public BigDecimal getPrecioAlquiler() {
        return precioAlquiler;
    }

    public void setPrecioAlquiler(BigDecimal precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }

    public CategoriaRecurso[] getCategoriasDisponibles() {
        return CategoriaRecurso.values();
    }
}