package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.RepuestoDao;
import ar.edu.unlam.tallerweb1.modelo.Orden;
import ar.edu.unlam.tallerweb1.modelo.taller.OrdenRepuesto;
import ar.edu.unlam.tallerweb1.modelo.taller.Repuesto;
import ar.edu.unlam.tallerweb1.modelo.taller.Taller;

@Service("servicioRepuesto")
@Transactional
public class ServicioRepuestoImpl implements ServicioRepuesto {

	@Inject
	private RepuestoDao dao;
	
	@Override
	public List<Repuesto> consultarRepuestosEnStock() {
		return dao.consultarRepuestosEnStock();
	}

	@Override
	public Repuesto consultarRepuestoPorId(Long id) {
		return dao.consultarRepuestoPorId(id);
	}

	@Override
	public List<Repuesto> consultarRepuestosEnStockPorTaller(Taller taller) {
		return dao.consultarRepuestosEnStockPorTaller(taller);
	}
	
	@Override
	public List<Repuesto> consultarRepuestosPorTaller(Taller taller) {
		return dao.consultarRepuestosPorTaller(taller);
	}

	@Override
	public void guardarRepuesto(Repuesto repuesto) {
		dao.save(repuesto);
	}
	
	@Override
	public void actualizarRepuesto(Repuesto repuesto) {
		dao.actualizarRepuesto(repuesto);
	}
	
	@Override
	public List<Repuesto> getAll() {
		return dao.getAll();
	}
	
	@Override
	public void eliminarRepuesto(Repuesto repuesto) {
		dao.eliminarRepuesto(repuesto);
	}

	@Override
	public List<OrdenRepuesto> consultarRepuestosPorOrden(Orden orden) {
		return dao.consultarRepuestosPorOrden(orden);
	}

	@Override
	public void agregarRepuestoALaOrden(OrdenRepuesto ordRep) {
		dao.agregarRepuestoALaOrden(ordRep);
	}
	
	@Override
	public void eliminarRepuestoEnLaOrden(OrdenRepuesto ordRep) {
		dao.eliminarRepuestoEnLaOrden(ordRep);
	}
}
