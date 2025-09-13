package org.nexus.proyecto_fn_nexus.persistence.mapper;

import org.mapstruct.Named;
import org.nexus.proyecto_fn_nexus.dominio.TipoEvento;

public class TipoEventoMapper {

    @Named("stringToTipoEvento")
    public static TipoEvento stringToTipoEvento(String tipo) {
        if (tipo == null) return null;
        return switch (tipo.toLowerCase()) {
            case "social" -> TipoEvento.social;
            case "corporativo" -> TipoEvento.corporativo;
            case "cultural" -> TipoEvento.cultural;
            case "recreativo" -> TipoEvento.recreativo;
            case "otro" -> TipoEvento.otro;
            default -> null;
        };
    }

    @Named("tipoEventoToString")
    public static String tipoEventoToString(TipoEvento tipoEvento) {
        if (tipoEvento == null) return null;
        return switch (tipoEvento) {
            case social -> "social";
            case corporativo -> "corporativo";
            case cultural -> "cultural";
            case recreativo -> "recreativo";
            case otro -> "otro";
        };
    }
}
