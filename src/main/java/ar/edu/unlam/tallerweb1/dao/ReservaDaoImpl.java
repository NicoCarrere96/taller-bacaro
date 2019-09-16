package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.cliente.Reserva;

@Repository("reservaDao")
public class ReservaDaoImpl implements ReservaDao {

	@Inject
	private SessionFactory sessionFactory;
	
	@Override
	public List<Reserva> consultarReservas() {
		Session session = sessionFactory.getCurrentSession();
		return (List<Reserva>) session.createCriteria(Reserva.class).list();
	}

	@Override
	public Reserva buscarReservaPorId(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return (Reserva) session.createCriteria(Reserva.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();
	}

}
