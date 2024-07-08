package nek.koolticket.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import nek.koolticket.models.Sucursal;
import nek.koolticket.repos.SucursalesRepo;

@Service
@AllArgsConstructor
public class SucursalService {

    SucursalesRepo sucursalesRepo;

    public List<Sucursal> findAllSucursalByEstado(){
        return sucursalesRepo.findAllSucursalByEstado(true);
    }
}
