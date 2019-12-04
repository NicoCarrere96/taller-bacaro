package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.TurnoDao;

import ar.edu.unlam.tallerweb1.modelo.cliente.Turno;
import ar.edu.unlam.tallerweb1.modelo.taller.Taller;

@Service("servicioTurno")
@Transactional
public class ServicioTurnoImpl implements ServicioTurno {

	@Inject
	private TurnoDao turnoDao;


	@Override
	public List<Turno> listarTurnosPosibles() {
		return turnoDao.listarTurnosPosibles();
	}

	@Override
	public void restarCantidad(Long id) {
		Turno turno = this.consultarTurnoPorId(id);

		turno.setCantidad(turno.getCantidad() - 1);

		this.guardarTurno(turno);
	}

	@Override
	public void guardarTurno(Turno turno) {
		turnoDao.guardarTurno(turno);
	}
    
	@Override
	public Turno consultarTurnoPorId(Long id){
		return turnoDao.consultarTurnoPorId(id);
	}
	

	public List<Turno> consultarTurnosPorTaller(Taller taller) {
		return turnoDao.consultarTurnoPorTaller(taller);
	}
	
	
	@Override
	public void actualizarTurno(Turno turno) {
		turnoDao.actualizarTurno(turno);
	}
	

	@Override
	public void eliminarTurno(Turno turno) {
		turnoDao.eliminarTurno(turno);

	}


}
