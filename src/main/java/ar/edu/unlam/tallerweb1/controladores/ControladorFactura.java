package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Orden;
import ar.edu.unlam.tallerweb1.modelo.cliente.Reserva;
import ar.edu.unlam.tallerweb1.modelo.taller.Factura;
import ar.edu.unlam.tallerweb1.modelo.taller.OrdenRepuesto;
import ar.edu.unlam.tallerweb1.servicios.ServicioOrden;
import ar.edu.unlam.tallerweb1.servicios.ServicioRepuesto;
import ar.edu.unlam.tallerweb1.servicios.ServicioReserva;

@Controller
@RequestMapping(path = "/factura")
public class ControladorFactura {
	
	@Inject
	private ServicioOrden servicioOrden;
	@Inject
	private ServicioRepuesto servicioRepuesto;
	@Inject
	private ServicioReserva servicioReserva;
	
	@RequestMapping(path = "/generarFactura", method = RequestMethod.GET)
	@Transactional
	public ModelAndView crearFactura(@RequestParam Long ordenId) {
		ModelMap modelo = new ModelMap();
		Factura factura = new Factura();
		Orden ordenBuscada = servicioOrden.consultarOrdenPorId(ordenId);
		List<OrdenRepuesto> listaRepuestos = servicioRepuesto.consultarRepuestosPorOrden(ordenBuscada);
		
		factura.setOrden(ordenBuscada);
		
		for(OrdenRepuesto repuesto : listaRepuestos){
			factura.setTotal(factura.getTotal() + (repuesto.getCantidad() * repuesto.getRepuesto().getPrecio()));
		}
		
		modelo.put("factura", factura);
		
		return new ModelAndView("factura", modelo);
		
	}
	
	@RequestMapping(path = "/verFactura", method = RequestMethod.GET)
	@Transactional
	public ModelAndView verFactura(@RequestParam Long reservaId) {
		ModelMap modelo = new ModelMap();
		
		Reserva reserva = servicioReserva.buscarReservaPorId(reservaId);
		Orden ordenBuscada = servicioOrden.consultarOrdenPorReserva(reserva);
		List<OrdenRepuesto> listaRepuestos = servicioRepuesto.consultarRepuestosPorOrden(ordenBuscada);
		
		modelo.put("orden", ordenBuscada);
		modelo.put("listaRepuestos", listaRepuestos);
		
		return new ModelAndView("factura", modelo);
		
	}
}
