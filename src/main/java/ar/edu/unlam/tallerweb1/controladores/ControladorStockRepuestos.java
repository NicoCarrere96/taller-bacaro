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

import ar.edu.unlam.tallerweb1.modelo.taller.Repuesto;
import ar.edu.unlam.tallerweb1.modelo.taller.Taller;
import ar.edu.unlam.tallerweb1.servicios.ServicioRepuesto;

@Controller
@RequestMapping(path = "/stockRepuestos", method = RequestMethod.GET)
public class ControladorStockRepuestos {

	@Inject
	private ServicioRepuesto servicioRepuesto;

	@RequestMapping("abmRepuestos")
	public ModelAndView abmRepuestos(HttpServletRequest request) {
		Taller taller = (Taller) request.getSession().getAttribute("taller");
		ModelMap model = new ModelMap();

		if (taller != null) {
			model.put("repuesto", servicioRepuesto.consultarRepuestosPorTaller(taller));
			return new ModelAndView("repuestos/abmRepuesto", model);
		} else {
			return new ModelAndView("redirect:/login");
		}
	}

	@RequestMapping("/agregarRepuesto")
	public ModelAndView agregarRepuesto(HttpServletRequest request) {
		Taller taller = (Taller) request.getSession().getAttribute("taller");
		ModelMap model = new ModelMap();

		if (taller != null) {
			Repuesto repuesto = new Repuesto();
			model.put("repuesto", repuesto);
			return new ModelAndView("repuestos/agregarRepuesto", model);
		} else {
			return new ModelAndView("redirect:/login");
		}
	}

	@RequestMapping(path = "/guardarRepuesto", method = RequestMethod.POST)
	public ModelAndView guardarRepuesto(@ModelAttribute("Repuesto") Repuesto repuesto, HttpServletRequest request) {
		Taller taller = (Taller) request.getSession().getAttribute("taller");
		if (taller != null) {

			repuesto.setTaller(taller);
			servicioRepuesto.guardarRepuesto(repuesto);

			return new ModelAndView("redirect: abmRepuestos");
		} else {
			return new ModelAndView("redirect:/login");
		}
	}

	@RequestMapping(path = "/actualizarRepuesto", method = RequestMethod.POST)
	public ModelAndView actualizarRepuesto(@ModelAttribute("repuesto") Repuesto repuesto, HttpServletRequest request) {
		Taller taller = (Taller) request.getSession().getAttribute("taller");
		if (taller != null) {
			repuesto.setTaller(taller);
			servicioRepuesto.actualizarRepuesto(repuesto);

			return new ModelAndView("redirect: abmRepuestos");
		} else {
			return new ModelAndView("redirect:/login");
		}
	}

	@RequestMapping("/modificarRepuesto")
	public ModelAndView modificarRepuesto(@RequestParam("idRepuesto") Long idRepuesto, HttpServletRequest request) {

		Taller taller = (Taller) request.getSession().getAttribute("taller");
		ModelMap model = new ModelMap();
		if (taller != null) {
			Repuesto repuesto = servicioRepuesto.consultarRepuestoPorId(idRepuesto);

			model.put("repuesto", repuesto);
			return new ModelAndView("repuestos/modificarRepuesto", model);
		} else {
			return new ModelAndView("redirect:/login");
		}
	}

	@RequestMapping("/eliminarRepuesto")
	public ModelAndView eliminarRepuesto(@RequestParam("idRepuesto") Long idRepuesto, HttpServletRequest request) {

		Taller taller = (Taller) request.getSession().getAttribute("taller");
		if (taller != null) {
			Repuesto repuesto = servicioRepuesto.consultarRepuestoPorId(idRepuesto);
			
			servicioRepuesto.eliminarRepuesto(repuesto);
			return new ModelAndView("redirect: abmRepuestos");
		} else {
			return new ModelAndView("redirect:/login");
		}
	}

}