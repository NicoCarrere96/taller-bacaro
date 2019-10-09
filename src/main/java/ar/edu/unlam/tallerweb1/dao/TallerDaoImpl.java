package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.taller.Localidad;
import ar.edu.unlam.tallerweb1.modelo.taller.Taller;
import ar.edu.unlam.tallerweb1.utils.Especialidad;

@Repository("TallerDao")
public class TallerDaoImpl implements TallerDao {

	@Inject
	private SessionFactory sessionFactory;

	@Override
	public void crearTaller(Taller taller) {
		sessionFactory.getCurrentSession().save(taller);

	}

	@Override
	public Taller consultarTaller(Taller taller) {
		return (Taller) sessionFactory.getCurrentSession().createCriteria(Taller.class)
				.add(Restrictions.eq("email", taller.getUsuario().getEmail()))
				.add(Restrictions.eq("password", taller.getUsuario().getPassword())).uniqueResult();
	}

	@Override
	public void update(Taller taller) {

		sessionFactory.getCurrentSession().update(taller);

	}

	@Override
	public List<Taller> filtrarTalleres(Localidad localidad, Especialidad especialidad) {
		Criteria resultado = sessionFactory.getCurrentSession().createCriteria(Taller.class);

		if(localidad != null) {
			resultado.add(Restrictions.eq("localidad", localidad));
		}
		
		if(especialidad != null) {			
			resultado.add(Restrictions.eq("especialidad", especialidad));
		}

		return (List<Taller>) resultado.list();
	}

	@Override
	public Taller buscarTallerPorId(Long tallerId) {
		return (Taller) sessionFactory.getCurrentSession().get(Taller.class, tallerId);
	}

}
