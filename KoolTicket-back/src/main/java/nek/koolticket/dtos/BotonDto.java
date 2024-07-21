package nek.koolticket.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BotonDto {
    private Integer id;
    private String nombre;
    private String prefijoTicket;
    private String color;
    private Integer orden;
    private Boolean estado;
}