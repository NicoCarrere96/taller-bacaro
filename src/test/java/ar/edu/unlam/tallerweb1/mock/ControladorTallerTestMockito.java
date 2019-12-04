package ar.edu.unlam.tallerweb1.mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controladores.ControladorTaller;
import ar.edu.unlam.tallerweb1.modelo.taller.Taller;
import ar.edu.unlam.tallerweb1.servicios.ServicioTaller;
import ar.edu.unlam.tallerweb1.utils.Especialidad;

public class ControladorTallerTestMockito {
	
	private ControladorTaller controladorTaller = new ControladorTaller();
	private ServicioTaller servicioTaller = mock(ServicioTaller.class);
	
	@Test
	public void comprobarQueExisteUnTaller() {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpSession session = mock(HttpSession.class);
		
		Long tallerId = 1L;
		Taller taller = mock(Taller.class);
		
		controladorTaller.setServicioTaller(servicioTaller);
		
		when(servicioTaller.buscarTallerPorId(tallerId)).thenReturn(taller);
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("taller")).thenReturn(taller);
		when(taller.getId()).thenReturn(1L);
		when(taller.getNombreDelTaller()).thenReturn("Tito");
		when(taller.getEspecialidad()).thenReturn(Especialidad.GOMERIA);	
		
		ModelAndView mav = controladorTaller.irAlHomeTaller(request);
				
		assertThat(mav.getModel()).isNotEmpty();
		assertThat(mav.getViewName()).isEqualTo("homeTaller");
	}
	
	@Test
	public void darDeAltaUnTaller() {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpSession session = mock(HttpSession.class);
		
		Taller taller = new Taller();
		taller.setId(1L);
		taller.setNombreDelTaller("Cacho");
		taller.setEspecialidad(Especialidad.LUBRICENTRO);
		controladorTaller.setServicioTaller(servicioTaller);
		
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("taller")).thenReturn(taller);
		
		ModelAndView mav = controladorTaller.irAlHomeTaller(request);
				
		assertThat(mav.getModel()).isNotEmpty();
	}

}
