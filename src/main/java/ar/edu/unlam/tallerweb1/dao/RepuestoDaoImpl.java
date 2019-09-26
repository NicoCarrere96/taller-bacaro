package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.taller.Repuesto;
import ar.edu.unlam.tallerweb1.modelo.taller.Taller;

@Repository("repuestoDao")
public class RepuestoDaoImpl implements RepuestoDao {

	@Inject
	private SessionFactory sessionFactory;
	
	@Override
	public List<Repuesto> consultarRepuestosEnStock() {
		Session session = sessionFactory.getCurrentSession();
		return (List<Repuesto>) session.createCriteria(Repuesto.class)
				.add(Restrictions.gt("stock", 0))
				.list();
	}

	@Override
	public Repuesto consultarRepuestoPorId(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return (Repuesto) session.createCriteria(Repuesto.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();
	}

	@Override
	public List<Repuesto> consultarRepuestosEnStockPorTaller(Taller taller) {
		Session session = sessionFactory.getCurrentSession();
		return (List<Repuesto>) session.createCriteria(Repuesto.class)
				.add(Restrictions.gt("stock", 0))
				.add(Restrictions.eq("taller", taller))
				.list();
	}

}
