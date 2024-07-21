package nek.koolticket.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SucursalDto {
    private Integer id;
    private String nombre;
    private String direccion;
    private Integer orden; // secuencia
}