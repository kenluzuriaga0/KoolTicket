package nek.koolticket.repos;

import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import nek.koolticket.models.Roles;
import nek.koolticket.models.Usuario;

/**
 *
 * @author kenlu
 */
@Repository
public interface UsuariosRepo extends CrudRepository<Usuario, Integer> {
    Optional<Usuario> findTopByUsernameAndEstado(String username, Boolean estado);

    @Query(value = "UPDATE usuario set caja_prioridad = 'FIFO' ", nativeQuery = true)
	@Modifying(clearAutomatically = true)
	@Transactional
	public void updateFIFO();

	List<Usuario> findByIdRol(Roles id);
	Optional<Usuario> findById(Integer id);
	List<Usuario> findAllByEstado(Boolean estado);
	Optional<Usuario> findByUsernameAndEstado(String username, Boolean estado);

}
