package nek.koolticket.repos;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import nek.koolticket.models.Botones;
import nek.koolticket.models.Sucursales;
import nek.koolticket.models.TurnosGenerados;

/**
 *
 * @author nek
 */
@Repository
public interface TurnosGeneradosRepo extends CrudRepository<TurnosGenerados, Long> {

	List<TurnosGenerados> findAll();

	@Query("select t from TurnosGenerados t where t.tnoFechaCompleta=(select max(t2.tnoFechaCompleta) from TurnosGenerados t2 where t2.idBoton = :boton and t2.tnoCentro = :centro)")
	TurnosGenerados getUltimoTurno(@Param("boton") Botones boton, @Param("centro") String centro);

	@Query("select t from TurnosGenerados t where t.tnoFechaCompleta=(select max(t2.tnoFechaCompleta) from TurnosGenerados t2 where t2.tnoEstado = 'LLAMADO' and t2.idUsuario.id = :usuarioId )")
	TurnosGenerados getUltimoTurnoByUser(@Param("usuarioId") Integer usuarioId);

	// @Query("select t from TurnosGenerados t where tnoFecha = :hoy and tnoCentro =
	// :centro and tnoEstado = :estado order by tnoFechaCompleta")
	// List<TurnosGenerados> getTurnoFIFO(@Param("hoy") LocalDate hoy ,
	// @Param("centro") String centro, @Param("estado") String estado, Pageable
	// topOne);
	TurnosGenerados findTop1ByTnoFechaAndTnoCentroAndTnoEstadoOrderByTnoFechaCompleta(LocalDate tnoFecha,
			Sucursales sucursal, String TnoEstado);

	@Query(value = "select * from demo.turnos_generados tg "
			+ " inner join demo.empresas_sucursales suc on tg.tno_centro = suc.id_sucursal"
			+ " where  tg.tno_fecha = ?1 and suc.sucursal_nombre ='MEDILINK S.A.' and suc.sucursal_observacion = ?2 and tg.tno_estado = ?3 "
			+ " ORDER BY tg.id_boton = ?4 DESC,\n" + " tg.id_boton = ?5 DESC,\n" + " tg.id_boton = ?6 DESC,\n"
			+ "         tg.id_boton = ?7 desc,\n" + "  tg.id_boton = ?8 desc,\n" + " tg.id_boton = ?9 desc,\n"
			+ "         tg.tno_fecha_completa" + " limit 1 ;", nativeQuery = true)
	TurnosGenerados findTurnosPriorizados(LocalDate fecha, String centro, String estado, Integer btn1, Integer btn2, Integer btn3,
			Integer btn4, Integer btn5, Integer btn6);

	// reportes
	@Query(value = "select  tg.tno_centro , u.caja_prioridad,u.usuario_email , count(tno_numero) from demo.turnos_generados tg inner join demo.seg_usuarios u \n"
			+ "	on tg.id_usuario = u.id_usuario where tg.tno_fecha = ?1 group by u.usuario_email, tg.tno_centro , u.caja_prioridad\n"
			+ "order by tg.tno_centro ,count(tno_numero) desc", nativeQuery = true)
	List<Object[]> findProduccionReporte(LocalDate date);

	@Query(value = "select tg.boton_desc , tg.tno_centro ,count(tg.id_turno) as turno\n"
			+ "from demo.turnos_generados tg  \n" + "where tg.tno_estado = 'GENERADO' and tg.tno_fecha = ?1 "
			+ "group by tg.boton_desc , tg.tno_centro order by tg.tno_centro,turno", nativeQuery = true)
	List<Object[]> findEnEsperaReporte(LocalDate date);

	@Query(value = "select tg.tno_centro ,  u.usuario_email,tg.boton_desc,tg.tno_numero,  tg.tno_fecha_completa,max(llamada_fecha) as time_llamada, tg.tno_tiempo_atencion, tg.tno_tiempo_espera "
			+ " from demo.turno_llamada tl \n"
			+ "inner join demo.turnos_generados tg on tl.id_turno = tg.id_turno \n"
			+ "inner join demo.seg_usuarios u on tg.id_usuario = u.id_usuario\n"
			+ "where tg.tno_estado ='ATENDIDO' and tg.tno_fecha = ?1 "
			+ "group by u.usuario_email, tg.tno_numero , tg.boton_desc,tg.tno_fecha_completa ,tg.tno_tiempo_atencion,tg.tno_centro ,tg.tno_tiempo_espera \n"
			+ "order by tg.tno_centro , u.usuario_email , tg.tno_fecha_completa desc", nativeQuery = true)
	List<Object[]> findAtendidosDetalleReporte(LocalDate date);

}
