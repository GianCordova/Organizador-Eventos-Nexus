package org.nexus.proyecto_fn_nexus.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.nexus.proyecto_fn_nexus.dominio.dto.DetalleProveedorDto;
import org.nexus.proyecto_fn_nexus.dominio.dto.ModDetalleProveedorDto;
import org.nexus.proyecto_fn_nexus.dominio.service.DetalleProveedoresService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/detalle-proveedores")
@Tag(name = "Detalle Proveedores", description = "Operaciones CRUD de los proveedores asignados a eventos")
public class DetalleProveedorController {

    private final DetalleProveedoresService detalleProveedorService;

    public DetalleProveedorController(DetalleProveedoresService detalleProveedorService) {
        this.detalleProveedorService = detalleProveedorService;
    }

    @GetMapping
    public ResponseEntity<List<DetalleProveedorDto>> obtenerTodo() {
        return ResponseEntity.ok(detalleProveedorService.obtenerTodo());
    }

    @GetMapping("{idDetalleProveedor}")
    @Operation(
            summary = "Obtener detalle proveedor por ID",
            description = "Retorna el detalle de proveedor con el ID proporcionado",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Detalle proveedor encontrado"),
                    @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content)
            }
    )
    public ResponseEntity<DetalleProveedorDto> buscarPorId(
            @Parameter(description = "ID del detalle proveedor", example = "10")
            @PathVariable Long idDetalleProveedor) {
        return ResponseEntity.ok(detalleProveedorService.buscarPorId(idDetalleProveedor));
    }

    @PostMapping
    public ResponseEntity<DetalleProveedorDto> guardarDetalleProveedor(@RequestBody @Valid DetalleProveedorDto detalleProveedorDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(detalleProveedorService.guardarDetalleProveedor(detalleProveedorDto));
    }

    @PutMapping("{idDetalleProveedor}")
    public ResponseEntity<DetalleProveedorDto> modificarDetalleProveedor(@PathVariable Long idDetalleProveedor,
                                                                         @RequestBody @Valid ModDetalleProveedorDto dto) {
        return ResponseEntity.ok(detalleProveedorService.modificarDetalleProveedor(idDetalleProveedor, dto));
    }

    @DeleteMapping("{idDetalleProveedor}")
    public ResponseEntity<Void> eliminarDetalleProveedor(@PathVariable Long idDetalleProveedor) {
        detalleProveedorService.eliminarDetalleProveedor(idDetalleProveedor);
        return ResponseEntity.ok().build();
    }
}