package nek.koolticket.dtos.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import nek.koolticket.dtos.BotonDto;
import nek.koolticket.dtos.SucursalDto;
import nek.koolticket.dtos.UsuarioDto;
import nek.koolticket.models.Boton;
import nek.koolticket.models.Sucursal;
import nek.koolticket.models.Usuario;

@Mapper(componentModel = "spring")
public interface  ModelsMapper {
    
    UsuarioDto mapEntityToDto(Usuario user);
    List<UsuarioDto> userMapEntityToDtoList(List<Usuario> user);
    BotonDto buttonMapEntityToDto(Boton btn);
    List<BotonDto> buttonMapEntityToDtoList(List<Boton> btn);
    // Usuario mapDtoToDtoEntity(UsuarioDto user);
    List<SucursalDto> branchMapEntityToDtoList(List<Sucursal> branches);
    // Sucursal mapEntityToDto(SucursalDto user);

}
