package ar.edu.unlam.tallerweb1.servicios;


import java.util.List;


import ar.edu.unlam.tallerweb1.modelo.cliente.Turno;

public interface ServicioTurno {
	
	Turno consultarTurnoPorId(Long id);
	List<Turno> ListarTurnosPosibles();
	List<Turno> consultarTurno();
}
