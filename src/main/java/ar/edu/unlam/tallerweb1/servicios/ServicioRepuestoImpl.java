package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.dao.RepuestoDao;
import ar.edu.unlam.tallerweb1.modelo.taller.Repuesto;
import ar.edu.unlam.tallerweb1.modelo.taller.Taller;

@Service("servicioRepuesto")
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

}
