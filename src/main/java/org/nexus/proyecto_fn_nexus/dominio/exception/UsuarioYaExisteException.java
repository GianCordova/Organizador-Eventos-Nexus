package org.nexus.proyecto_fn_nexus.dominio.exception;

public class UsuarioYaExisteException extends RuntimeException {
    public UsuarioYaExisteException(String nombre) {
        super("El usario con el nombre: \"" + nombre + "\" ya existe.");
    }

}
