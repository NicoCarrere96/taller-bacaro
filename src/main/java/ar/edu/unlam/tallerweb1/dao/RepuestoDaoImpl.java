package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Orden;
import ar.edu.unlam.tallerweb1.modelo.taller.OrdenRepuesto;
import ar.edu.unlam.tallerweb1.modelo.taller.Repuesto;
import ar.edu.unlam.tallerweb1.modelo.taller.Taller;

@Repository("repuestoDao")
@SuppressWarnings("unchecked")
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
	
	@Override
	public List<Repuesto> consultarRepuestosPorTaller(Taller taller) {
		Session session = sessionFactory.getCurrentSession();
		return (List<Repuesto>) session.createCriteria(Repuesto.class)
				.add(Restrictions.eq("taller", taller))
				.list();
	}
	
	@Override
	public void save(Repuesto repuesto) {
		final Session session = sessionFactory.getCurrentSession();
		session.save(repuesto);
	}
	
	@Override
	public void actualizarRepuesto(Repuesto repuesto) {
		final Session session = sessionFactory.getCurrentSession();
		session.update(repuesto);
	}
	
	@Override
	public List<Repuesto> getAll() {
		final Session session = sessionFactory.getCurrentSession();
		List<Repuesto> repuestos = session.createCriteria(Repuesto.class).list();
		return repuestos;
	}
	
	@Override
	public void eliminarRepuesto(Repuesto repuesto) {
		final Session session = sessionFactory.getCurrentSession();
		session.delete(repuesto);
	}

	@Override
	public List<OrdenRepuesto> consultarRepuestosPorOrden(Orden orden) {
		Session session = sessionFactory.getCurrentSession();
		return (List<OrdenRepuesto>) session.createCriteria(OrdenRepuesto.class)
				.add(Restrictions.eq("orden", orden))
				.list();
	}

	@Override
	public void agregarRepuestoALaOrden(OrdenRepuesto ordRep) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate("ordenRepuesto", ordRep);
	}

}
