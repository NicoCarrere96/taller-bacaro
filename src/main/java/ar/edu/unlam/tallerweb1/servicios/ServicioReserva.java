package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.cliente.Reserva;

public interface ServicioReserva {
	List<Reserva> consultarReservas();
	Reserva buscarReservaPorId(Long id);
}
