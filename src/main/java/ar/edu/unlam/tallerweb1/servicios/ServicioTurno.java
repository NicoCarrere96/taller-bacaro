package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.cliente.Turno;

public interface ServicioTurno {

	List<Turno> listarTurnosPosibles();

	Turno consultarTurnoPorId(Long id);

	void restarCantidad(Long id);

	void guardarTurno(Turno turno);

}
