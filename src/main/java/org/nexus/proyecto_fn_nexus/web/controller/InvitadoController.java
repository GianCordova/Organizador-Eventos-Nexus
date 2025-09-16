package org.nexus.proyecto_fn_nexus.web.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.nexus.proyecto_fn_nexus.dominio.dto.ModInvitadoDto;
import org.nexus.proyecto_fn_nexus.dominio.dto.InvitadoDto;
import org.nexus.proyecto_fn_nexus.dominio.service.InvitadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/invitados")
@Tag(name = "Invitados", description = "Operaciones CRUD de los invitados de Organizador de Eventos Nexus")
public class InvitadoController {
    private final InvitadoService invitadoService;
    public InvitadoController(InvitadoService invitadoService) {
        this.invitadoService = invitadoService;
    }

    @GetMapping
    public ResponseEntity<List<InvitadoDto>> obtenerInvitados() {
        return ResponseEntity.ok(this.invitadoService.obtenerTodo());
    }

    @GetMapping("{idInvitado}")
    @Operation(
            summary = "Obtener un invitado por su identificador",
            description = "Retorna el invitado que coincida con el identificador dado",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Invitado encontrado"),
                    @ApiResponse(responseCode = "400", description = "Invitado no encontrado", content = @Content)
            }
    )
    public ResponseEntity<InvitadoDto> buscarPorId
            (@Parameter(description = "Identificador del invitado", example = "8")
             @PathVariable Integer idInvitado) {
        return ResponseEntity.ok(this.invitadoService.buscarPorId(idInvitado));
    }

    @PostMapping
    public ResponseEntity<InvitadoDto> guardarInvitado(@RequestBody @Valid InvitadoDto invitadoDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.invitadoService.guardarInvitado(invitadoDto));
    }

    @PutMapping("{idInvitado}")
    public ResponseEntity<InvitadoDto> modificarInvitado(@PathVariable Integer idInvitado, @RequestBody ModInvitadoDto modificarInvitado) {
        return ResponseEntity.ok(this.invitadoService.modificarInvitado(idInvitado, modificarInvitado));
    }

    @DeleteMapping("{idInvitado}")
    public ResponseEntity<Void> eliminarInvitado(@PathVariable Integer idInvitado) {
        this.invitadoService.eliminarInvitado(idInvitado);
        return ResponseEntity.ok().build();
    }
}