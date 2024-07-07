package nek.koolticket.repos;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nek.koolticket.models.Sucursales;

@Repository
public interface SucursalesRepo  extends CrudRepository<Sucursales, Integer>{
    
    Optional<Sucursales> findById(Integer id);
	Sucursales findTop1ByNombre(String nombre);
    
}

