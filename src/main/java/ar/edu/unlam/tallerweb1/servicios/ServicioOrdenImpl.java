package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.dao.OrdenDao;
import ar.edu.unlam.tallerweb1.modelo.Orden;
import ar.edu.unlam.tallerweb1.modelo.cliente.Reserva;

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

	@Override
	public Orden consultarOrdenPorId(Long id) {
		return ordenDao.consultarOrdenPorId(id);
	}

	@Override
	public Orden consultarOrdenPorReserva(Reserva reserva) {
		return ordenDao.consultarOrdenPorReserva(reserva);
	}

	@Override
	public void actualizarOrden(Orden orden) {
		// TODO Auto-generated method stub
		
	}
	
}
