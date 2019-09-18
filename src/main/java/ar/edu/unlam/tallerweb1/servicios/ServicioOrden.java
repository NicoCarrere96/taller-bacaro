package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Orden;

public interface ServicioOrden {
	void guardarOrden(Orden orden);
	List<Orden> consultarOrdenes();
	Orden consultarOrdenPorId(Long id);
	
}
