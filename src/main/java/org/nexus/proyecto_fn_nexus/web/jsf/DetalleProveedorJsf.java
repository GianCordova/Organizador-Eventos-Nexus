package org.nexus.proyecto_fn_nexus.web.jsf;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.nexus.proyecto_fn_nexus.dominio.dto.DetalleProveedorDto;
import org.nexus.proyecto_fn_nexus.dominio.dto.ModDetalleProveedorDto;
import org.nexus.proyecto_fn_nexus.dominio.service.DetalleProveedorService;
import org.nexus.proyecto_fn_nexus.web.jsf.dto.DetalleProveedorJsfDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Named
@ViewScoped
public class DetalleProveedorJsf implements Serializable {

    @Autowired
    private DetalleProveedorService detalleProveedorService;

    private List<DetalleProveedorJsfDto> listaDetalleProveedores;
    private DetalleProveedorDto detalleProveedorSeleccionado;

    // Para creación/edición
    private Long idDetalleProveedor;
    private Long idEvento;
    private Long idProveedor;
    private BigDecimal costo;
    private String observaciones;

    private boolean modoEdicion = false;

    @PostConstruct
    public void init() {
        cargarDetalleProveedores();
    }

    public void cargarDetalleProveedores() {
        List<DetalleProveedorDto> detalles = detalleProveedorService.obtenerTodo();
        this.listaDetalleProveedores = detalles.stream()
                .map(d -> new DetalleProveedorJsfDto(
                        d.idDetalleProveedor(),
                        d.idEvento(),
                        d.idProveedor(),
                        d.costo(),
                        d.observaciones()
                ))
                .toList();
    }

    public void prepararNuevo() {
        limpiarFormulario();
        this.modoEdicion = false;
    }

    public void prepararEdicion(DetalleProveedorJsfDto detalle) {
        this.modoEdicion = true;
        this.idDetalleProveedor = detalle.getIdDetalleProveedor();
        this.idEvento = detalle.getIdEvento();
        this.idProveedor = detalle.getIdProveedor();
        this.costo = detalle.getCosto();
        this.observaciones = detalle.getObservaciones();
    }

    public void guardar() {
        if (modoEdicion) {
            ModDetalleProveedorDto mod = new ModDetalleProveedorDto(
                    idEvento,
                    idProveedor,
                    costo,
                    observaciones
            );
            detalleProveedorService.modificarDetalleProveedor(idDetalleProveedor, mod);
        } else {
            DetalleProveedorDto nuevo = new DetalleProveedorDto(
                    null,
                    idEvento,
                    idProveedor,
                    costo,
                    observaciones
            );
            detalleProveedorService.guardarDetalleProveedor(nuevo);
        }
        cargarDetalleProveedores();
    }

    public void eliminar() {
        if (idDetalleProveedor != null) {
            detalleProveedorService.eliminarDetalleProveedor(idDetalleProveedor);
            cargarDetalleProveedores();
        }
    }

    private void limpiarFormulario() {
        idDetalleProveedor = null;
        idEvento = null;
        idProveedor = null;
        costo = null;
        observaciones = null;
    }

    // Getters y setters
    public List<DetalleProveedorJsfDto> getListaDetalleProveedores() {
        return listaDetalleProveedores;
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

    public Long getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Long idProveedor) {
        this.idProveedor = idProveedor;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Long getIdDetalleProveedor() {
        return idDetalleProveedor;
    }

    public void setIdDetalleProveedor(Long idDetalleProveedor) {
        this.idDetalleProveedor = idDetalleProveedor;
    }
}
