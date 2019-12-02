package ar.edu.unlam.tallerweb1.dao;


import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.cliente.Turno;

@Repository("turnoDao")
public class TurnoDaoImpl implements TurnoDao {

	@Inject 
	private SessionFactory sessionFactory;
		
	@Override
	public List<Turno> listarTurnosPosiblesDao(){
		
			final Session session = sessionFactory.getCurrentSession();
			return session.createCriteria(Turno.class)
					.add(Restrictions.gt("cantidad", 0))
					.list();
		}

	@Override
	public void guardarTurno(Turno turno) {
		final Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate("Turno", turno);
		
	}

	@Override
	public Turno consultarTurnoPorId(Long id) {
		final Session session = sessionFactory.getCurrentSession();
		return (Turno) session.createCriteria(Turno.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();
	} 
		

}
