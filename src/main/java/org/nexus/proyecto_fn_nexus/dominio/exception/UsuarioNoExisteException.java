package org.nexus.proyecto_fn_nexus.dominio.exception;

public class UsuarioNoExisteException extends RuntimeException {
    public UsuarioNoExisteException (Long idUsuario) {
        super("El usuario con ID: " + idUsuario + " no existe en el sistema");
    }

}

