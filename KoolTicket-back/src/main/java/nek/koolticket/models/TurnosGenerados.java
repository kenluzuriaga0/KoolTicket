package nek.koolticket.models;

import java.io.Serializable;
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
import lombok.NoArgsConstructor;

/**
 *
 * @author nek
 */
@Data
@Entity
@Table(name = "turnos_generados")
@NoArgsConstructor
public class TurnosGenerados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "fecha_generado")
    @Basic(optional = false)
    private LocalDateTime fechaGenerado;
    @Column(name = "numero")
    private Integer numero;
    @Column(name = "caja_num")
    private String caja_num; // Prefijo de la caja: Texto
    @Column(name = "fecha_atendido")
    private LocalDateTime fechaAtendido;
    @Column(name = "tiempo_atencion")
    private LocalTime tiempoAtencion;
    @Column(name = "sucursal_nombre")
    private String sucursalNombre; // relacionado a la sucursal
    @Column(name = "usuario_crea")
    private String usuarioCrea;
    @OneToMany(mappedBy = "idTurno")
    private List<TurnoLlamada> turnoLlamadaList;
    @Basic(optional = false)
    @JoinColumn(name = "id_boton", referencedColumnName = "id")
    @ManyToOne
    private Boton idBoton;
    @Basic(optional = false)
    @JoinColumn(name = "id_sucursal", referencedColumnName = "id")
    @ManyToOne
    private Sucursal idSucursal;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @ManyToOne
    private Usuario idUsuario;
    @Column(name = "estado")
    private String estado;

}
