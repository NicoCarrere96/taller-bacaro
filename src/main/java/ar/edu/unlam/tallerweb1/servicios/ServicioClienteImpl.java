package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.dao.ClienteDao;
import ar.edu.unlam.tallerweb1.modelo.cliente.Cliente;

@Service("servicioCliente")
public class ServicioClienteImpl implements ServicioCliente{

	@Inject
	private ClienteDao dao;
	
	@Override
	public Cliente consultarClientePorDni(Long dni) {
		return dao.consultarClientePorDni(dni);
	}

	@Override
	public void guardarCliente(Cliente cliente) {
		dao.guardarCliente(cliente);
	}

}
