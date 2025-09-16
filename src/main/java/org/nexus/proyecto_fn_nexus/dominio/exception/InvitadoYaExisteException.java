package org.nexus.proyecto_fn_nexus.dominio.exception;

public class InvitadoYaExisteException extends RuntimeException {
    public InvitadoYaExisteException(String nombre) {
        super("El invitado con el nombre: \"" + nombre +  "\" ya existe.");
    }
}
