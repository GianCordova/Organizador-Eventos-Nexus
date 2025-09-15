package org.nexus.proyecto_fn_nexus.web.exception;

import org.nexus.proyecto_fn_nexus.dominio.exception.ErrorInvitado;
import org.nexus.proyecto_fn_nexus.dominio.exception.InvitadoNoExisteException;
import org.nexus.proyecto_fn_nexus.dominio.exception.InvitadoYaExisteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class RestExceptionHandlerInvitado {
    @ExceptionHandler(InvitadoYaExisteException.class)
    public ResponseEntity<ErrorInvitado> handleException(InvitadoYaExisteException ex){
        ErrorInvitado errorInvitado = new ErrorInvitado("invitado ya existe", ex.getMessage());
        return ResponseEntity.badRequest().body(errorInvitado);
    }

    @ExceptionHandler (InvitadoNoExisteException.class)
    public ResponseEntity<ErrorInvitado> handleException(InvitadoNoExisteException ex){
        ErrorInvitado errorInvitado = new ErrorInvitado("invitado no existe", ex.getMessage());
        return ResponseEntity.badRequest().body(errorInvitado);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorInvitado>> handleException(MethodArgumentNotValidException ex){
        List<ErrorInvitado> erroresInvitado = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach((fieldError) -> {
            erroresInvitado.add(new ErrorInvitado(fieldError.getField(), fieldError.getDefaultMessage()));
        });
        return ResponseEntity.badRequest().body(erroresInvitado);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorInvitado> handleException(Exception ex){
        ErrorInvitado errorInvitado = new ErrorInvitado("Error desconocido", ex.getMessage());
        return ResponseEntity.internalServerError().body(errorInvitado);
    }

}