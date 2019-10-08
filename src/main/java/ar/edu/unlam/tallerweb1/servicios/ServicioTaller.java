package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.taller.Repuesto;
import ar.edu.unlam.tallerweb1.modelo.taller.Taller;

public interface ServicioTaller {
	
	
	public Taller consultarTaller (Taller taller);
	public void crearTaller(Taller taller);
	public void update(Taller taller);
	
	public void buscarTallerPorId(Taller taller);
	
}
