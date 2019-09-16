package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.dao.OrdenDao;
import ar.edu.unlam.tallerweb1.modelo.Orden;

@Service("servicioOrden")
public class ServicioOrdenImpl implements ServicioOrden {

	@Inject
	OrdenDao ordenDao;
	
	@Override
	public void guardarOrden(Orden orden) {
		ordenDao.guardarOrden(orden);
		
	}

	@Override
	public List<Orden> consultarOrdenes() {
		return ordenDao.consultarOrdenes();
	}

}
