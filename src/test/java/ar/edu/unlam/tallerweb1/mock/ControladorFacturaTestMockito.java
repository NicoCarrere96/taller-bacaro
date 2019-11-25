package ar.edu.unlam.tallerweb1.mock;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.controladores.ControladorFactura;
import ar.edu.unlam.tallerweb1.modelo.Orden;
import ar.edu.unlam.tallerweb1.modelo.cliente.Reserva;
import ar.edu.unlam.tallerweb1.modelo.taller.OrdenRepuesto;
import ar.edu.unlam.tallerweb1.modelo.taller.Taller;
import ar.edu.unlam.tallerweb1.servicios.ServicioOrden;
import ar.edu.unlam.tallerweb1.servicios.ServicioRepuesto;
import ar.edu.unlam.tallerweb1.servicios.ServicioReserva;

public class ControladorFacturaTestMockito {

	private ControladorFactura controladorFactura = new ControladorFactura();
	
	private ServicioOrden servicioOrden = mock(ServicioOrden.class);
	private ServicioRepuesto servicioRepuesto = mock(ServicioRepuesto.class);
	private ServicioReserva servicioReserva = mock(ServicioReserva.class);
	
	
	@Test
	public void buscarOrdenYGenerarFactura() {

		Long ordenId = 1L;
		
		Orden orden = mock(Orden.class);
		Reserva reserva = mock(Reserva.class);
		Taller taller = mock(Taller.class);
		List<OrdenRepuesto> listaRepuestos = mock(List.class);
		Iterator<OrdenRepuesto> iterator = mock(Iterator.class);
		controladorFactura.setServicioOrden(servicioOrden);
		controladorFactura.setServicioRepuesto(servicioRepuesto);
		controladorFactura.setServicioReserva(servicioReserva);
		
		when(servicioOrden.consultarOrdenPorId(ordenId)).thenReturn(orden);
		when(servicioRepuesto.consultarRepuestosPorOrden(orden)).thenReturn(listaRepuestos);
		when(orden.getReserva()).thenReturn(reserva);
		when(reserva.getTaller()).thenReturn(taller);		
		when(listaRepuestos.iterator()).thenReturn(iterator);

		ModelAndView mav = controladorFactura.crearFactura(ordenId); 
		
		
		assertThat(mav.getViewName()).isEqualTo("facturaGenerada");
		assertThat(mav.getModelMap().get("factura")).isEqualTo(orden);
		assertThat(mav.getModelMap().get("listaRepuestos")).isEqualTo(listaRepuestos);
	}
	
	@Test
	public void buscarFacturaPorReservaYMostrarVista() {

		Long reservaId = 1L;
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpSession session = mock(HttpSession.class);
		
		Reserva reserva = mock(Reserva.class);
		Orden orden = mock(Orden.class);
		Taller taller = mock(Taller.class);
		List<OrdenRepuesto> listaRepuestos = mock(List.class);
		
		controladorFactura.setServicioOrden(servicioOrden);
		controladorFactura.setServicioRepuesto(servicioRepuesto);
		controladorFactura.setServicioReserva(servicioReserva);
		
		
		when(servicioReserva.buscarReservaPorId(reservaId)).thenReturn(reserva);
		when(servicioOrden.consultarOrdenPorReserva(reserva)).thenReturn(orden);
		when(servicioRepuesto.consultarRepuestosPorOrden(orden)).thenReturn(listaRepuestos);
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("taller")).thenReturn(taller);
		
		ModelAndView mav = controladorFactura.verFactura(reservaId, request);
		
		assertThat(mav.getViewName()).isEqualTo("facturaGenerada");
		assertThat(mav.getModelMap().get("factura")).isEqualTo(orden);
		assertThat(mav.getModelMap().get("listaRepuestos")).isEqualTo(listaRepuestos);
		assertThat(mav.getModelMap()).containsKey("cliente");
	}
	

	
}
