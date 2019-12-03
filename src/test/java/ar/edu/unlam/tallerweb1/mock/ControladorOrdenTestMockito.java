package ar.edu.unlam.tallerweb1.mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controladores.ControladorOrden;
import ar.edu.unlam.tallerweb1.modelo.Orden;
import ar.edu.unlam.tallerweb1.modelo.cliente.Reserva;
import ar.edu.unlam.tallerweb1.modelo.taller.OrdenRepuesto;
import ar.edu.unlam.tallerweb1.modelo.taller.Taller;
import ar.edu.unlam.tallerweb1.servicios.ServicioOrden;
import ar.edu.unlam.tallerweb1.servicios.ServicioRepuesto;
import ar.edu.unlam.tallerweb1.servicios.ServicioReserva;

public class ControladorOrdenTestMockito {

	private ControladorOrden controladorOrden = new ControladorOrden();
	
	private ServicioOrden servicioOrden = mock(ServicioOrden.class);
	private ServicioReserva servicioReserva = mock(ServicioReserva.class);
	private ServicioRepuesto servicioRepuesto = mock(ServicioRepuesto.class);
	
	@Test
	public void abrirVistaDeOrdenNuevaYGenerarPresupuestoLogueado() {
		
		Long idReserva = 1L;
		
		Reserva reserva = mock(Reserva.class);
		Taller taller = mock(Taller.class);
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpSession session = mock(HttpSession.class);
		
		controladorOrden.setServicioReserva(servicioReserva);
		controladorOrden.setServicioOrden(servicioOrden);
		
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("taller")).thenReturn(taller);
		when(servicioReserva.buscarReservaPorId(idReserva)).thenReturn(reserva);
		
		ModelAndView mav = controladorOrden.formularioDeOrden( idReserva, request); 
		
		assertThat(mav.getViewName()).isEqualTo("formularios/orden");
		assertThat(mav.getModelMap()).isNotEmpty();
	}
	
	@Test
	public void abrirVistaDeOrdenNuevaYGenerarPresupuestoSinLoguear() {
		
		Long idReserva = 1L;
		
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpSession session = mock(HttpSession.class);

		
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("taller")).thenReturn(null);
		
		ModelAndView mav = controladorOrden.formularioDeOrden( idReserva, request); 
		
		assertThat(mav.getViewName()).isEqualTo("redirect:/login");
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void verOrdenPresupuestada() {
		
		Long idReserva = 1L;
		
		Orden orden = mock(Orden.class);
		Reserva reserva = mock(Reserva.class);
		Taller taller = mock(Taller.class);
		List<OrdenRepuesto> listaRepuestos = mock(List.class);
		Iterator<OrdenRepuesto> iterator = mock(Iterator.class);
		HttpServletRequest request = mock(HttpServletRequest.class);
		
		controladorOrden.setServicioReserva(servicioReserva);
		controladorOrden.setServicioOrden(servicioOrden);
		controladorOrden.setServicioRespuesto(servicioRepuesto);
		
		when(servicioReserva.buscarReservaPorId(idReserva)).thenReturn(reserva);
		when(servicioOrden.consultarOrdenPorReserva(reserva)).thenReturn(orden);
		when(servicioRepuesto.consultarRepuestosPorOrden(orden)).thenReturn(listaRepuestos);
		when(orden.getReserva()).thenReturn(reserva);
		when(reserva.getTaller()).thenReturn(taller);
		when(listaRepuestos.iterator()).thenReturn(iterator);
		
		ModelAndView mav = controladorOrden.verPresupuesto( request, idReserva); 
		
		assertThat(mav.getViewName()).isEqualTo("formularios/ordenPresupuestada");
		assertThat(mav.getModelMap().get("orden")).isEqualTo(orden);
		assertThat(mav.getModelMap().get("reserva")).isEqualTo(reserva);
	}

	
}
