package ar.edu.unlam.tallerweb1.mock;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controladores.ControladorCliente;
import ar.edu.unlam.tallerweb1.controladores.ControladorTaller;
import ar.edu.unlam.tallerweb1.modelo.cliente.Cliente;
import ar.edu.unlam.tallerweb1.modelo.taller.Taller;
import ar.edu.unlam.tallerweb1.servicios.ServicioCliente;
import ar.edu.unlam.tallerweb1.servicios.ServicioTaller;
import ar.edu.unlam.tallerweb1.utils.Especialidad;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import ar.edu.unlam.tallerweb1.SpringTest;


public class TallerMock{

	private ControladorTaller controladorTaller = new ControladorTaller();
	private ServicioTaller servicioTaller = mock(ServicioTaller.class);
	private ControladorCliente controladorCliente = new ControladorCliente();
	private ServicioCliente servicioCliente = mock(ServicioCliente.class);
	
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
	public void buscarClientePorDni() {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpSession session = mock(HttpSession.class);
		Cliente cliente = mock(Cliente.class);
		
		controladorCliente.setServicioCliente(servicioCliente);
		
		when(request.getSession()).thenReturn(session);
		when(cliente.getDni()).thenReturn((long) 11222333);
		
		ModelAndView mav = controladorCliente.buscaCliente(cliente);
				
		assertThat(mav.getModel()).isNotEmpty();
		assertThat(mav.getViewName()).isEqualTo("formularios/cliente");

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