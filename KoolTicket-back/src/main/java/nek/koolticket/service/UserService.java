package nek.koolticket.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import nek.koolticket.dtos.UsuarioDto;
import nek.koolticket.dtos.mappers.ModelsMapper;
import nek.koolticket.repos.UsuariosRepo;

@Service
@AllArgsConstructor
public class UserService {
    private UsuariosRepo userRepo;
    private ModelsMapper mapper;

    public List<UsuarioDto> getAllUsers(){
        var users = this.userRepo.findAllByEstado(true);
        return mapper.userMapEntityToDtoList(users);
    }

    public UsuarioDto getOneById(Integer id){
        var user = this.userRepo.findById(id);
        return mapper.mapEntityToDto(user.orElse(null));
    }


}
