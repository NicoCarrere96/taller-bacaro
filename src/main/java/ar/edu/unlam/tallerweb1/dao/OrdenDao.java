package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Orden;
import ar.edu.unlam.tallerweb1.modelo.cliente.Reserva;

public interface OrdenDao {
	void guardarOrden(Orden orden);
	List<Orden> consultarOrdenes();
	Orden consultarOrdenPorId(Long id);
	Orden consultarOrdenPorReserva(Reserva reserva);
	
	
	
}
