package org.nexus.proyecto_fn_nexus.persistence.mapper;

import org.mapstruct.Named;
import org.nexus.proyecto_fn_nexus.dominio.Estado;

public class EstadoMapper {

    @Named("stringToEstado")
    public static Estado stringToEstado(String estado) {
        if (estado == null) return null;
        return switch (estado.toLowerCase()) {
            case "pendiente" -> Estado.pendiente;
            case "enProgreso" -> Estado.enProgreso;
            case "completada" -> Estado.completada;
            default -> null;
        };
    }

    @Named("estadoToString")
    public static String estadoToString(Estado estado) {
        if (estado == null) return null;
        return switch (estado) {
            case pendiente -> "pendiente";
            case enProgreso -> "enProgreso";
            case completada -> "completada";
        };
    }
}
