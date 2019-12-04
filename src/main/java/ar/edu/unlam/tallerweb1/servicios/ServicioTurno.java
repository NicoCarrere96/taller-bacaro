package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.cliente.Turno;
import ar.edu.unlam.tallerweb1.modelo.taller.Taller;

public interface ServicioTurno {

	List<Turno> listarTurnosPosibles();

	void restarCantidad(Long id);

	void guardarTurno(Turno turno);

	List<Turno> consultarTurnosPorTaller(Taller taller);

	void actualizarTurno(Turno turno);

	void eliminarTurno(Turno turno);

	Turno consultarTurnoPorId(Long idTurno);

}
