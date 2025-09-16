package org.nexus.proyecto_fn_nexus.persistence.mapper;

import org.nexus.proyecto_fn_nexus.dominio.EstadoAsistencia;
import org.mapstruct.Named;

import java.util.Locale;

public class EstadoAsistenciaMapper {

    @Named("generarEstado")
    public static EstadoAsistencia generarEstado(String estado) {
        if (estado == null) {
            return null;
        }

        return switch (estado.toUpperCase(Locale.ROOT)) {
            case "PENDIENTE" -> EstadoAsistencia.PENDIENTE;
            case "CONFIRMADO" -> EstadoAsistencia.CONFIRMADO;
            case "RECHAZADO" -> EstadoAsistencia.RECHAZADO;
            default -> null;  // En caso de que el valor no coincida
        };
    }


    @Named("generarEstadoString")
    public static String generarEstadoString(EstadoAsistencia estadoAsistencia) {
        if (estadoAsistencia == null) {
            return null;
        }
        return switch (estadoAsistencia) {
            case PENDIENTE -> "PENDIENTE";
            case CONFIRMADO -> "CONFIRMADO";
            case RECHAZADO -> "RECHAZADO";
        };
    }
}