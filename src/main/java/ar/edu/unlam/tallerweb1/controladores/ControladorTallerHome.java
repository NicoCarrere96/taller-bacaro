package ar.edu.unlam.tallerweb1.controladores;


import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unlam.tallerweb1.modelo.taller.Taller;
import ar.edu.unlam.tallerweb1.modelo.taller.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioRepuesto;
import ar.edu.unlam.tallerweb1.servicios.ServicioReserva;
import ar.edu.unlam.tallerweb1.servicios.ServicioTaller;



@Controller
public class ControladorTallerHome {
	@Inject
	private ServicioLogin servicioUsuario;
	
	@RequestMapping(path = "/login-taller", method = RequestMethod.GET)
	public ModelAndView irALoginTaller() {

		ModelMap modelo = new ModelMap();
		Taller taller = new Taller();
		modelo.put("taller", taller);
		return new ModelAndView("login-taller", modelo);
	}
	
	@RequestMapping("/homeTaller")
	public ModelAndView irAlHomeTaller() {
		ModelMap modelo = new ModelMap();
		return new ModelAndView("homeTaller" , modelo);
	}
	
	@RequestMapping(path = "/validar-taller", method = RequestMethod.POST)
	public ModelAndView validarTaller(@ModelAttribute("taller") Usuario usuario, HttpServletRequest request) {
		ModelMap model = new ModelMap();
		Usuario tallerBuscado = servicioUsuario.consultarUsuario(usuario);
		if (tallerBuscado != null) {
			request.getSession().setAttribute("Usuario", tallerBuscado.getEmail());
			
			return new ModelAndView("redirect:/homeTaller");
		} else {
			model.put("error", "Usuario o clave incorrecta");
		}
		return new ModelAndView("homeTaller", model);
	}

	

	@Inject
	private ServicioReserva servicioReserva;
	
	@RequestMapping(path = "/listados/reservas", method = RequestMethod.GET)
	@Transactional
	public ModelAndView traerListadoDeReservas() {
		ModelMap modelo = new ModelMap();
		
		modelo.addAttribute("reservas", servicioReserva.consultarReservas());
		
		return new ModelAndView("/listados/reservas", modelo);
	}

	@Inject
	private ServicioRepuesto servicioRepuesto;
	
	@RequestMapping(path = "/listados/repuestos", method = RequestMethod.GET)
	@Transactional
	public ModelAndView traerListadoDeRepuestos() {
		ModelMap modelo = new ModelMap();
		
		modelo.addAttribute("repuestos", servicioRepuesto.consultarRepuestosEnStock());
		
		return new ModelAndView("/listados/repuestos", modelo);
	}	
	
	
}
	    
	    
	    



