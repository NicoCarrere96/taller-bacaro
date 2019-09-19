package ar.edu.unlam.tallerweb1.dao;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.taller.Taller;


@Repository("TallerDao")
public class TallerDaoImpl implements TallerDao{
	
	 private SessionFactory sessionFactory;


		@Override
		public void crearTaller(Taller taller) {
			sessionFactory.getCurrentSession().save(taller);
			
		}

	 
	@Override
	public Taller consultarTaller(Taller taller) {
		return (Taller) sessionFactory.getCurrentSession().createCriteria(Taller.class)
				.add(Restrictions.eq("email", taller.getUsuario().getEmail()))
				.add(Restrictions.eq("password", taller.getUsuario().getPassword()))
				.uniqueResult();
	}

	@Override
	public void update(Taller taller) {
		
		
		sessionFactory.getCurrentSession().update(taller);
		
	}
	

}
