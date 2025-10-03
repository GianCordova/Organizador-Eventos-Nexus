package org.nexus.proyecto_fn_nexus.persistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.nexus.proyecto_fn_nexus.dominio.CategoriaRecurso;

public class CategoriaRecursoMapper {

    @Named("stringToCategoria")
    public static CategoriaRecurso stringToCategoria(String categoria) {
        if (categoria == null) return null;
        return switch (categoria.toLowerCase()) {
            case "mobiliario" -> CategoriaRecurso.mobiliario;
            case "cubiertasyestructuras" -> CategoriaRecurso.cubiertasyestructuras;
            case "iluminacion" -> CategoriaRecurso.iluminacion;
            case "sonidoymultimendia" -> CategoriaRecurso.sonidoymultimendia;
            case "decoracion" -> CategoriaRecurso.decoracion;
            case "cocinaycatering" -> CategoriaRecurso.cocinaycatering;
            case "entretenimiento" -> CategoriaRecurso.entretenimiento;
            case "otro" -> CategoriaRecurso.otro;
            default -> null;
        };
    }

    @Named("categoriaToString")
    public static String categoriaToString(CategoriaRecurso categoria) {
        if (categoria == null) return null;
        return switch (categoria) {
            case mobiliario -> "mobiliario";
            case cubiertasyestructuras -> "cubiertasyestructuras";
            case iluminacion -> "iluminacion";
            case sonidoymultimendia -> "sonidoymultimendia";
            case decoracion -> "decoracion";
            case cocinaycatering -> "cocinaycatering";
            case entretenimiento -> "entretenimiento";
            case otro -> "otro";
        };
    }
}
