package org.nexus.proyecto_fn_nexus.web.jsf.dto;

public class ProveedorJsfDto {

    private Long idProveedor;
    private String nombreProveedor;
    private String servicio;
    private String contacto;

    // Constructor
    public ProveedorJsfDto(Long idProveedor, String nombreProveedor, String servicio, String contacto) {
        this.idProveedor = idProveedor;
        this.nombreProveedor = nombreProveedor;
        this.servicio = servicio;
        this.contacto = contacto;
    }

    // Getters convencionales para JSF
    public Long getIdProveedor() {
        return idProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public String getServicio() {
        return servicio;
    }

    public String getContacto() {
        return contacto;
    }
}
