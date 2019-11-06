package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Orden;
import ar.edu.unlam.tallerweb1.modelo.cliente.Reserva;

public interface ServicioOrden {
	void guardarOrden(Orden orden);

	void actualizarOrden(Orden orden);

	List<Orden> consultarOrdenes();

	Orden consultarOrdenPorId(Long id);

	Orden consultarOrdenPorReserva(Reserva reserva);

	void aprobarOrden(Orden orden);

	void rechazarOrden(Orden orden);

	void modificarOrden(Orden orden);

}
