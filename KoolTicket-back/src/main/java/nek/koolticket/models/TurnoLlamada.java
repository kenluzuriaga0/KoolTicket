package nek.koolticket.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
/**
 *
 * @author nek
 */
@Data
@Entity
@Table(name = "turno_llamada")
public class TurnoLlamada implements Serializable {

    @Column(name = "llamada_fecha")
    private LocalDateTime llamadaFecha;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "llamada_usuario")
    private String llamadaUsuario;
    @JoinColumn(name = "id_turno", referencedColumnName = "id")
    @ManyToOne
    private TurnosGenerados idTurno;

    public TurnoLlamada() {
    }

    public TurnoLlamada(Long id) {
        this.id = id;
    }


}
