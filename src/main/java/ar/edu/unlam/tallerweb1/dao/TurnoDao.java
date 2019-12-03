package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.cliente.Turno;
import ar.edu.unlam.tallerweb1.modelo.taller.Taller;

public interface TurnoDao {

	void guardarTurno(Turno turno);

	Turno consultarTurnoPorId(Long id);

	List<Turno> listarTurnosPosiblesDao();
	List<Turno> consultarTurnoPorTaller(Taller taller);
	 void save(Turno turno);
	 void actualizarTurno(Turno turno);
	 void eliminarTurno(Turno turno);

}
