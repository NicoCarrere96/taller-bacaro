package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.taller.Localidad;
import ar.edu.unlam.tallerweb1.modelo.taller.Provincia;

public interface LocalidadDao {
	List<Localidad> consultarLocalidades();
	List<Localidad> buscarLocalidadesPorProvincia(Provincia provincia);
}
