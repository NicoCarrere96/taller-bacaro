package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Orden;
import ar.edu.unlam.tallerweb1.servicios.ServicioOrden;

@Controller
@RequestMapping("/orden")
public class ControladorOrden {
	
	@Inject
	private ServicioOrden servicioOrden;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView formularioDeOrden() {
		ModelMap modelo = new ModelMap();
		
		modelo.addAttribute("orden", new Orden());
		
		return new ModelAndView("formularios/orden", modelo);
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@Transactional
	public ModelAndView guardarOrden(@ModelAttribute Orden orden) {
		
		servicioOrden.guardarOrden(orden);
		
		return new ModelAndView("home");
	}
}
