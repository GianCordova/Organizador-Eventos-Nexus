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

    // Setters convencionales para JSF (por si es necesario en tu implementación)
    public void setIdProveedor(Long idProveedor) {
        this.idProveedor = idProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
}
