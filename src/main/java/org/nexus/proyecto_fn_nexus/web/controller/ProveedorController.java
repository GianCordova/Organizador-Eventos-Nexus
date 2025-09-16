package org.nexus.proyecto_fn_nexus.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.nexus.proyecto_fn_nexus.dominio.dto.ProveedorDto;
import org.nexus.proyecto_fn_nexus.dominio.dto.ModProveedorDto;
import org.nexus.proyecto_fn_nexus.dominio.service.ProveedorService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/proveedores")
@Tag(name = "Proveedores", description = "Operaciones CRUD sobre los proveedores de Nexus")
public class ProveedorController {

    private final ProveedorService proveedorService;

    public ProveedorController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    @GetMapping
    @Operation(
            summary = "Obtener todos los proveedores",
            description = "Retorna la lista completa de proveedores registrados"
    )
    public ResponseEntity<List<ProveedorDto>> obtenerProveedores() {
        return ResponseEntity.ok(this.proveedorService.obtenerTodo());
    }

    @GetMapping("{id}")
    @Operation(
            summary = "Obtener un proveedor por su identificador",
            description = "Retorna el proveedor que coincida con el identificador dado",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Proveedor encontrado"),
                    @ApiResponse(responseCode = "404", description = "Proveedor no encontrado", content = @Content)
            }
    )
    public ResponseEntity<ProveedorDto> buscarPorId(
            @Parameter(description = "Identificador del proveedor", example = "1")
            @PathVariable Long id) {
        return ResponseEntity.ok(this.proveedorService.buscarPorId(id));
    }

    @PostMapping
    @Operation(
            summary = "Registrar un nuevo proveedor",
            description = "Crea un nuevo proveedor en el sistema",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Proveedor creado exitosamente"),
                    @ApiResponse(responseCode = "400", description = "Datos inválidos", content = @Content)
            }
    )
    public ResponseEntity<ProveedorDto> guardarProveedor(@RequestBody @Valid ProveedorDto proveedorDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.proveedorService.guardarProveedor(proveedorDto));
    }

    @PutMapping("{id}")
    @Operation(
            summary = "Modificar un proveedor existente",
            description = "Permite actualizar los datos de un proveedor existente"
    )
    public ResponseEntity<ProveedorDto> modificarProveedor(
            @PathVariable Long id,
            @RequestBody @Valid ModProveedorDto modProveedorDto) {
        return ResponseEntity.ok(this.proveedorService.modificarProveedor(id, modProveedorDto));
    }

    @DeleteMapping("{id}")
    @Operation(
            summary = "Eliminar un proveedor",
            description = "Elimina un proveedor por su identificador"
    )
    public ResponseEntity<Void> eliminarProveedor(@PathVariable Long id) {
        this.proveedorService.eliminarProveedor(id);
        return ResponseEntity.ok().build();
    }
}
