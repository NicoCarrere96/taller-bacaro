package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.taller.Localidad;
import ar.edu.unlam.tallerweb1.modelo.taller.Taller;
import ar.edu.unlam.tallerweb1.modelo.taller.Usuario;
import ar.edu.unlam.tallerweb1.utils.Especialidad;

public interface ServicioTaller {
	
	public List<Taller> filtrarTalleres(Localidad localidad, Especialidad especialidad);
	public Taller consultarTaller (Taller taller);
	public Taller buscarTallerPorId (Long tallerId);
	public void crearTaller(Taller taller);
	public void update(Taller taller);
	public Taller consultarTallerPorUsuario(Usuario usuario);

}
