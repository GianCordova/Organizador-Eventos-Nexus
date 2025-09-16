package org.nexus.proyecto_fn_nexus.dominio.exception;

public class ProveedorNoExisteException extends RuntimeException {
    public ProveedorNoExisteException(Long idProveedor) {
        super("El proveedor con ID: " + idProveedor + " no existe en el sistema");
    }
}
