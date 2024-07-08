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
import lombok.NoArgsConstructor;
/**
 *
 * @author nek
 */
@Data
@Entity
@Table(name = "turno_llamada")
@NoArgsConstructor
public class TurnoLlamada implements Serializable {

    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "fecha_llamada")
    @Basic(optional = false)
    private LocalDateTime fechaLlamada;
    @Column(name = "usuario_llamada")
    @Basic(optional = false)
    private String usuarioLlamada;
    @JoinColumn(name = "id_turno", referencedColumnName = "id")
    @ManyToOne
    private TurnosGenerados idTurno;

    public TurnoLlamada(Long id) {
        this.id = id;
    }


}
