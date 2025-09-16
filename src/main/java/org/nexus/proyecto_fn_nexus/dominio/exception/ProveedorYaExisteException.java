package org.nexus.proyecto_fn_nexus.dominio.exception;

public class ProveedorYaExisteException extends RuntimeException {
    public ProveedorYaExisteException(String nombreProveedor) {
        super("El proveedor con el nombreProveedor: \"" + nombreProveedor + "\" ya existe.");
    }
}