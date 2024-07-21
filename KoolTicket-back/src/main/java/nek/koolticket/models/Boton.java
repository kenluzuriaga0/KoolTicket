package nek.koolticket.models;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "boton")
@NoArgsConstructor
public class Boton implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "prefijo_ticket")
    private String prefijoTicket;
    @Column(name = "color")
    private String color;
    @Column(name = "orden")
    private Integer orden;
    @Column(name = "estado")
    private Boolean estado;
    @OneToMany(mappedBy = "idBoton")
    private List<TurnosGenerados> turnosGeneradosList;

  
    
}
