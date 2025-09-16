package org.nexus.proyecto_fn_nexus.dominio.exception;

public class InvitadoNoExisteException extends RuntimeException {
    public InvitadoNoExisteException(Integer idInvitado) {
        super("El invitado con ID: " + idInvitado + " no existe en el sistema");
    }
}