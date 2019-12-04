package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.cliente.Turno;

public interface ServicioTurno {

	List<Turno> listarTurnosPosibles();

	void restarCantidad(Long id);

	void guardarTurno(Turno turno);

	Turno consultarTurnoPorId(Long id);

	List<Turno> consultarTurno();

}
