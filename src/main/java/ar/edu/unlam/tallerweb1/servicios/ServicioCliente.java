package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.cliente.Cliente;

public interface ServicioCliente {
	Cliente consultarClientePorDni(Long dni);
	void guardarCliente(Cliente cliente);
}
