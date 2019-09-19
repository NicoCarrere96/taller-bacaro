package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.taller.Taller;

public interface TallerDao {
			
		public Taller consultarTaller (Taller taller);
		public void crearTaller(Taller taller);
		public void update(Taller taller);
}
