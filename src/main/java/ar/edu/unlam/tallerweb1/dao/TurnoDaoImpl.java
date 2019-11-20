package ar.edu.unlam.tallerweb1.dao;


import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.cliente.Turno;

@Repository("turnoDao")
public class TurnoDaoImpl implements TurnoDao {

	@Inject 
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")

	
	
	@Override
	public List<Turno> ListarTurnosPosiblesDao(){
		
			final Session session = sessionFactory.getCurrentSession();
			List<Turno> turnosPosibles = session.createCriteria(Turno.class).list();
			return turnosPosibles;
		} 
		

}
