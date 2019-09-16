package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.dao.ReservaDao;
import ar.edu.unlam.tallerweb1.modelo.cliente.Reserva;

@Service("servicioReserva")
public class ServicioReservaImpl implements ServicioReserva {

	@Inject
	private ReservaDao reservaDao;
	
	@Override
	public List<Reserva> consultarReservas() {
		return reservaDao.consultarReservas();
	}

	@Override
	public Reserva buscarReservaPorId(Long id) {
		return reservaDao.buscarReservaPorId(id);
	}

}
