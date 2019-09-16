package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;


import ar.edu.unlam.tallerweb1.modelo.Orden;

@Repository("ordenDao")
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
	
}
