package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.taller.Repuesto;

@Repository("repuestoDao")
public class RepuestoDaoImpl implements RepuestoDao {

	@Inject
	private SessionFactory sessionFactory;
	
	@Override
	public List<Repuesto> consultarRepuestos() {
		Session session = sessionFactory.getCurrentSession();
		return (List<Repuesto>) session.createCriteria(Repuesto.class).list();
	}

}
