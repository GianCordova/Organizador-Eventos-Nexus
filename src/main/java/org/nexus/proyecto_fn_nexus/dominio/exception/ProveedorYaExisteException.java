package org.nexus.proyecto_fn_nexus.dominio.exception;

public class ProveedorYaExisteException extends RuntimeException {
    public ProveedorYaExisteException(String nombre) {
        super("El proveedor con el nombre: \"" + nombre + "\" ya existe.");
    }
}