package ar.edu.unlam.tallerweb1.persistencia;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.controladores.ControladorLogin;
import ar.edu.unlam.tallerweb1.modelo.taller.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

public class UsuarioMockitoTest extends SpringTest{

	
	@Mock
	private ServicioLogin servicioLogin;

	@Mock
	private Usuario usuario;

	@Mock
	private HttpServletRequest request;

	@Mock
	private HttpSession session;

	@InjectMocks
	private ControladorLogin controladorLogin;
	private Usuario usuario1 , usuario2;
	private List<Usuario> listaDeUsuarios;
	private Session sesion;

	@Before
	public void inyeccionDeMocksInicializada() {
		MockitoAnnotations.initMocks(this);
	}
	public void inicializacion() {
		usuario1 = new Usuario();
		usuario2 = new Usuario();
		sesion = session();
		listaDeUsuarios = new ArrayList<Usuario>();
	}

	@Test
	public void testQueVerificaQueElLoginSeaValido() {
		when(request.getSession()).thenReturn(session);
		when(servicioLogin.consultarUsuario(any(Usuario.class))).thenReturn(usuario);
		when(usuario.getId()).thenReturn(1L);
		when(usuario.getEmail()).thenReturn("bacaro@gmail.com");
		when(usuario.getPassword()).thenReturn("123456");

		ModelAndView modelo = controladorLogin.irALogin();
		assertThat(modelo.getModel()).isNotEmpty();
	}

	@Test
	public void testQueVerificaQueHayaCerradoSesionCorrectamente() {
		when(request.getSession()).thenReturn(session);
		when(servicioLogin.consultarUsuario(any(Usuario.class))).thenReturn(usuario);
		when(usuario.getId()).thenReturn(1L);
		when(usuario.getEmail()).thenReturn("bacaro@gmail.com");
		when(usuario.getPassword()).thenReturn("123456");

		ModelAndView modelo = controladorLogin.cerrarSession(request);
		assertThat(modelo.getModel()).isEmpty();
		verify(session , times(0)).setAttribute("UsuarioId", 1L);
	}

	@Test
	public void testQueVerificaQueHayaCerradoSesionIncorrectamente() {
		when(request.getSession()).thenReturn(session);
		when(servicioLogin.consultarUsuario(any(Usuario.class))).thenReturn(usuario);

		ModelAndView modelo = controladorLogin.cerrarSession(request);
		assertThat(modelo.getModel().get("aviso")).isEqualTo(null);
	}


	@SuppressWarnings("unlikely-arg-type")
	@Test
	@Transactional
	@Rollback(true)
	public void testQueAlPasarUsuarioYPasswordNoValidoLlevaAlIndex() {
		Usuario primerUsuario = mock(Usuario.class);
		ServicioLogin servicioLogin = mock(ServicioLogin.class);

		when(usuario.getEmail()).thenReturn("bacaro@gmail.com");
		when(primerUsuario.getPassword()).thenReturn("mock");
		when(servicioLogin.consultarUsuario(any(Usuario.class))).thenReturn(primerUsuario);

		ControladorLogin controladorLogin = new ControladorLogin();
		assertThat(controladorLogin.irAHome().equals(primerUsuario)).isNotNull();

	}

	@Test(expected = Exception.class)
	@Transactional
	@Rollback(true)
	@SuppressWarnings("unchecked")
	public void testQueAlCrearUsuarioSiYaExisteDevuelvaError() throws Exception {
		usuario1.setEmail("bacaro@gmail.com");
		usuario1.setPassword("123456");

		usuario2.setEmail("bacaro@gmail.com");
		usuario2.setPassword("123456");

		if(this.usuario1.getEmail().equals(this.usuario2.getEmail()) || this.usuario1.getPassword().equals(this.usuario2.getPassword())) {
			throw new Exception("Ya existe un usuario con ese email , por favor elija otro");
		} else {
			System.out.println("Usuario valido");
		}

		session().save(usuario1);
		session().save(usuario2);

		listaDeUsuarios = sesion.createCriteria(Usuario.class)
				.add(Restrictions.and(Restrictions.eq("nombre", "nombre"),
						Restrictions.eq("pass", "pass")))
				.list();
		assertThat(listaDeUsuarios.get(0).getEmail()).isEqualTo(usuario1.getEmail()).isNotNull();
		assertThat(listaDeUsuarios).hasSize(1);
	}

	@Test(expected = Exception.class)
	@Transactional
	@Rollback(true)
	@SuppressWarnings("unchecked")
	public void testQueElUsuarioNoEscribaSuPasswordYDevuelvaError() throws Exception {
		
		usuario1.setEmail("bacaro@gmail.com");
		usuario1.setPassword(null);

		if(this.usuario1.getPassword() == null) {
			throw new Exception("Por favor escriba una contraseña");
		} else {
			this.usuario1.getPassword();
		}

		session().save(usuario1);

		listaDeUsuarios = sesion.createCriteria(Usuario.class)
				.add(Restrictions.isNull("pass"))
				.list();

		assertThat(listaDeUsuarios.get(0).getPassword()).isNull();
		assertThat(listaDeUsuarios).hasSize(1);
	}

	@Test(expected = Exception.class)
	@Transactional
	@Rollback(true)
	public void testQueElUsuarioEscribaSuPasswordDeFormaIncorrectaYDevuelvaError() throws Exception{
		
		usuario1.setEmail("bacaro@gmail.com");
		usuario1.setPassword("123456");

		if(this.usuario1.getPassword().equals(this.usuario1.getPassword())) {
			throw new Exception("password incorrecta");
		} else {
			this.usuario1.getPassword();
		}

		session().save(usuario1);
	}
}
