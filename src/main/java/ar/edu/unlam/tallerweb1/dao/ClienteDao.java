package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.cliente.Cliente;

public interface ClienteDao {
	Cliente consultarClientePorDni(Long dni);
	void guardarCliente(Cliente cliente);
}
