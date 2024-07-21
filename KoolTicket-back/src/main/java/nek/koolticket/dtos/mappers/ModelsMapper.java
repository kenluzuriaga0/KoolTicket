package nek.koolticket.dtos.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import nek.koolticket.dtos.SucursalDto;
import nek.koolticket.dtos.UsuarioDto;
import nek.koolticket.models.Sucursal;
import nek.koolticket.models.Usuario;

@Mapper(componentModel = "spring")
public interface  ModelsMapper {
    
    UsuarioDto mapEntityToDto(Usuario user);
    // Usuario mapDtoToDtoEntity(UsuarioDto user);
    List<SucursalDto> mapEntityToDtoList(List<Sucursal> user);
    // Sucursal mapEntityToDto(SucursalDto user);

}
