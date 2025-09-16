package org.nexus.proyecto_fn_nexus.dominio.exception;

public class RecursoYaExisteException extends RuntimeException{
    public RecursoYaExisteException(String nombreRecurso) {
        super("El recurso con el nombre: " + nombreRecurso + " ya existe");
    }
}
