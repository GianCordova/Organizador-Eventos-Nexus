package org.nexus.proyecto_fn_nexus.repository;


import org.nexus.proyecto_fn_nexus.dominio.dto.ModInvitadoDto;
import org.nexus.proyecto_fn_nexus.dominio.dto.InvitadoDto;

import java.util.List;

public interface InvitadoRepository {
    List<InvitadoDto> obtenerTodo();
    InvitadoDto buscarPorId(Long idInvitado);
    InvitadoDto guardarInvitado(InvitadoDto invitadoDto);
    InvitadoDto modificarInvitado(Long idInvitado, ModInvitadoDto modInvitado);
    void eliminarInvitado(Long idInvitado);
}