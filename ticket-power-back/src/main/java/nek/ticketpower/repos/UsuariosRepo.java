package nek.ticketpower.repos;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import nek.ticketpower.models.Roles;
import nek.ticketpower.models.Usuarios;

/**
 *
 * @author kenlu
 */
@Repository
public interface UsuariosRepo extends CrudRepository<Usuarios, Integer> {
    Optional<Usuarios> findTopByUsernameAndEstado(String username, Boolean estado);

    @Query(value = "UPDATE usuarios set caja_prioridad = 'FIFO' ", nativeQuery = true)
	@Modifying(clearAutomatically = true)
	@Transactional
	public void updateFIFO();

	List<Usuarios> findByIdRol(Roles id);

}
