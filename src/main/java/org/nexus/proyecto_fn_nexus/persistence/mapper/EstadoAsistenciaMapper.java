package org.nexus.proyecto_fn_nexus.persistence.mapper;

import org.nexus.proyecto_fn_nexus.dominio.EstadoAsistencia;
import org.mapstruct.Named;
public class EstadoAsistenciaMapper {

    @Named("stringToEstadoAsistencia")
    public static EstadoAsistencia stringToEstadoAsistencia(String estado) {
        if (estado == null) return null;
        return switch (estado.toLowerCase()) {
            case "pendiente" -> EstadoAsistencia.pendiente;
            case "confirmado" -> EstadoAsistencia.confirmado;
            case "rechazado" -> EstadoAsistencia.rechazado;
            default -> null;  // En caso de que el valor no coincida
        };
    }


    @Named("estadoAsistenciaToString")
    public static String estadoAsistenciaToString(EstadoAsistencia estadoAsistencia) {
        if (estadoAsistencia == null) return null;
        return switch (estadoAsistencia) {
            case pendiente -> "pendiente";
            case confirmado -> "confirmado";
            case rechazado -> "rechazado";
        };
    }
}