package org.nexus.proyecto_fn_nexus.web.exception;

import org.nexus.proyecto_fn_nexus.dominio.exception.Error;
import org.nexus.proyecto_fn_nexus.dominio.exception.UsuarioNoExisteException;
import org.nexus.proyecto_fn_nexus.dominio.exception.UsuarioYaExisteException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class RestExceptionHandlerUsuario {

    @ExceptionHandler(UsuarioYaExisteException.class)
    public ResponseEntity<Error> handleException(UsuarioYaExisteException ex) {
        Error error = new Error("usuario ya existe", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(UsuarioNoExisteException.class)
    public ResponseEntity<Error> handleException(UsuarioNoExisteException ex) {
        Error error = new Error("usuario no existe", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<Error>> handleException(MethodArgumentNotValidException ex) {
        List<Error> errores = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(fieldError -> {
            errores.add(new Error(fieldError.getField(), fieldError.getDefaultMessage()));
        });
        return ResponseEntity.badRequest().body(errores);
    }

    // Manejador de errores predeterminados y desconocidos
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handlerException(Exception ex) {
        Error error = new Error("Error desconocido", ex.getMessage());
        return ResponseEntity.internalServerError().body(error);
    }


}
