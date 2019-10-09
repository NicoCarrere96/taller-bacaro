package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.taller.Repuesto;
import ar.edu.unlam.tallerweb1.modelo.taller.Taller;

public interface RepuestoDao {
	List<Repuesto> consultarRepuestosEnStock();
	List<Repuesto> consultarRepuestosEnStockPorTaller(Taller taller);
	Repuesto consultarRepuestoPorId(Long id);
	
	 void save(Repuesto repuesto);
	 void actualizarRepuesto(Repuesto repuesto);
	 List<Repuesto> getAll();
	 void eliminarRepuesto(Repuesto repuesto);
	
	}
