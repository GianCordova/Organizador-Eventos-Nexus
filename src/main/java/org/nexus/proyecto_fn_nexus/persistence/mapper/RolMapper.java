package org.nexus.proyecto_fn_nexus.persistence.mapper;

import org.mapstruct.Named;
import org.nexus.proyecto_fn_nexus.dominio.Rol;

public class RolMapper {


    @Named("stringToRol")
    public static Rol stringToRol(String rol) {
        if (rol == null) return null;
        return switch (rol.toLowerCase()) {
            case "cliente" -> Rol.cliente;
            case "administrador" -> Rol.administrador;

            default -> null;
        };
    }

    @Named("rolToString")
    public static String rolToString(Rol estado) {
        if (estado == null) return null;
        return switch (estado) {
            case cliente -> "cliente";
            case administrador -> "en administrador";

        };
    }
}
