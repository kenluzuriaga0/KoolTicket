package nek.koolticket.repos;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nek.koolticket.models.Sucursal;

@Repository
public interface SucursalesRepo  extends CrudRepository<Sucursal, Integer>{
    
    Optional<Sucursal> findById(Integer id);
	Sucursal findTop1ByNombre(String nombre);
    
}

