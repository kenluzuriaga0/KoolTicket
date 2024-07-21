package nek.koolticket.service;

import java.util.List;

import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import nek.koolticket.dtos.BotonDto;
import nek.koolticket.dtos.mappers.ModelsMapper;
import nek.koolticket.repos.BotonRepo;

@Service
@AllArgsConstructor
public class BotonService {

    private BotonRepo botonRepo;
    private ModelsMapper mapper;

    public List<BotonDto> getAllButtons(){
        var buttons = this.botonRepo.findAllByOrderByOrden();
        return mapper.buttonMapEntityToDtoList(buttons);
    }

    public BotonDto getOneById(Integer id){
        var button = this.botonRepo.findById(id);
        return mapper.buttonMapEntityToDto(button.orElse(null));
    }


}
