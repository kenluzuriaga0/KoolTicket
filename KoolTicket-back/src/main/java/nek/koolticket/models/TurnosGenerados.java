package nek.koolticket.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

/**
 *
 * @author nek
 */
@Data
@Entity
@Table(name = "turnos_generados")
public class TurnosGenerados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "tno_fecha_completa")
   // @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime tnoFechaCompleta;
    @Column(name = "tno_fecha")
   // @Temporal(TemporalType.DATE)
    private LocalDate tnoFecha;
    @Column(name = "tno_numero")
    private Integer tnoNumero;
    @Column(name = "tno_caja")
    private Integer tnoCaja;
    @Column(name = "tno_fecha_atendido")
    //@Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime tnoFechaAtendido;
    @Column(name = "tno_tiempo_atencion")
    //@Temporal(TemporalType.TIME)
    private LocalTime tnoTiempoAtencion;
    @Column(name = "tno_centro")
    private String tnoCentro;
    @Column(name = "tno_usuario_crea")
    private String tnoUsuarioCrea;
    @Column(name = "tno_usuario_modifica")
    private String tnoUsuarioModifica;
    @Column(name = "tno_estado")
    private String tnoEstado;
    @OneToMany(mappedBy = "idTurno")
    private List<TurnoLlamada> turnoLlamadaList;
    @JoinColumn(name = "id_boton", referencedColumnName = "id")
    @ManyToOne
    private Botones idBoton;
    @JoinColumn(name = "id_sucursal", referencedColumnName = "id")
    @ManyToOne
    private Sucursales idSucursal;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @ManyToOne
    private Usuarios idUsuario;


}
