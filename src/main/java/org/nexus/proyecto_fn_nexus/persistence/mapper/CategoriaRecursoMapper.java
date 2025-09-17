package org.nexus.proyecto_fn_nexus.persistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.nexus.proyecto_fn_nexus.dominio.CategoriaRecurso;

public interface CategoriaRecursoMapper {

    @Named("generarCategory")
    public static CategoriaRecurso generarCategory(String categoria) {
        if (categoria == null) return null;
        return switch (categoria.toUpperCase()) {
            case "MOBILIARIO" -> CategoriaRecurso.MOBILIARIO;
            case "COVERSANDSTRUCTURES" -> CategoriaRecurso.COVERSANDSTRUCTURES;
            case "ILUMINACION" -> CategoriaRecurso.ILUMINACION;
            case "SOUNDANDMULTIMEDIA" -> CategoriaRecurso.SOUNDANDMULTIMEDIA;
            case "DECORACION" -> CategoriaRecurso.DECORACION;
            case "KITCHENANDCATERING" -> CategoriaRecurso.KITCHENANDCATERING;
            case "ENTRETENIMIENTO" -> CategoriaRecurso.ENTRETENIMIENTO;
            case "OTRO" -> CategoriaRecurso.OTRO;
            default -> null;
        };
    }

    @Named("generarCategoria")
    public static String generarCategoria(CategoriaRecurso category) {
        if (category == null) return null;
        return switch (category) {
            case MOBILIARIO -> "MOBILIARIO";
            case COVERSANDSTRUCTURES -> "COVERSANDSTRUCTURES";
            case ILUMINACION -> "ILUMINACION";
            case SOUNDANDMULTIMEDIA -> "SOUNDANDMULTIMEDIA";
            case DECORACION -> "DECORACION";
            case KITCHENANDCATERING -> "KITCHENANDCATERING";
            case ENTRETENIMIENTO -> "ENTRETENIMIENTO";
            case OTRO -> "OTRO";
        };
    }
}
