package org.nexus.proyecto_fn_nexus.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.nexus.proyecto_fn_nexus.dominio.dto.EventoDto;
import org.nexus.proyecto_fn_nexus.dominio.dto.ModEventoDto;
import org.nexus.proyecto_fn_nexus.dominio.service.EventoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/eventos")
@Tag(name = "Eventos", description = "Operaciones CRUD sobre los eventos de Nexus")
public class EventoController {

    private final EventoService eventoService;

    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @GetMapping
    @Operation(
            summary = "Obtener todos los eventos",
            description = "Retorna la lista completa de eventos registrados"
    )
    public ResponseEntity<List<EventoDto>> obtenerEventos() {
        return ResponseEntity.ok(this.eventoService.obtenerTodo());
    }

    @GetMapping("{id}")
    @Operation(
            summary = "Obtener un evento por su identificador",
            description = "Retorna el evento que coincida con el identificador dado",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Evento encontrado"),
                    @ApiResponse(responseCode = "404", description = "Evento no encontrado", content = @Content)
            }
    )
    public ResponseEntity<EventoDto> buscarPorId(
            @Parameter(description = "Identificador del evento", example = "1")
            @PathVariable Long id) {
        return ResponseEntity.ok(this.eventoService.buscarPorId(id));
    }

    @PostMapping
    @Operation(
            summary = "Registrar un nuevo evento",
            description = "Crea un nuevo evento en el sistema",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Evento creado exitosamente"),
                    @ApiResponse(responseCode = "400", description = "Datos inválidos", content = @Content)
            }
    )
    public ResponseEntity<EventoDto> guardarEvento(@RequestBody @Valid EventoDto eventoDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.eventoService.guardarEvento(eventoDto));
    }

    @PutMapping("{id}")
    @Operation(
            summary = "Modificar un evento existente",
            description = "Permite actualizar los datos de un evento existente"
    )
    public ResponseEntity<EventoDto> modificarEvento(
            @PathVariable Long id,
            @RequestBody @Valid ModEventoDto modEventoDto) {
        return ResponseEntity.ok(this.eventoService.modificarEvento(id, modEventoDto));
    }

    @DeleteMapping("{id}")
    @Operation(
            summary = "Eliminar un evento",
            description = "Elimina un evento por su identificador"
    )
    public ResponseEntity<Void> eliminarEvento(@PathVariable Long id) {
        this.eventoService.eliminarEvento(id);
        return ResponseEntity.ok().build();
    }
}
