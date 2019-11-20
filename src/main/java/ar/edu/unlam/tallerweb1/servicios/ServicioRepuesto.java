package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Orden;
import ar.edu.unlam.tallerweb1.modelo.taller.OrdenRepuesto;
import ar.edu.unlam.tallerweb1.modelo.taller.Repuesto;
import ar.edu.unlam.tallerweb1.modelo.taller.Taller;

public interface ServicioRepuesto {
	List<Repuesto> consultarRepuestosEnStock();
	List<Repuesto> consultarRepuestosEnStockPorTaller(Taller taller);
	List<Repuesto> consultarRepuestosPorTaller(Taller taller);
	Repuesto consultarRepuestoPorId(Long id);
	void guardarRepuesto(Repuesto repuesto);
	void actualizarRepuesto(Repuesto repuesto);
	List<Repuesto> getAll();
	void eliminarRepuesto(Repuesto repuesto);
	
	List<OrdenRepuesto> consultarRepuestosPorOrden(Orden orden);
	void agregarRepuestoALaOrden(OrdenRepuesto ordRep);
	void eliminarRepuestoEnLaOrden(OrdenRepuesto ordRep);
}
