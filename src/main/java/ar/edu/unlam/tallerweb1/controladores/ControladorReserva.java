package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.cliente.Reserva;
import ar.edu.unlam.tallerweb1.servicios.ServicioReserva;

@Controller
@RequestMapping("/reserva")
public class ControladorReserva {
	
	@Inject
	private ServicioReserva servicioReserva;
	
	@RequestMapping(path = "/lista", method = RequestMethod.GET)
	@Transactional
	public ModelAndView traerListadoDeReservas() {
		ModelMap modelo = new ModelMap();
		
		modelo.addAttribute("reservas", servicioReserva.consultarReservas());
		
		return new ModelAndView("listados/reservas", modelo);
	}
	
	@RequestMapping(path = "/nueva", method = RequestMethod.GET)
	public ModelAndView formularioDeReserva() {
		ModelMap modelo = new ModelMap();
		
		modelo.addAttribute("reserva", new Reserva());
		
		return new ModelAndView("formularios/nuevaReserva", modelo);
	}

}
