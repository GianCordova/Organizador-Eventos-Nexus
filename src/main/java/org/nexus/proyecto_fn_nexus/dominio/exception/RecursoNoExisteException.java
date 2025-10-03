package org.nexus.proyecto_fn_nexus.dominio.exception;

public class RecursoNoExisteException extends RuntimeException {
    public RecursoNoExisteException(Long idRecurso) {
        super("El recurso con codigo: " + idRecurso + " no existe");
    }
}
