package nek.koolticket.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import nek.koolticket.dtos.SucursalDto;
import nek.koolticket.dtos.mappers.ModelsMapper;
import nek.koolticket.models.Sucursal;
import nek.koolticket.repos.SucursalesRepo;

@Service
@AllArgsConstructor
public class SucursalService {

    private ModelsMapper mapper;
    private SucursalesRepo sucursalesRepo;

    public List<SucursalDto> findAllSucursalByEstado(){
        List<Sucursal> branches = sucursalesRepo.findAllSucursalByEstado(true);
         return  mapper.branchMapEntityToDtoList(branches);
    }
}
