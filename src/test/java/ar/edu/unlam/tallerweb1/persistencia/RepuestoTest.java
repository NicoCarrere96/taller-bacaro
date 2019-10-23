package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.dao.RepuestoDao;
import ar.edu.unlam.tallerweb1.modelo.taller.Repuesto;

public class RepuestoTest extends SpringTest {
	
	@Autowired
	private RepuestoDao dao;

	    @Test
	    @Transactional @Rollback
	    public void crearRepuesto(){
	        Repuesto repuesto = new Repuesto();
	        repuesto.setNombre("Acelerador");
	        repuesto.setPrecio(1200.0);
	        repuesto.setStock(5);
	        session().save(repuesto);
	        
	        Repuesto repuesto1 = new Repuesto();
	        repuesto1.setNombre("Mariposa");
	        repuesto1.setPrecio(15000.0);
	        repuesto1.setStock(6);
	        session().save(repuesto1);
	        
	       dao.save(repuesto);
	       dao.save(repuesto1);
	       
	       List<Repuesto> buscar = dao.consultarRepuestosEnStock();
	       assertThat(buscar).isNotNull();

	    
	    }
	    
	    @Test
	    @Transactional @Rollback
	    public void modificarRepuesto(){
	        Repuesto repuesto = new Repuesto();
	        repuesto.setId(1L);
	        repuesto.setNombre("Acelerador");
	        repuesto.setPrecio(1200.0);
	        repuesto.setStock(5);
	        session().save(repuesto);
	        
	        repuesto.setPrecio(18000.0);
	        session().update(repuesto);
	        
	        Repuesto buscado = dao.consultarRepuestoPorId(1L);
	       
	       assertThat(buscado).hashCode();

	    
	    }
	    
	    @Test
	    @Transactional @Rollback
	    public void eliminarRepuesto(){
	        Repuesto repuesto = new Repuesto();
	        repuesto.setId(1L);
	        repuesto.setNombre("Acelerador");
	        repuesto.setPrecio(1200.0);
	        repuesto.setStock(5);
	        session().save(repuesto);
	        
	        session().delete(repuesto);
	        
	        Repuesto buscado = dao.consultarRepuestoPorId(1L);
	       
	       assertThat(buscado).isNull();

	    
	    }   

}
