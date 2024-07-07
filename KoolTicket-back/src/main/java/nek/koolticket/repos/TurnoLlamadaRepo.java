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
    
  @Query(value =  "select * from demo.turno_llamada tl"
          + " inner join demo.turnos_generados tg on tl.id_turno = tg.id_turno "
          + " inner join demo.empresas_sucursales suc on tg.tno_centro = suc.id_sucursal "
          + " where suc.sucursal_nombre='MEDILINK S.A.' and suc.sucursal_observacion = ?1"
          + " and tg.tno_fecha =?2"
          + " order by tl.llamada_fecha desc"
          + " limit 10",nativeQuery = true)
    List<TurnoLlamada> findListadoByCentroAndFecha(String centro, LocalDate fecha);

  @Query(value =  "select * from demo.turno_llamada tl"
          + " inner join demo.empresas_sucursales suc on tl.id_sucursal = suc.id_sucursal "
          + " where suc.sucursal_nombre='MEDILINK S.A.' and suc.sucursal_observacion = ?1"
          + " and tl.id_turno is null and tl.sg_estado=true "
          + " and cast(tl.llamada_fecha as date) =?2"
          + " order by tl.llamada_fecha desc"
          + " limit 10",nativeQuery = true)
    List<TurnoLlamada> findListadoByCentroAndFechaSG(String centro, LocalDate fecha);
  
    TurnoLlamada findTop1ByIdTurnoOrderByLlamadaFechaDesc(TurnosGenerados turno);

}
