package nek.koolticket.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import nek.koolticket.models.Boton;

/**
 *
 * @author kenlu
 */
@Repository
public interface BotonRepo extends CrudRepository<Boton, Integer> {

	Optional<Boton> findById(Integer id);
	List<Boton> findAllByOrderByOrden();

}
