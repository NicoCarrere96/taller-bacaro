package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.cliente.Cliente;
import ar.edu.unlam.tallerweb1.modelo.cliente.Reserva;
import ar.edu.unlam.tallerweb1.modelo.taller.Taller;

public interface ServicioReserva {
	List<Reserva> consultarReservas();

	List<Reserva> consultarReservasPorCliente(Cliente cliente);

	List<Reserva> consultarReservasPorTaller(Taller taller);

	Reserva buscarReservaPorId(Long id);

	void guardarReserva(Reserva reserva);
	List<Reserva> consultarTurno(Long turnoId);
	Boolean buscarFechasDisponibles();

}
