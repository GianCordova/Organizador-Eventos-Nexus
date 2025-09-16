package org.nexus.proyecto_fn_nexus.dominio.service;
import org.nexus.proyecto_fn_nexus.dominio.dto.InvitadoDto;
import org.nexus.proyecto_fn_nexus.dominio.dto.ModInvitadoDto;
import org.nexus.proyecto_fn_nexus.repository.InvitadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvitadoService {

    private final InvitadoRepository invitadoRepository;

    public InvitadoService(InvitadoRepository invitadoRepository) {
        this.invitadoRepository = invitadoRepository;
    }

    public List<InvitadoDto> obtenerTodo() {
        return this.invitadoRepository.obtenerTodo();
    }

    public InvitadoDto buscarPorId(Integer  idInvitado) {
        return this.invitadoRepository.buscarPorId(idInvitado);
    }

    public InvitadoDto guardarInvitado(InvitadoDto invitadoDto) {
        return this.invitadoRepository.guardarInvitado(invitadoDto);
    }

    public InvitadoDto modificarInvitado(Integer  idInvitado, ModInvitadoDto modInvitado) {
        return this.invitadoRepository.modificarInvitado(idInvitado, modInvitado);
    }

    public void eliminarInvitado(Integer  idInvitado) {
        this.invitadoRepository.eliminarInvitado(idInvitado);
    }
}