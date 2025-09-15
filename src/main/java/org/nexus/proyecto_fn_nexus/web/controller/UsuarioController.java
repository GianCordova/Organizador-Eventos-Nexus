package org.nexus.proyecto_fn_nexus.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;


import org.nexus.proyecto_fn_nexus.dominio.dto.UsuarioDto;
import org.nexus.proyecto_fn_nexus.dominio.dto.ModUsuarioDto;
import org.nexus.proyecto_fn_nexus.dominio.service.UsuarioService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/v1/usuarios")
@Tag(name = "Usuarios", description = "Operaciones CRUD sobre los usuarios de Nexus")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {this.usuarioService = usuarioService;}

    @GetMapping
    @Operation(
            summary = "Obtener todos los usuarios",
            description = "Retorna la lista completa de usuarios registrados"
    )
    public ResponseEntity<List<UsuarioDto>> obtenerUsuarios() {
        return ResponseEntity.ok(this.usuarioService.obtenerTodo());
    }

    @GetMapping("{id}")
    @Operation(
            summary = "Obtener un usuario por su identificador",
            description = "Retorna el usuario que coincida con el identificador dado",
            responses = {
                    @ApiResponse(responseCode = "200", description = "usuario encontrado"),
                    @ApiResponse(responseCode = "404", description = "usuario no encontrado", content = @Content)
            }
    )
    public ResponseEntity<UsuarioDto> buscarPorId(
            @Parameter(description = "Identificador del usuarios", example = "1")
            @PathVariable Long id) {
        return ResponseEntity.ok(this.usuarioService.buscarPorId(id));
    }

    @PostMapping
    @Operation(
            summary = "Registrar un nuevo usuario",
            description = "Crea un nuevo usuario en el sistema",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Usuario creado exitosamente"),
                    @ApiResponse(responseCode = "400", description = "Datos inválidos", content = @Content)
            }
    )
    public ResponseEntity<UsuarioDto> guardarUsuario(@RequestBody @Valid UsuarioDto usuarioDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.usuarioService.guardarUsuario(usuarioDto));
    }

    @PutMapping("{id}")
    @Operation(
            summary = "Modificar un usuario existente",
            description = "Permite actualizar los datos de un usuario existente"
    )
    public ResponseEntity<UsuarioDto> modificarUsuario(
            @PathVariable Long id,
            @RequestBody @Valid ModUsuarioDto modUsuarioDto) {
        return ResponseEntity.ok(this.usuarioService.modificarUsuario(id, modUsuarioDto));
    }

    @DeleteMapping("{id}")
    @Operation(
            summary = "Eliminar un usuario",
            description = "Elimina un usuario por su identificador"
    )
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        this.usuarioService.eliminarUsuario(id);
        return ResponseEntity.ok().build();
    }
}




