package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.RepuestoDao;
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
}
