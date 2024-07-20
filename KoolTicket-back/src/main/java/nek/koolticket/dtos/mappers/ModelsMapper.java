package nek.koolticket.dtos.mappers;

import org.mapstruct.Mapper;
import nek.koolticket.dtos.UsuarioDto;
import nek.koolticket.models.Usuario;

@Mapper(componentModel = "spring")
public interface  ModelsMapper {
    
    UsuarioDto mapEntityToDto(Usuario user);
    Usuario mapDtoToDtoEntity(UsuarioDto user);

}
