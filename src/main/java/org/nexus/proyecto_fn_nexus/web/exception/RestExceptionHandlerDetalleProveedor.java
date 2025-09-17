package org.nexus.proyecto_fn_nexus.web.exception;

import org.nexus.proyecto_fn_nexus.dominio.exception.DetalleProveedorNoExisteException;
import org.nexus.proyecto_fn_nexus.dominio.exception.DetalleProveedorYaExisteException;
import org.nexus.proyecto_fn_nexus.dominio.exception.Error;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class RestExceptionHandlerDetalleProveedor {

    // Manejo de la excepción cuando el detalle de proveedor ya existe
    @ExceptionHandler(DetalleProveedorYaExisteException.class)
    public ResponseEntity<Error> handleDetalleProveedorYaExisteException(DetalleProveedorYaExisteException ex) {
        // Retorna un error con un mensaje específico
        Error error = new Error("Detalle de proveedor ya existe", ex.getMessage());
        return ResponseEntity.badRequest().body(error);  // 400 Bad Request
    }

    // Manejo de la excepción cuando el detalle de proveedor no existe
    @ExceptionHandler(DetalleProveedorNoExisteException.class)
    public ResponseEntity<Error> handleDetalleProveedorNoExisteException(DetalleProveedorNoExisteException ex) {
        // Retorna un error indicando que el detalle de proveedor no existe
        Error error = new Error("Detalle de proveedor no existe", ex.getMessage());
        return ResponseEntity.status(404).body(error);  // 404 Not Found
    }

    // Manejo de excepciones de validación (por ejemplo, parámetros inválidos en la solicitud)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<Error>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<Error> errores = new ArrayList<>();
        // Extrae los errores de validación de los campos de la solicitud
        ex.getBindingResult().getFieldErrors().forEach(fieldError -> {
            // Agrega cada error de campo con su mensaje correspondiente
            errores.add(new Error(fieldError.getField(), fieldError.getDefaultMessage()));
        });
        // Retorna la lista de errores con código de estado 400 (Bad Request)
        return ResponseEntity.badRequest().body(errores);
    }

    // Manejador de errores genéricos no capturados (errores inesperados)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleGenericException(Exception ex) {
        // Error genérico para problemas internos del servidor
        Error error = new Error("Error desconocido", ex.getMessage());
        return ResponseEntity.internalServerError().body(error);  // 500 Internal Server Error
    }
}
