package org.nexus.proyecto_fn_nexus.dominio.exception;

// Excepción para cuando un detalle de proveedor no existe
public class DetalleProveedorNoExisteException extends RuntimeException {

  // Constructor que recibe el ID del detalle de proveedor que no existe
  public DetalleProveedorNoExisteException(Long idDetalleProveedor) {
    super("El detalle de proveedor con ID: " + idDetalleProveedor + " no existe en el sistema.");
  }
}
