package org.nexus.proyecto_fn_nexus.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.nexus.proyecto_fn_nexus.dominio.dto.ModificarRecursoDto;
import org.nexus.proyecto_fn_nexus.dominio.dto.RecursoDto;
import org.nexus.proyecto_fn_nexus.dominio.service.RecursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/recursos")
@Tag(name = "Recursos", description = "Operaciones CRUD de los recursos de Organizador de Eventos Nexus")
public class RecursoController {
    private final RecursoService recursoService;

    public RecursoController(RecursoService recursoService) {
        this.recursoService = recursoService;
    }

    @GetMapping
    public ResponseEntity<List<RecursoDto>> obtenerRecursos() {
        return ResponseEntity.ok(this.recursoService.obtenerTodo());
    }

    @GetMapping("{idRecurso}")
    @Operation(
            summary ="Obtener un recurso por su identificador",
            description = "Retorna el recurso que coincida con el identificador dado",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Recurso encontrado"),
                    @ApiResponse(responseCode = "400", description = "Recurso no encontrado", content = @Content)
            }
    )
    public ResponseEntity<RecursoDto> buscarPorId
            (@Parameter(description = "Identificador del recurso", example = "8")
             @PathVariable Long idRecurso) {
        return ResponseEntity.ok(this.recursoService.buscarPorId(idRecurso));
    }

    @PostMapping
    public ResponseEntity<RecursoDto> guardarRecurso(@RequestBody @Valid RecursoDto  recursoDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.recursoService.guardarRecurso(recursoDto));
    }

    @PutMapping("{idRecurso}")
    public ResponseEntity<RecursoDto> modificarRecurso(@PathVariable Long idRecurso, @RequestBody ModificarRecursoDto modificarRecurso) {
        return ResponseEntity.ok(this.recursoService.modificarRecurso(idRecurso, modificarRecurso));
    }

    @DeleteMapping("{idRecurso}")
    public ResponseEntity<Void> eliminarRecurso(@PathVariable Long idRecurso) {
        this.recursoService.eliminarRecurso(idRecurso);
        return ResponseEntity.ok().build();
    }




}
