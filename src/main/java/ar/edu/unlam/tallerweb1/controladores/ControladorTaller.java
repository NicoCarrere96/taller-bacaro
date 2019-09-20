package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.taller.Localidad;
import ar.edu.unlam.tallerweb1.modelo.taller.Taller;
import ar.edu.unlam.tallerweb1.modelo.taller.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLocalidad;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioTaller;
import ar.edu.unlam.tallerweb1.utils.Especialidad;

@Controller
@RequestMapping(path = "/taller")
public class ControladorTaller {

	@Inject
	private ServicioTaller servicioTaller;
	@Inject
	private ServicioLocalidad servicioLocalidad;
	@Inject
	private ServicioLogin servicioLogin;

	@RequestMapping(path = "/registro", method = RequestMethod.GET)
	@Transactional
	public ModelAndView registro() {
		ModelMap modelo = new ModelMap();
		Taller taller = new Taller();
		taller.setUsuario(new Usuario());
		
		modelo.addAttribute("taller", taller);
		modelo.addAttribute("especialidades", Especialidad.values());
		modelo.addAttribute("localidades", servicioLocalidad.consultarLocalidades());
		
		return new ModelAndView("formularios/registrarse", modelo);
	}

	@RequestMapping(path = "/registro", method = RequestMethod.POST)
	@Transactional
	public ModelAndView registroPost(@ModelAttribute Taller taller) {
		
		taller.getUsuario().setRol("TALLER");
		servicioLogin.guardarUsuario(taller.getUsuario());
		servicioTaller.crearTaller(taller);
		
		
		return new ModelAndView("redirect:/login");
	}

}
