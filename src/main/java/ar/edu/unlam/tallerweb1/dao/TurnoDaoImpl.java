package ar.edu.unlam.tallerweb1.dao;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.cliente.DiaDeAtencion;
import ar.edu.unlam.tallerweb1.modelo.cliente.Turno;

@Repository("turnoDao")
public class TurnoDaoImpl implements TurnoDao {

	@Inject 
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Turno> listaDeTurnosDao(Long diaAtencionId){
		final Session session = sessionFactory.getCurrentSession();
		
		return session.createCriteria(Turno.class,"classGral")
				.createAlias("classGral.diaAtencion", "diaBuscado")
				.add(Restrictions.eq("diaBuscado.id", diaAtencionId))
				.list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<DiaDeAtencion> consultarDiaDeAtencionDao(){
		final Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(DiaDeAtencion.class)
				.add(Restrictions.isNotNull("id"))
				.list();
	}

	
	
	@Override
	public DiaDeAtencion obtenerDiaDeAtencion(Long diaDeAtencionId){
	
		final Session session = sessionFactory.getCurrentSession();
	
		return (DiaDeAtencion) session.createCriteria(DiaDeAtencion.class)
				.add(Restrictions.eq("id", diaDeAtencionId))
				.uniqueResult();
	}
	

	
	@SuppressWarnings({ "unchecked" })
	@Override
	public List<Date> obtenerHorariosOcupadosDao(Date fecha){
		final Session session = sessionFactory.getCurrentSession();
		
		System.out.println("Fecha que llega al dao: "+fecha);
		
		Criteria criteria = session.createCriteria(Turno.class)
				 .add(Restrictions.isNotNull("id"))
				;
		List<Date> listC = criteria.list();
				
				 
		return listC ;
		
		
	}
	
	
	@Override
	public List<Turno> obtenerTurnosPosiblesDao(Date fecha, Long diaDeAtencionId){

		return null;
	}
	
	
	@Override
	public void saveTurnoDao(Turno turno) {
		final Session session = sessionFactory.getCurrentSession();
		
		session.save(turno);
	}

}
