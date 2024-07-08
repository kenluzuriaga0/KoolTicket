package nek.koolticket.repos;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nek.koolticket.models.TurnoLlamada;
import nek.koolticket.models.TurnosGenerados;

/**
 *
 * @author nek
*/
@Repository
public interface TurnoLlamadaRepo extends CrudRepository<TurnoLlamada, Long> {
    
  @Query(value =  "select * from turno_llamada tl"
          + " inner join turnos_generados tg on tl.id_turno = tg.id "
          + " inner join sucursal suc on tg.idSucursal = suc.id "
          + " where suc.nombre = ?1"
          + " and tg.tno_fecha =?2"
          + " order by tl.fecha_llamada desc"
          + " limit 10",nativeQuery = true)
    List<TurnoLlamada> findListadoByCentroAndFecha(String centro, LocalDate fecha);

  @Query(value =  "select * from turno_llamada tl"
          + " inner join empresas_sucursales suc on tl.id_sucursal = suc.id_sucursal "
          + " where suc.nombre = ?1"
          + " and tl.id_turno is null and tl.estado=true "
          + " and cast(tl.fecha_llamada as date) =?2"
          + " order by tl.fecha_llamada desc"
          + " limit 10",nativeQuery = true)
    List<TurnoLlamada> findListadoByCentroAndFechaSG(String centro, LocalDate fecha);
  
    TurnoLlamada findTop1ByIdTurnoOrderByFechaLlamadaDesc(TurnosGenerados turno);

}
