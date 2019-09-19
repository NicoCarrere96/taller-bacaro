package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.taller.Repuesto;

public interface ServicioRepuesto {
	List<Repuesto> consultarRepuestosEnStock();
	Repuesto consultarRepuestoPorId(Long id);
}
