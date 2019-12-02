package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.cliente.Turno;

public interface TurnoDao {

	void guardarTurno(Turno turno);

	Turno consultarTurnoPorId(Long id);

	List<Turno> listarTurnosPosiblesDao();

}
