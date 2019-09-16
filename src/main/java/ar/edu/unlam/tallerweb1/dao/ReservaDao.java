package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.cliente.Reserva;

public interface ReservaDao {
	List<Reserva> consultarReservas();
	Reserva buscarReservaPorId(Long id);
}
