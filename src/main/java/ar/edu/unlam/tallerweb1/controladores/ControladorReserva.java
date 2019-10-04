package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.cliente.Reserva;
import ar.edu.unlam.tallerweb1.servicios.ServicioCliente;
import ar.edu.unlam.tallerweb1.servicios.ServicioReserva;
import ar.edu.unlam.tallerweb1.servicios.ServicioTaller;
import ar.edu.unlam.tallerweb1.utils.EstadoReserva;

@Controller
@RequestMapping("/reserva")
public class ControladorReserva {
	
	@Inject
	private ServicioReserva servicioReserva;
	@Inject
	private ServicioCliente servicioCliente;
	@Inject
	private ServicioTaller servicioTaller;
	
	@RequestMapping(path = "/lista", method = RequestMethod.GET)
	@Transactional
	public ModelAndView traerListadoDeReservas() {
		ModelMap modelo = new ModelMap();
		
		modelo.addAttribute("reservas", servicioReserva.consultarReservas());
		
		return new ModelAndView("listados/reservasTaller", modelo);
	}
	
	@RequestMapping(path = "/cliente", method = RequestMethod.GET)
	@Transactional
	public ModelAndView traerListadoDeReservasClientes(@RequestParam Long dni) {
		ModelMap modelo = new ModelMap();
		
		modelo.addAttribute("reservas", servicioReserva.consultarReservasPorCliente(
				servicioCliente.consultarClientePorDni(dni)
				));
		modelo.addAttribute("dniCliente", dni);
		
		return new ModelAndView("listados/reservasCliente", modelo);
	}
	
	@RequestMapping(path = "/nueva", method = RequestMethod.GET)
	@Transactional
	public ModelAndView formularioDeReserva(@RequestParam Long tallerId, @RequestParam Long dniCliente) {
		ModelMap modelo = new ModelMap();
		
		Reserva reserva = new Reserva();
		reserva.setCliente(servicioCliente.consultarClientePorDni(dniCliente));
		reserva.setTaller(servicioTaller.buscarTallerPorId(tallerId));
		reserva.setEstado(EstadoReserva.PENDIENTE);
		
		modelo.addAttribute("reserva", reserva);
		
		return new ModelAndView("formularios/nuevaReserva", modelo);
	}
	
	@RequestMapping(path = "/nuevaReserva", method = RequestMethod.POST)
	@Transactional
	public ModelAndView guardarReserva(@ModelAttribute Reserva reserva) {
		
		servicioReserva.guardarReserva(reserva);
		
		
		return new ModelAndView("redirect:cliente?dni=" + reserva.getCliente().getDni());
	}

}
