package org.nexus.proyecto_fn_nexus.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.nexus.proyecto_fn_nexus.dominio.dto.DetalleRecursoDto;
import org.nexus.proyecto_fn_nexus.dominio.dto.ModDetalleRecursoDto;
import org.nexus.proyecto_fn_nexus.dominio.service.DetalleRecursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/detalle-recursos")
@Tag(name = "Detalle Recursos", description = "Operaciones CRUD de los recursos asignados a eventos")
public class DetalleRecursoController {

    private final DetalleRecursoService detalleRecursoService;

    public DetalleRecursoController(DetalleRecursoService detalleRecursoService) {
        this.detalleRecursoService = detalleRecursoService;
    }

    @GetMapping
    public ResponseEntity<List<DetalleRecursoDto>> obtenerTodo() {
        return ResponseEntity.ok(detalleRecursoService.obtenerTodo());
    }

    @GetMapping("{idDetalleRecurso}")
    @Operation(
            summary = "Obtener detalle recurso por ID",
            description = "Retorna el detalle de recurso con el ID proporcionado",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Detalle recurso encontrado"),
                    @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content)
            }
    )
    public ResponseEntity<DetalleRecursoDto> buscarPorId(
            @Parameter(description = "ID del detalle recurso", example = "10")
            @PathVariable Integer idDetalleRecurso) {
        return ResponseEntity.ok(detalleRecursoService.buscarPorId(idDetalleRecurso));
    }

    @PostMapping
    public ResponseEntity<DetalleRecursoDto> guardarDetalleRecurso(@RequestBody @Valid DetalleRecursoDto detalleRecursoDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(detalleRecursoService.guardarDetalleRecurso(detalleRecursoDto));
    }

    @PutMapping("{idDetalleRecurso}")
    public ResponseEntity<DetalleRecursoDto> modificarDetalleRecurso(@PathVariable Long idDetalleRecurso,
                                                                     @RequestBody @Valid ModDetalleRecursoDto dto) {
        return ResponseEntity.ok(detalleRecursoService.modificarDetalleRecurso(idDetalleRecurso, dto));
    }

    @DeleteMapping("{idDetalleRecurso}")
    public ResponseEntity<Void> eliminarDetalleRecurso(@PathVariable Long idDetalleRecurso) {
        detalleRecursoService.eliminarDetalleRecurso(idDetalleRecurso);
        return ResponseEntity.ok().build();
    }
}