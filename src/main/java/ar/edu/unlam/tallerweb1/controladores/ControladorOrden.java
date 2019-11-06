package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

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
import ar.edu.unlam.tallerweb1.modelo.taller.OrdenRepuesto;
import ar.edu.unlam.tallerweb1.modelo.taller.Taller;
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
	public ModelAndView formularioDeOrden(@PathVariable Long idReserva, HttpServletRequest request) {
		Taller taller = (Taller) request.getSession().getAttribute("taller");

		if (taller != null) {
			ModelMap modelo = new ModelMap();

			Orden orden = new Orden();
			orden.setReserva(servicioReserva.buscarReservaPorId(idReserva));

			servicioOrden.guardarOrden(orden);
			modelo.addAttribute("orden", orden);

			return new ModelAndView("formularios/orden", modelo);
		} else {
			return new ModelAndView("redirect:/login");
		}

	}

	@RequestMapping(path = "/editar/{idReserva}", method = RequestMethod.GET)
	@Transactional
	public ModelAndView formularioDeOrdenEdicion(HttpServletRequest request, @PathVariable Long idReserva) {

		Taller taller = (Taller) request.getSession().getAttribute("taller");

		if (taller != null) {
			ModelMap modelo = new ModelMap();

			Reserva reserva = servicioReserva.buscarReservaPorId(idReserva);
			Orden orden = servicioOrden.consultarOrdenPorReserva(reserva);

			modelo.addAttribute("orden", orden);
			modelo.addAttribute("listaRepuestos", servicioRepuesto.consultarRepuestosPorOrden(orden));
			if (orden.getReserva().getEstado() == EstadoReserva.RECHAZADA) {
				servicioOrden.modificarOrden(orden);
			}
			if (orden.getReserva().getEstado() == EstadoReserva.PENDIENTE) {
				servicioOrden.actualizarOrden(orden);
			}
			return new ModelAndView("formularios/orden", modelo);
		} else {
			return new ModelAndView("redirect:/login");
		}
	}

	@RequestMapping(path = "/nueva", method = RequestMethod.POST)
	@Transactional
	public ModelAndView guardarOrden(@ModelAttribute Orden orden, HttpServletRequest request) {

		Taller taller = (Taller) request.getSession().getAttribute("taller");

		if (taller != null) {
			orden.setReserva(servicioReserva.buscarReservaPorId(orden.getReserva().getId()));
			orden.getReserva().setEstado(EstadoReserva.PRESUPUESTADA);

			servicioOrden.guardarOrden(orden);

			return new ModelAndView("redirect:/reserva/lista");
		} else {
			return new ModelAndView("redirect:/login");
		}
	}

	@RequestMapping(path = "/ordenPresupuestada", method = RequestMethod.GET)
	@Transactional
	public ModelAndView verPresupuesto(HttpServletRequest request, @RequestParam("idReserva") Long idReserva) {
		ModelMap modelo = new ModelMap();
		Reserva reserva = servicioReserva.buscarReservaPorId(idReserva);
		Orden orden = servicioOrden.consultarOrdenPorReserva(reserva);
		List<OrdenRepuesto> listaRepuestos = servicioRepuesto.consultarRepuestosPorOrden(orden);


		orden.setTotal(orden.getReserva().getTaller().getManoDeObra() * orden.getHorasDeTrabajo());

		for (OrdenRepuesto repuesto : listaRepuestos) {
			orden.setTotal(orden.getTotal() + (repuesto.getCantidad() * repuesto.getRepuesto().getPrecio()));
		}

		modelo.put("reserva", reserva);
		modelo.put("orden", orden);
		modelo.put("repuestos", listaRepuestos);

		return new ModelAndView("formularios/ordenPresupuestada", modelo);
	}

	@RequestMapping(path = "/contestarPresupuesto", method = RequestMethod.GET)
	@Transactional
	public ModelAndView aprobarOrden(@RequestParam Boolean aprobado, @RequestParam Long id) {

		Orden orden = servicioOrden.consultarOrdenPorId(id);

		if (aprobado) {
			servicioOrden.aprobarOrden(orden);
		} else {
			servicioOrden.rechazarOrden(orden);

		}
		return new ModelAndView("redirect:/reserva/cliente?dni=" + orden.getReserva().getCliente().getDni());
	}

	@RequestMapping(path = "/agregarRepuesto", method = RequestMethod.GET)
	@Transactional
	public ModelAndView agregarRepuesto(HttpServletRequest request, @RequestParam Long reserva) {
		Taller taller = (Taller) request.getSession().getAttribute("taller");

		if (taller != null) {
			ModelMap modelo = new ModelMap();
			OrdenRepuesto ordRep = new OrdenRepuesto();
			ordRep.setOrden(servicioOrden.consultarOrdenPorReserva(servicioReserva.buscarReservaPorId(reserva)));

			modelo.addAttribute("repuestos", servicioRepuesto.consultarRepuestosEnStockPorTaller(taller));
			modelo.addAttribute("ordenRep", ordRep);
			return new ModelAndView("formularios/agregarRepuesto", modelo);
		} else {
			return new ModelAndView("redirect:/login");
		}
	}

	@RequestMapping(path = "/agregarRepuesto", method = RequestMethod.POST)
	@Transactional
	public ModelAndView agregarRepuestoPost(HttpServletRequest request, @ModelAttribute OrdenRepuesto ordRep) {
		Taller taller = (Taller) request.getSession().getAttribute("taller");

		if (taller != null) {
			servicioRepuesto.agregarRepuestoALaOrden(ordRep);

			return new ModelAndView("redirect: editar/" + ordRep.getOrden().getReserva().getId());
		} else {
			return new ModelAndView("redirect:/login");
		}
	}

}
