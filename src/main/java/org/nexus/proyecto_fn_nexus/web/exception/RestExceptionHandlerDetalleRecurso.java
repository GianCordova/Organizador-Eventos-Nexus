package org.nexus.proyecto_fn_nexus.web.exception;

import org.nexus.proyecto_fn_nexus.dominio.exception.DetalleRecursoNoExisteException;
import org.nexus.proyecto_fn_nexus.dominio.exception.DetalleRecursoYaExisteException;
import org.nexus.proyecto_fn_nexus.dominio.exception.Error;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class RestExceptionHandlerDetalleRecurso {

    @ExceptionHandler(DetalleRecursoYaExisteException.class)
    public ResponseEntity<Error> handleDetalleRecursoYaExisteException(DetalleRecursoYaExisteException ex) {
        Error error = new Error("Detalle de recurso ya existe", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(DetalleRecursoNoExisteException.class)
    public ResponseEntity<Error> handleDetalleRecursoNoExisteException(DetalleRecursoNoExisteException ex) {
        Error error = new Error("Detalle de recurso no existe", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<Error>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<Error> errores = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(fieldError -> {
            errores.add(new Error(fieldError.getField(), fieldError.getDefaultMessage()));
        });
        return ResponseEntity.badRequest().body(errores);
    }

    // Manejador de errores predeterminados y desconocidos
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleGenericException(Exception ex) {
        Error error = new Error("Error desconocido", ex.getMessage());
        return ResponseEntity.internalServerError().body(error);
    }
}
