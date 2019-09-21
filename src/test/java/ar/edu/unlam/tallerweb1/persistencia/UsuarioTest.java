package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.dao.UsuarioDao;
import ar.edu.unlam.tallerweb1.modelo.taller.Usuario;

public class UsuarioTest extends SpringTest{

	@Autowired
	private UsuarioDao dao;

	    @Test
	    @Transactional @Rollback
	    public void crearUsuario(){
	        Usuario usuario = new Usuario();
	        usuario.setEmail("seba@gmail.com");
	        usuario.setPassword("1234");
	        usuario.setRol("ADMIN");
	        session().save(usuario);
	        
	        Usuario usuario2 = new Usuario();
	        usuario.setEmail("nico@gmail.com");
	        usuario.setPassword("3456");
	        usuario.setRol("ADMIN");
	        session().save(usuario2);
	        
	       dao.guardarUsuario(usuario);
	       
	       Usuario busca = dao.consultarUsuario(usuario);
	       assertThat(busca).isNotNull();

	    
	    }
}
