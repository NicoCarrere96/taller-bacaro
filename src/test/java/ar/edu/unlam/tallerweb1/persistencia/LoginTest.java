package ar.edu.unlam.tallerweb1.persistencia;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.cj.Session;

import ar.edu.unlam.tallerweb1.controladores.ControladorLogin;
import ar.edu.unlam.tallerweb1.modelo.taller.Taller;
import ar.edu.unlam.tallerweb1.modelo.taller.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioTaller;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginTest {

	private ControladorLogin controladorLogin = new ControladorLogin();
	@Test
	
	public void validarLoginSiUsuarioNoExisteDeberiaRedirigirALogin() {
		
		Usuario usuario = null;
		HttpServletRequest request = null;
		ServicioLogin servicio = mock(ServicioLogin.class);
		controladorLogin.setServicioLogin(servicio);

		when(servicio.consultarUsuario(usuario)).thenReturn(null);
		
		ModelAndView mav = controladorLogin.validarLogin(usuario, request); 
		
		assertThat(mav.getViewName()).isEqualTo("login");
		assertThat(mav.getModelMap()).containsValue("Usuario o clave incorrecta");
		assertThat(mav.getModelMap().get("error")).isEqualTo("Usuario o clave incorrecta");
		
	}
	
	@Test
	
	public void validarLoginSiUsuarioExisteDeberiaRedirigirAHome() {
		
		Usuario usuario = mock(Usuario.class);
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpSession session = mock(HttpSession.class);
		
		ServicioLogin servicio = mock(ServicioLogin.class);
		controladorLogin.setServicioLogin(servicio);

		when(servicio.consultarUsuario(usuario)).thenReturn(usuario);
		when(usuario.getRol()).thenReturn("admin");
		when(request.getSession()).thenReturn(session);
		
		ModelAndView mav = controladorLogin.validarLogin(usuario, request); 
		
		assertThat(mav.getViewName()).isEqualTo("redirect:/taller/homeTaller");
		verify(session,times(1)).setAttribute("ROL","admin");
		
	}
}
