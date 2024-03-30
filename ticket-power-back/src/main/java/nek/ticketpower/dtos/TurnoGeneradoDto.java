package nek.ticketpower.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import lombok.Data;

// Objeto que se retornará como respuesta, será el JSON del servicio REST
@Data
public class TurnoGeneradoDto {
	private Long id;
	private Integer idUsuario;
	private Integer tnoCentro;
	private LocalDateTime tnoFechaCompleta;
    private LocalDate tnoFecha;
    private LocalDateTime tnoFechaAtendido;
    private LocalTime tnoTiempoAtencion;
    private LocalTime tnoTiempoEspera;
    private Integer tnoCaja;
    private Integer idBoton;
    private String botonDesc;
    private Integer tnoNumero;
    private String tnoEstado;
    private String tnoUsuarioCrea;
}
