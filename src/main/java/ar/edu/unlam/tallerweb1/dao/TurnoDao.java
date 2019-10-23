package ar.edu.unlam.tallerweb1.dao;

import java.util.Date;
import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.cliente.DiaDeAtencion;
import ar.edu.unlam.tallerweb1.modelo.cliente.Turno;

public interface TurnoDao {
	
	List<DiaDeAtencion> consultarDiaDeAtencionDao();
	
    List<Turno> listaDeTurnosDao(Long diaDeAtencionId);
	
	DiaDeAtencion obtenerDiaDeAtencion(Long diaDeAtencionId);

	List<Turno> obtenerTurnosPosiblesDao(Date fecha, Long diaDeAtencionId);

	List<Date> obtenerHorariosOcupadosDao(Date fechaTurno);
	
	void saveTurnoDao(Turno turno);

}

