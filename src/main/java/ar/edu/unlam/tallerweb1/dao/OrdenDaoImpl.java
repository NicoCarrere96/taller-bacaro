package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Orden;
import ar.edu.unlam.tallerweb1.modelo.cliente.Reserva;

@Repository("ordenDao")
@SuppressWarnings("unchecked")
public class OrdenDaoImpl implements OrdenDao {
	
	@Inject
    private SessionFactory sessionFactory;

	@Override
	public void guardarOrden(Orden orden) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(orden);
	}
	
	

	@Override
	public List<Orden> consultarOrdenes() {
		Session session = sessionFactory.getCurrentSession();
		return (List<Orden>) session.createCriteria(Orden.class).list();
	}

	@Override
	public Orden consultarOrdenPorId(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return (Orden) session.createCriteria(Orden.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();
	}

	@Override
	public Orden consultarOrdenPorReserva(Reserva reserva) {
		Session session = sessionFactory.getCurrentSession();
		return (Orden) session.createCriteria(Orden.class)
				.add(Restrictions.eq("reserva", reserva))
				.uniqueResult();
	}



//	@Override
//	public void actualizarOrden(Orden orden) {
//		Session session = sessionFactory.getCurrentSession();
//		
//		session.update(orden);
//	}

	
}