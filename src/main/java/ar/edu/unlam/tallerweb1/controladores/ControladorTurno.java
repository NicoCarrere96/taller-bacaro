package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.cliente.Turno;
import ar.edu.unlam.tallerweb1.modelo.taller.Taller;
import ar.edu.unlam.tallerweb1.servicios.ServicioTurno;

@Controller
@RequestMapping(path = "/turno", method = RequestMethod.GET)
public class ControladorTurno {

	@Inject
	private ServicioTurno servicioTurno;
	
	@RequestMapping("/abmTurnos")
	public ModelAndView abmTurnos(HttpServletRequest request) {
		Taller taller = (Taller) request.getSession().getAttribute("taller");
		ModelMap model = new ModelMap();

		if (taller != null) {
			model.put("turno", servicioTurno.consultarTurnosPorTaller(taller));
			return new ModelAndView("turnos/abmTurnos", model);
		} else {
			return new ModelAndView("redirect:/taller/homeTaller");
		}
	}

	@RequestMapping("/agregarTurno")
	public ModelAndView agregarTurno(HttpServletRequest request) {
		Taller taller = (Taller) request.getSession().getAttribute("taller");
		ModelMap model = new ModelMap();

		if (taller != null) {
			Turno turno = new Turno();
			model.put("turno", turno);
			return new ModelAndView("turnos/agregarTurno", model);
		} else {
			return new ModelAndView("redirect:/taller/homeTaller");
		}
	}

	@RequestMapping(path = "/guardarTurno", method = RequestMethod.POST)
	public ModelAndView guardarTurno(@ModelAttribute("Turno") Turno turno, HttpServletRequest request) {
		Taller taller = (Taller) request.getSession().getAttribute("taller");
		if (taller != null) {

			turno.setTaller(taller);
			servicioTurno.guardarTurno(turno);

			return new ModelAndView("redirect: abmTurnos");
		} else {
			return new ModelAndView("redirect:/taller/homeTaller");
		}
	}

	@RequestMapping(path = "/actualizarTurno", method = RequestMethod.POST)
	public ModelAndView actualizarTurno(@ModelAttribute("turno") Turno turno, HttpServletRequest request) {
		Taller taller = (Taller) request.getSession().getAttribute("taller");
		if (taller != null) {
			turno.setTaller(taller);
			servicioTurno.actualizarTurno(turno);

			return new ModelAndView("redirect: abmTurnos");
		} else {
			return new ModelAndView("redirect:/taller/homeTaller");
		}
	}

	@RequestMapping("/modificarTurno")
	public ModelAndView modificarTurno(@RequestParam("idTurno") Long idTurno, HttpServletRequest request) {

		Taller taller = (Taller) request.getSession().getAttribute("taller");
		ModelMap model = new ModelMap();
		if (taller != null) {
			Turno turno = servicioTurno.consultarTurnoPorId(idTurno);

			model.put("turno", turno);
			return new ModelAndView("turnos/modificarTurno", model);
		} else {
			return new ModelAndView("redirect:/taller/homeTaller");
		}
	}

	@RequestMapping("/eliminarTurno")
	public ModelAndView eliminarTurno(@RequestParam("idTurno") Long idTurno, HttpServletRequest request) {

		Taller taller = (Taller) request.getSession().getAttribute("taller");
		if (taller != null) {
			Turno turno = servicioTurno.consultarTurnoPorId(idTurno);
			
			servicioTurno.eliminarTurno(turno);
			return new ModelAndView("redirect: abmTurnos");
		} else {
			return new ModelAndView("redirect:/taller/homeTaller");
		}
	}
}
