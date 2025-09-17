package org.nexus.proyecto_fn_nexus.dominio.exception;

// Excepción para cuando un detalle de recurso ya existe
public class DetalleRecursoYaExisteException extends RuntimeException {
    public DetalleRecursoYaExisteException(String detalleRecurso) {
        super("El detalle de recurso: \"" + detalleRecurso + "\" ya existe.");
    }
}
