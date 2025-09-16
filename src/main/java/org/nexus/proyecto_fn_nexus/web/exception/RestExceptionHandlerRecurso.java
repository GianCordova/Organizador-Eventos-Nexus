package org.nexus.proyecto_fn_nexus.web.exception;


import org.nexus.proyecto_fn_nexus.dominio.exception.Error;
import org.nexus.proyecto_fn_nexus.dominio.exception.RecursoNoExisteException;
import org.nexus.proyecto_fn_nexus.dominio.exception.RecursoYaExisteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class RestExceptionHandlerRecurso {
    @ExceptionHandler(RecursoYaExisteException.class)
    public ResponseEntity<Error> handleException(RecursoYaExisteException ex){
        Error errorRecurso = new Error("recurso ya existe", ex.getMessage());
        return ResponseEntity.badRequest().body(errorRecurso);
    }

    @ExceptionHandler (RecursoNoExisteException.class)
    public ResponseEntity<Error> handleException(RecursoNoExisteException ex){
        Error errorRecurso = new Error("recurso no existe", ex.getMessage());
        return ResponseEntity.badRequest().body(errorRecurso);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<Error>> handleException(MethodArgumentNotValidException ex){
        List<Error> erroresRecurso = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach((fieldError) -> {
            erroresRecurso.add(new Error(fieldError.getField(), fieldError.getDefaultMessage()));
        });
        return ResponseEntity.badRequest().body(erroresRecurso);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleException(Exception ex){
        Error errorRecurso = new Error("Error desconocido", ex.getMessage());
        return ResponseEntity.internalServerError().body(errorRecurso);
    }

}
