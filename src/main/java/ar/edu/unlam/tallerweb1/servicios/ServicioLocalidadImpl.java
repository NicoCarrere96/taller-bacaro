package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.dao.LocalidadDao;
import ar.edu.unlam.tallerweb1.modelo.taller.Localidad;
import ar.edu.unlam.tallerweb1.modelo.taller.Provincia;

@Service("servicioLocalidad")
public class ServicioLocalidadImpl implements ServicioLocalidad {

	@Inject
	LocalidadDao dao;
	
	@Override
	public List<Localidad> consultarLocalidades() {
		return dao.consultarLocalidades();
	}

	@Override
	public List<Localidad> buscarLocalidadesPorProvincia(Provincia provincia) {
		return dao.buscarLocalidadesPorProvincia(provincia);
	}

}
