package org.nexus.proyecto_fn_nexus.dominio.exception;

// Excepción para cuando un detalle de proveedor ya existe
public class DetalleProveedorYaExisteException extends RuntimeException {

  // Constructor que recibe el nombre del detalle de proveedor que ya existe
  public DetalleProveedorYaExisteException(String nombreProveedor) {
    super("El detalle de proveedor coon la observación: \"" + nombreProveedor + "\" ya existe.");
  }
}
