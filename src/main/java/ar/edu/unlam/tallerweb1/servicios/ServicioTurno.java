package ar.edu.unlam.tallerweb1.servicios;

import java.util.Date;
import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.cliente.DiaDeAtencion;
import ar.edu.unlam.tallerweb1.modelo.cliente.Turno;

public interface ServicioTurno {
	
	List<Turno> listaDeTurnos(Long diaDeAtencionId);

	DiaDeAtencion obtenerDiaDeAtencion(Long diaAtencionId);
	
	List<DiaDeAtencion> consultarDiaDeAtencion();

	List<Date> consultarFechaDeElDiaSeleccionadoADosMeses(Long diaDeAtencionId);

	List<Date> obtenerHorariosPosibles(Date fecha, Long diaDeAtencionId);

	List<Date> obtenerHorariosOcupados(Date fecha);

	void guardarTurno(Turno turno);
	

}
