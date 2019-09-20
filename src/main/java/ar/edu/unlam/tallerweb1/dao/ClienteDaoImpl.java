package ar.edu.unlam.tallerweb1.dao;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.cliente.Cliente;

@Repository ("clienteDao")
public class ClienteDaoImpl implements ClienteDao{

	@Inject
	private SessionFactory sessionFactory;
	
	@Override
	public Cliente consultarClientePorDni(Long dni) {
		Session session = sessionFactory.getCurrentSession();
		return (Cliente) session.createCriteria(Cliente.class)
				.add(Restrictions.eq("dni", dni))
				.uniqueResult();
	}

	@Override
	public void guardarCliente(Cliente cliente) {
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(cliente);
		
	}
	
}
