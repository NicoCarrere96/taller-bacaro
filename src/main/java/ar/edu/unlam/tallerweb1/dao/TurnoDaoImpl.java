package ar.edu.unlam.tallerweb1.dao;


import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.cliente.Turno;

@Repository("turnoDao")
@SuppressWarnings("unchecked")
public class TurnoDaoImpl implements TurnoDao {

	@Inject 
	private SessionFactory sessionFactory;
	
	
	
	@Override
	public List<Turno> ListarTurnosPosiblesDao(){
		
			final Session session = sessionFactory.getCurrentSession();
			List<Turno> turnosPosibles = session.createCriteria(Turno.class).list();
			return turnosPosibles;
		} 
	@Override
	public Turno consultarTurnoPorId(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return (Turno) session.createCriteria(Turno.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();
	}

	@Override
	public List<Turno> consultarFechaHoraDao(int horario){
		final Session session = sessionFactory.getCurrentSession();
		return (List<Turno>) session.createCriteria(Turno.class)
				.add(Restrictions.between("horario", 1,5))
				.list();
	}	
	@SuppressWarnings("unchecked")
	@Override
	public List<Turno> consultarTurnoDao(){
		final Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Turno.class)
				.add(Restrictions.isNotNull("id"))
				.list();
	}
}
