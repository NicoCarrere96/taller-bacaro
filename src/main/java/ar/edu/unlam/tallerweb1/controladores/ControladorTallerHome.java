package ar.edu.unlam.tallerweb1.controladores;


import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.taller.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioRepuesto;
import ar.edu.unlam.tallerweb1.servicios.ServicioTaller;



@Controller
public class ControladorTallerHome {
	
	@Inject
	private ServicioTaller servicioTaller;	
	@RequestMapping("/homeTaller")
	public ModelAndView irAlHomeTaller(HttpServletRequest request) {
		Usuario usuarioLogueado = (Usuario) request.getSession().getAttribute("usuario");
		
		
		if(usuarioLogueado !=null) {
		ModelMap modelo = new ModelMap();
		modelo.put("taller",servicioTaller.consultarTallerPorUsuario((usuarioLogueado)));
		
		return new ModelAndView("homeTaller" , modelo);
		}
		else {
			return new ModelAndView("redirect:login");
		}
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
	    
	    
	    



