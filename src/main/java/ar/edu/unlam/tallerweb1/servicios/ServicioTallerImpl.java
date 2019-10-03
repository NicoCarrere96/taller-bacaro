package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.TallerDao;
import ar.edu.unlam.tallerweb1.modelo.taller.Localidad;
import ar.edu.unlam.tallerweb1.modelo.taller.Taller;
import ar.edu.unlam.tallerweb1.utils.Especialidad;
@Service("servicioTaller")
@Transactional
public class ServicioTallerImpl implements ServicioTaller{
	
	@Inject
	private TallerDao servicioTallerDao;
	public Taller consultarTaller(Taller taller) {
		return servicioTallerDao.consultarTaller(taller);
	}
	
	
	public void crearTaller(Taller taller) {
		servicioTallerDao.crearTaller(taller);
		
	}

	public void update(Taller taller) {
		servicioTallerDao.update(taller);
	}

	public List<Taller> filtrarTalleres(Localidad localidad, Especialidad especialidad) {
		return servicioTallerDao.filtrarTalleres(localidad, especialidad);
	}


	@Override
	public Taller buscarTallerPorId(Long tallerId) {
		return servicioTallerDao.buscarTallerPorId(tallerId);
	}
}
