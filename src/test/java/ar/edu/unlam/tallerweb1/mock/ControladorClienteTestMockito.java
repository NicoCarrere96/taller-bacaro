package ar.edu.unlam.tallerweb1.mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controladores.ControladorCliente;
import ar.edu.unlam.tallerweb1.modelo.cliente.Cliente;
import ar.edu.unlam.tallerweb1.servicios.ServicioCliente;

public class ControladorClienteTestMockito {
	
	private ControladorCliente controladorCliente = new ControladorCliente();
	private ServicioCliente servicioCliente = mock(ServicioCliente.class);
	
	
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

}
