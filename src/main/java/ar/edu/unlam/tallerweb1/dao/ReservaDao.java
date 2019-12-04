package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.cliente.Cliente;
import ar.edu.unlam.tallerweb1.modelo.cliente.Reserva;
import ar.edu.unlam.tallerweb1.modelo.taller.Taller;

public interface ReservaDao {
	List<Reserva> consultarReservas();
	List<Reserva> consultarReservasPorCliente(Cliente cliente);
	List<Reserva> consultarReservasPorTaller(Taller taller);
		
	Reserva buscarReservaPorId(Long id);

	void guardarReserva(Reserva reserva);

	void eliminarReserva(Reserva reserva);
}
