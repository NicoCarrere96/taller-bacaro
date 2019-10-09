package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.taller.Localidad;
import ar.edu.unlam.tallerweb1.modelo.taller.Provincia;

@Repository("localidadDao")
@SuppressWarnings("unchecked")
public class LocalidadDaoImpl implements LocalidadDao {

	@Inject
	SessionFactory sessionFactory;

	@Override
	public List<Localidad> consultarLocalidades() {
		Session session = sessionFactory.getCurrentSession();
		return (List<Localidad>) session.createCriteria(Localidad.class).list();
	}

	@Override
	public List<Localidad> buscarLocalidadesPorProvincia(Provincia provincia) {
		Session session = sessionFactory.getCurrentSession();
		return (List<Localidad>) session.createCriteria(Localidad.class)
				.add(Restrictions.eq("provincia", provincia))
				.list();
	}

	@Override
	public List<Provincia> consultarProvincias() {
		Session session = sessionFactory.getCurrentSession();
		return (List<Provincia>) session.createCriteria(Provincia.class).list();
	}

	@Override
	public Localidad buscarLocalidadPorId(Long localidad) {
		return sessionFactory.getCurrentSession().get(Localidad.class, localidad);
	}

}
