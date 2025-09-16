package org.nexus.proyecto_fn_nexus.dominio.exception;

// Excepción para cuando un evento ya existe
public class EventoYaExisteException extends RuntimeException {
    public EventoYaExisteException(String nombreEvento) {
        super("El evento con el nombre: \"" + nombreEvento + "\" ya existe.");
    }
}
