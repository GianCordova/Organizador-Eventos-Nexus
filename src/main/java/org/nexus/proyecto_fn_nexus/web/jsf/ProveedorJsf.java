package org.nexus.proyecto_fn_nexus.web.jsf;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.nexus.proyecto_fn_nexus.dominio.dto.ModProveedorDto;
import org.nexus.proyecto_fn_nexus.dominio.dto.ProveedorDto;
import org.nexus.proyecto_fn_nexus.dominio.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Named
@ViewScoped
public class ProveedorJsf implements Serializable {

    @Autowired
    private ProveedorService proveedorService;

    // Lista para la vista
    private List<ProveedorDto> listaProveedores;

    // Para creación/edición
    private Long idProveedor;
    private String nombreProveedor;
    private String servicio;
    private String contacto;

    private boolean modoEdicion = false;

    @PostConstruct
    public void init() {
        cargarProveedores();
    }

    public void cargarProveedores() {
        this.listaProveedores = proveedorService.obtenerTodo();
    }

    public void prepararNuevo() {
        limpiarFormulario();
        this.modoEdicion = false;
    }

    public void prepararEdicion(ProveedorDto proveedor) {
        this.modoEdicion = true;
        this.idProveedor = proveedor.idProveedor();
        this.nombreProveedor = proveedor.nombreProveedor();
        this.servicio = proveedor.servicio();
        this.contacto = proveedor.contacto();
    }

    public void guardar() {
        if (modoEdicion) {
            ModProveedorDto mod = new ModProveedorDto(
                    nombreProveedor,
                    servicio,
                    contacto
            );
            proveedorService.modificarProveedor(idProveedor, mod);
        } else {
            ProveedorDto nuevo = new ProveedorDto(
                    null, nombreProveedor, servicio, contacto
            );
            proveedorService.guardarProveedor(nuevo);
        }
        cargarProveedores();
        limpiarFormulario();
    }

    public void eliminar() {
        if (idProveedor != null) {
            proveedorService.eliminarProveedor(idProveedor);
            cargarProveedores();
            limpiarFormulario();
        }
    }

    private void limpiarFormulario() {
        idProveedor = null;
        nombreProveedor = null;
        servicio = null;
        contacto = null;
    }

    // Getters y Setters
    public List<ProveedorDto> getListaProveedores() { return listaProveedores; }

    public boolean isModoEdicion() { return modoEdicion; }

    public Long getIdProveedor() { return idProveedor; }
    public void setIdProveedor(Long idProveedor) { this.idProveedor = idProveedor; }

    public String getNombreProveedor() { return nombreProveedor; }
    public void setNombreProveedor(String nombreProveedor) { this.nombreProveedor = nombreProveedor; }

    public String getServicio() { return servicio; }
    public void setServicio(String servicio) { this.servicio = servicio; }

    public String getContacto() { return contacto; }
    public void setContacto(String contacto) { this.contacto = contacto; }
}
