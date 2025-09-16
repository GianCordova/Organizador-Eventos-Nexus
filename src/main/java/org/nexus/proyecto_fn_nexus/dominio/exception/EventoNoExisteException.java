package org.nexus.proyecto_fn_nexus.dominio.exception;

// Excepción para cuando un evento no existe
public class EventoNoExisteException extends RuntimeException {
    public EventoNoExisteException(Long idEvento) {
        super("El evento con ID: " + idEvento + " no existe en el sistema");
    }
}
