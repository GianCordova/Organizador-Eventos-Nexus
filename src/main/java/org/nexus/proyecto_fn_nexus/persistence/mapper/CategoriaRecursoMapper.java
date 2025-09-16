package org.nexus.proyecto_fn_nexus.persistence.mapper;

import org.nexus.proyecto_fn_nexus.dominio.CategoriaRecurso;
import org.mapstruct.Named;

public class CategoriaRecursoMapper {

    @Named("generarCategory")
    public static CategoriaRecurso generarCategory(String categoria) {
        if (categoria == null) {
            return null;
        }
        return switch (categoria.toUpperCase()) {
            case "MOBILIARIO" -> CategoriaRecurso.FURNITURE;
            case "CUBIERTAS_Y_ESTRUCTURAS" -> CategoriaRecurso.COVERS_AND_STRUCTURES;
            case "ILUMINACION" -> CategoriaRecurso.LIGHTS;
            case "SONIDO_Y_MULTIMEDIA" -> CategoriaRecurso.SOUND_AND_MULTIMEDIA;
            case "DECORACION" -> CategoriaRecurso.DECORATION;
            case "COCINA_Y_CATERING" -> CategoriaRecurso.KITCHEN_AND_CATERING;
            case "ENTRETENIMIENTO" -> CategoriaRecurso.ENTERTAINMENT;
            case "OTRO" -> CategoriaRecurso.OTHER;
            default -> null;
        };
    }

    @Named("generarCategoria")
    public static String generarCategoria(CategoriaRecurso category) {
        if (category == null) {
            return null;
        }
        return switch (category) {
            case FURNITURE -> "MOBILIARIO";
            case COVERS_AND_STRUCTURES -> "CUBIERTAS_Y_ESTRUCTURAS";
            case LIGHTS -> "ILUMINACION";
            case SOUND_AND_MULTIMEDIA -> "SONIDO_Y_MULTIMEDIA";
            case DECORATION -> "DECORACION";
            case KITCHEN_AND_CATERING -> "COCINA_Y_CATERING";
            case ENTERTAINMENT -> "ENTRETENIMIENTO";
            case OTHER -> "OTRO";
        };
    }
}
