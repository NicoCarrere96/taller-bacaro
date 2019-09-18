package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Orden;

public interface OrdenDao {
	void guardarOrden(Orden orden);
	List<Orden> consultarOrdenes();
	Orden consultarOrdenPorId(Long id);
	
}
