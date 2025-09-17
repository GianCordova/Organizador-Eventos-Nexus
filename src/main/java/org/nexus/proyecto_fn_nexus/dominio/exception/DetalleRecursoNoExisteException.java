package org.nexus.proyecto_fn_nexus.dominio.exception;

// Excepción para cuando un detalle de recurso no existe
public class DetalleRecursoNoExisteException extends RuntimeException {
    public DetalleRecursoNoExisteException(Long idDetalleRecurso) {
        super("El detalle de recurso con ID: " + idDetalleRecurso + " no existe en el sistema.");
    }
}
