package ar.edu.unlam.tallerweb1.dao;


import java.util.List;


import ar.edu.unlam.tallerweb1.modelo.cliente.Turno;

public interface TurnoDao {	

	List<Turno> ListarTurnosPosiblesDao();
	Turno consultarTurnoPorId(Long id);
	List<Turno> consultarFechaHoraDao(int horario);
	List<Turno> consultarTurnoDao();
}

