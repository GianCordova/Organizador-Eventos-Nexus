package org.nexus.proyecto_fn_nexus.dominio.exception;

public class RecursoNoExisteException extends RuntimeException {
    public RecursoNoExisteException(Integer idRecurso) {
        super("El recurso con codigo: " + idRecurso + " no existe");
    }
}
