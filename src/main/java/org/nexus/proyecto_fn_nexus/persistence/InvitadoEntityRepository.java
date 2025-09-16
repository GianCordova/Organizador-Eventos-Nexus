package org.nexus.proyecto_fn_nexus.persistence;

import org.nexus.proyecto_fn_nexus.dominio.dto.ModInvitadoDto;
import org.nexus.proyecto_fn_nexus.dominio.dto.InvitadoDto;
import org.nexus.proyecto_fn_nexus.dominio.exception.InvitadoNoExisteException;
import org.nexus.proyecto_fn_nexus.dominio.exception.InvitadoYaExisteException;
import org.nexus.proyecto_fn_nexus.repository.InvitadoRepository;
import org.nexus.proyecto_fn_nexus.persistence.crud.CrudInvitadoEntity;
import org.nexus.proyecto_fn_nexus.persistence.entity.InvitadoEntity;
import org.nexus.proyecto_fn_nexus.persistence.mapper.InvitadoMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InvitadoEntityRepository implements InvitadoRepository {

    private final CrudInvitadoEntity crudInvitadoEntity;
    private final InvitadoMapper invitadoMapper;

    public InvitadoEntityRepository(CrudInvitadoEntity crudInvitadoEntity, InvitadoMapper invitadoMapper) {
        this.crudInvitadoEntity = crudInvitadoEntity;
        this.invitadoMapper = invitadoMapper;
    }


    @Override
    public List<InvitadoDto> obtenerTodo() {
        return this.invitadoMapper.toDto(this.crudInvitadoEntity.findAll());
    }

    @Override
    public InvitadoDto buscarPorId(Integer idInvitado) {
        return this.invitadoMapper.toDto(this.crudInvitadoEntity.findById(idInvitado).orElse(null));
    }

    @Override
    public InvitadoDto guardarInvitado(InvitadoDto invitadoDto) {
        if (this.crudInvitadoEntity.findFirstByNombre(invitadoDto.nombre()) != null){
            throw new InvitadoYaExisteException(invitadoDto.nombre());
        }
        InvitadoEntity invitado = new InvitadoEntity();
        invitado = this.invitadoMapper.toEntity(invitadoDto);
        invitado.setNombre(invitadoDto.nombre());
        this.crudInvitadoEntity.save(invitado);
        return this.invitadoMapper.toDto(invitado);
    }

    @Override
    public InvitadoDto modificarInvitado(Integer  idInvitado, ModInvitadoDto modInvitado) {
        InvitadoEntity invitado = this.crudInvitadoEntity.findById(idInvitado).orElse(null);

        if (invitado == null) {
            throw new InvitadoNoExisteException(idInvitado);
        }

        invitado.setNombre(modInvitado.nombre());
        invitado.setApellido(modInvitado.apellido());
        invitado.setCorreo(modInvitado.correo());
        invitado.setTelefono(modInvitado.telefono());
        invitado.setEstadoAsistencia(modInvitado.estadoAsistencia());
        invitado.setIdEvento(modInvitado.idEvento());

        this.invitadoMapper.modificarEntityFromDto(modInvitado, invitado);
        return this.invitadoMapper.toDto(this.crudInvitadoEntity.save(invitado));
    }

    @Override
    public void eliminarInvitado(Integer idInvitado) {
        this.crudInvitadoEntity.deleteById(idInvitado);
    }
}