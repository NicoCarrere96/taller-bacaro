package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Orden;
import ar.edu.unlam.tallerweb1.modelo.cliente.Cliente;
import ar.edu.unlam.tallerweb1.modelo.cliente.Reserva;
import ar.edu.unlam.tallerweb1.modelo.taller.Taller;

public interface ServicioEnvioMail {
	public void enviarMail(Reserva reserva,Cliente cliente,Taller taller, Orden orden);

}
