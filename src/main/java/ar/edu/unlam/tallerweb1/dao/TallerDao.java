package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.taller.Localidad;
import ar.edu.unlam.tallerweb1.modelo.taller.Taller;
import ar.edu.unlam.tallerweb1.modelo.taller.Usuario;
import ar.edu.unlam.tallerweb1.utils.Especialidad;

public interface TallerDao {
			
		public Taller consultarTaller (Taller taller);
		public void crearTaller(Taller taller);
		public void update(Taller taller);
		public List<Taller> filtrarTalleres(Localidad localidad, Especialidad especialidad);
		public Taller buscarTallerPorId(Long tallerId);
		public Taller consultarTallerPorUsuario(Usuario usuario);
}


