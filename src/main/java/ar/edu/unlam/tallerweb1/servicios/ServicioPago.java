package ar.edu.unlam.tallerweb1.servicios;
import com.mercadopago.resources.Preference;

import ar.edu.unlam.tallerweb1.modelo.cliente.Cliente;
import ar.edu.unlam.tallerweb1.modelo.taller.Taller;

public interface ServicioPago {

	Preference realizarPago(Cliente cliente, Taller taller, Double total);
	
}
