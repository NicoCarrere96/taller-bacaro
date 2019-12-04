package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.dao.TurnoDao;
import ar.edu.unlam.tallerweb1.modelo.cliente.Turno;


public class TurnoTest extends SpringTest {
	@Autowired
	private TurnoDao dao;

	    @Test
	    @Transactional @Rollback
	    public void crearTurno(){
	        Turno turno = new Turno();
	        turno.setFecha("13/12/2019");
	        turno.setHorario("8:00 16:00");
	        turno.setCantidad(5);
	        session().save(turno);
	        
	        Turno turno1 = new Turno();
	        turno1.setFecha("23/12/2019");
	        turno1.setHorario("8:00 18:00");
	        turno1.setCantidad(8);
	        session().save(turno1);
	        
	       dao.save(turno);
	       dao.save(turno1);
	       
	       List<Turno> buscar = dao.listarTurnosPosiblesDao();
	       assertThat(buscar).isNotNull();

	    
	    }
	    
	    @Test
	    @Transactional @Rollback
	    public void modificarTurno(){
	        Turno turno = new Turno();
	        turno.setId(1L);
	        turno.setFecha("13/12/2019");
	        turno.setHorario("09:00 17:00");
	        turno.setCantidad(4);
	        session().save(turno);
	        
	        turno.setCantidad(6);
	        session().update(turno);
	        
	        Turno buscado = dao.consultarTurnoPorId(1L);
	       
	       assertThat(buscado).hashCode();

	    
	    }
	    
	    @Test
	    @Transactional @Rollback
	    public void eliminarTurno(){
	        Turno turno = new Turno();
	        turno.setId(1L);
	        turno.setFecha("15/07/2020");
	        turno.setHorario("09:00 17:00");
	        turno.setCantidad(5);
	        session().save(turno);
	        
	        session().delete(turno);
	        
	        Turno buscado = dao.consultarTurnoPorId(1L);
	       
	       assertThat(buscado).isNull();

	    
	    }   
	

}
