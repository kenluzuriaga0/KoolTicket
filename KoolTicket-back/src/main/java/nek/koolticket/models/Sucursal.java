package nek.koolticket.models;

import java.io.Serializable;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "sucursal")
public class Sucursal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nombre")
    @Basic(optional = false)
    private String nombre;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "orden")
    private Integer orden; // secuencia
    @Column(name = "estado")
    private Boolean estado;
}
