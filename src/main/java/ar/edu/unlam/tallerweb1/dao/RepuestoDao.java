package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.taller.Repuesto;

public interface RepuestoDao {
	List<Repuesto> consultarRepuestosEnStock();
	Repuesto consultarRepuestoPorId(Long id);
}
