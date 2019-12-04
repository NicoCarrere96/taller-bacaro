package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.dao.ReservaDao;
import ar.edu.unlam.tallerweb1.dao.TurnoDao;
import ar.edu.unlam.tallerweb1.modelo.cliente.Cliente;
import ar.edu.unlam.tallerweb1.modelo.cliente.Reserva;
import ar.edu.unlam.tallerweb1.modelo.cliente.Turno;
import ar.edu.unlam.tallerweb1.modelo.taller.Taller;

@Service("servicioReserva")
public class ServicioReservaImpl implements ServicioReserva {

	@Inject
	private ReservaDao reservaDao;
	@Inject
	private TurnoDao turnoDao;
	
	@Override
	public List<Reserva> consultarReservas() {
		return reservaDao.consultarReservas();
	}

	@Override
	public Reserva buscarReservaPorId(Long id) {
		return reservaDao.buscarReservaPorId(id);
	}

	@Override
	public void guardarReserva(Reserva reserva) {
		reservaDao.guardarReserva(reserva);
	}

	@Override
	public List<Reserva> consultarReservasPorCliente(Cliente cliente) {
		return reservaDao.consultarReservasPorCliente(cliente);
	}

	@Override
	public List<Reserva> consultarReservasPorTaller(Taller taller) {
		return reservaDao.consultarReservasPorTaller(taller);
	}
	


	@Override
	public  List<Reserva> consultarTurno(Long turnoId) {
		return reservaDao.consultarTurnoDao(turnoId);
	}

}

