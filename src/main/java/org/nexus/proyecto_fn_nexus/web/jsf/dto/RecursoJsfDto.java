package org.nexus.proyecto_fn_nexus.web.jsf.dto;

import org.nexus.proyecto_fn_nexus.dominio.CategoriaRecurso;

import java.math.BigDecimal;

public class RecursoJsfDto {

    private Long idRecurso;
    private String nombreRecurso;
    private CategoriaRecurso categoria;
    private Integer stock;
    private BigDecimal precioAlquiler;

    public RecursoJsfDto(Long idRecurso, String nombreRecurso, CategoriaRecurso categoria, Integer stock, BigDecimal precioAlquiler) {
        this.idRecurso = idRecurso;
        this.nombreRecurso = nombreRecurso;
        this.categoria = categoria;
        this.stock = stock;
        this.precioAlquiler = precioAlquiler;
    }

    public Long getIdRecurso() {
        return idRecurso;
    }

    public String getNombreRecurso() {
        return nombreRecurso;
    }

    public CategoriaRecurso getCategoria() {
        return categoria;
    }

    public Integer getStock() {
        return stock;
    }

    public BigDecimal getPrecioAlquiler() {
        return precioAlquiler;
    }

}