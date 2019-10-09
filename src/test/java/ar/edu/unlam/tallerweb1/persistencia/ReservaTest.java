package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.dao.ReservaDao;
import ar.edu.unlam.tallerweb1.modelo.cliente.Cliente;
import ar.edu.unlam.tallerweb1.modelo.cliente.Reserva;
import ar.edu.unlam.tallerweb1.modelo.taller.Taller;


public class ReservaTest extends SpringTest{
	
	@Autowired
	private ReservaDao dao;

		@Test
	    @Transactional @Rollback
	    public void crearUnaReserva(){

	    
	    Taller tall = new Taller();
	    tall.setNombreDelTaller("Neumen");
	    session().save(tall);
	    Cliente cl = new Cliente();
	    
	    cl.setDni((long) 31009870);
	    cl.setNombre("Eusebio");
	    cl.setMail("euse@gmail.com");
	    session().save(cl);
	    
	    String dia = "2019-10-19";
	    
	    Reserva res = new Reserva();
	    res.setTaller(tall);
	    res.setCliente(cl);
	    res.setFecha("20190909");
	    session().save(res);
	    
	    Reserva reserv = dao.buscarReservaPorId(res.getId());
	    
	    assertThat(reserv).isNotNull();
	    
	    }	    
	    
	    
}
