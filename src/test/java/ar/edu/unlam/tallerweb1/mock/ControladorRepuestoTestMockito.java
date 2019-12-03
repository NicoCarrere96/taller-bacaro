package ar.edu.unlam.tallerweb1.mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controladores.ControladorStockRepuestos;
import ar.edu.unlam.tallerweb1.modelo.taller.Taller;
import ar.edu.unlam.tallerweb1.servicios.ServicioRepuesto;

public class ControladorRepuestoTestMockito {
	
private ControladorStockRepuestos controladorStockRepuestos = new ControladorStockRepuestos();
	
	private ServicioRepuesto servicioRepuesto = mock(ServicioRepuesto.class);
	
	
	@Test
	public void agregarUnRepuestoAUnTaller() {
		
		
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpSession session = mock(HttpSession.class);
		Taller taller = mock(Taller.class);
		
		controladorStockRepuestos.setServicioRespuesto(servicioRepuesto);
		
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("taller")).thenReturn(taller);
		
		ModelAndView rep = controladorStockRepuestos.agregarRepuesto(request);
		
		assertThat(rep.getViewName()).isEqualTo("repuestos/agregarRepuesto");
		
	}
	
	@Test
	public void eliminarRepuestoAUnTaller() {
		
		Long idRepuesto = 1L;
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpSession session = mock(HttpSession.class);
		Taller taller = mock(Taller.class);
		
		controladorStockRepuestos.setServicioRespuesto(servicioRepuesto);
		
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("taller")).thenReturn(taller);
		
		ModelAndView rep = controladorStockRepuestos.eliminarRepuesto(idRepuesto, request);
		
		assertThat(rep.getViewName()).isEqualTo("redirect: abmRepuestos");
		
	}


}
