package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Orden;
import ar.edu.unlam.tallerweb1.modelo.cliente.Reserva;
import ar.edu.unlam.tallerweb1.servicios.ServicioOrden;
import ar.edu.unlam.tallerweb1.servicios.ServicioRepuesto;
import ar.edu.unlam.tallerweb1.servicios.ServicioReserva;
import ar.edu.unlam.tallerweb1.utils.EstadoReserva;

@Controller
@RequestMapping(path = "/orden")
public class ControladorOrden {

	@Inject
	private ServicioOrden servicioOrden;
	@Inject
	private ServicioReserva servicioReserva;
	@Inject
	private ServicioRepuesto servicioRepuesto;

	@RequestMapping(path = "/nueva/{idReserva}", method = RequestMethod.GET)
	@Transactional
	public ModelAndView formularioDeOrden(@PathVariable Long idReserva) {
		ModelMap modelo = new ModelMap();

		Orden orden = new Orden();
		orden.setReserva(servicioReserva.buscarReservaPorId(idReserva));
		
		modelo.addAttribute("orden", orden);
		modelo.addAttribute("listaRepuestos", servicioRepuesto.consultarRepuestosEnStockPorTaller(orden.getReserva().getTaller()));

		return new ModelAndView("formularios/orden", modelo);

	}

	@RequestMapping(path = "/editar/{idReserva}", method = RequestMethod.GET)
	@Transactional
	public ModelAndView formularioDeOrdenEdicion(@PathVariable Long idReserva) {
		ModelMap modelo = new ModelMap();

		Reserva reserva = servicioReserva.buscarReservaPorId(idReserva);
		Orden orden = servicioOrden.consultarOrdenPorReserva(reserva);
		
		modelo.addAttribute("orden", orden);
//		modelo.addAttribute("listaRepuestos", servicioRepuesto.consultarRepuestosEnStockPorTaller(orden.getReserva().getTaller()));

		return new ModelAndView("formularios/orden", modelo);

	}
	
	@RequestMapping(path = "/nueva/{idReserva}", method = RequestMethod.POST)
	@Transactional
	public ModelAndView guardarOrden(@PathVariable Long idReserva, @ModelAttribute Orden orden) {

		Reserva reserva = servicioReserva.buscarReservaPorId(idReserva);
		reserva.setEstado(EstadoReserva.ORDEN_REGISTRADA);
		servicioReserva.guardarReserva(reserva);
		Orden ordenConReserva = servicioOrden.consultarOrdenPorReserva(reserva);
		
		if(ordenConReserva != null) {
			ordenConReserva.setHorasDeTrabajo(orden.getHorasDeTrabajo());	
		} else {
			ordenConReserva = orden;
			ordenConReserva.setReserva(reserva);
		}
		
			ordenConReserva.calcularTotal();
			servicioOrden.guardarOrden(ordenConReserva);		


		

		return new ModelAndView("home");
	}
	
	@RequestMapping(path = "/agregarRepuesto", method = RequestMethod.POST)
	@Transactional
	public ModelAndView agregarRepuesto(@ModelAttribute Orden orden, @RequestParam Long idRepuesto) {

		ModelMap modelo = new ModelMap();
		
		orden.getRepuestos().add(servicioRepuesto.consultarRepuestoPorId(idRepuesto));
		
		modelo.addAttribute("orden", orden);
		modelo.addAttribute("listaRepuestos", servicioRepuesto.consultarRepuestosEnStockPorTaller(orden.getReserva().getTaller()));
		
		return new ModelAndView("formularios/orden");
	}


}
