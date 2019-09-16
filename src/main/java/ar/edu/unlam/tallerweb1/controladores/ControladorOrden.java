package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Orden;
import ar.edu.unlam.tallerweb1.modelo.cliente.Reserva;
import ar.edu.unlam.tallerweb1.servicios.ServicioOrden;
import ar.edu.unlam.tallerweb1.servicios.ServicioReserva;

@Controller
public class ControladorOrden {
	
	@Inject
	private ServicioOrden servicioOrden;
	@Inject
	private ServicioReserva servicioReserva;
	
	@RequestMapping(path = "/orden/{idReserva}", method = RequestMethod.GET)
	@Transactional
	public ModelAndView formularioDeOrden(@PathVariable Long idReserva) {
		ModelMap modelo = new ModelMap();

		Orden orden = new Orden();
		orden.setReserva(servicioReserva.buscarReservaPorId(idReserva));
		
		modelo.addAttribute("orden", orden);
		
		return new ModelAndView("formularios/orden", modelo);
		
	}
	
	@RequestMapping(path = "/orden/{idReserva}", method = RequestMethod.POST)
	@Transactional
	public ModelAndView guardarOrden(@PathVariable Long idReserva, @ModelAttribute Orden orden) {
		
		orden.setReserva(servicioReserva.buscarReservaPorId(idReserva));
		servicioOrden.guardarOrden(orden);
		
		return new ModelAndView("home");
	}
}
