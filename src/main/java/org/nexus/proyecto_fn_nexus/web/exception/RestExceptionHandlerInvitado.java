package org.nexus.proyecto_fn_nexus.web.exception;
import org.nexus.proyecto_fn_nexus.dominio.exception.Error;
import org.nexus.proyecto_fn_nexus.dominio.exception.InvitadoNoExisteException;
import org.nexus.proyecto_fn_nexus.dominio.exception.InvitadoYaExisteException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class RestExceptionHandlerInvitado {
    @ExceptionHandler(InvitadoYaExisteException.class)
    public ResponseEntity<Error> handleException(InvitadoYaExisteException ex){
        Error errorInvitado = new Error("invitado ya existe", ex.getMessage());
        return ResponseEntity.badRequest().body(errorInvitado);
    }

    @ExceptionHandler (InvitadoNoExisteException.class)
    public ResponseEntity<Error> handleException(InvitadoNoExisteException ex){
        Error errorInvitado = new Error("invitado no existe", ex.getMessage());
        return ResponseEntity.badRequest().body(errorInvitado);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<Error>> handleException(MethodArgumentNotValidException ex){
        List<Error> erroresInvitado = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach((fieldError) -> {
            erroresInvitado.add(new Error(fieldError.getField(), fieldError.getDefaultMessage()));
        });
        return ResponseEntity.badRequest().body(erroresInvitado);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleException(Exception ex){
        Error errorInvitado = new Error("Error desconocido", ex.getMessage());
        return ResponseEntity.internalServerError().body(errorInvitado);
    }

}