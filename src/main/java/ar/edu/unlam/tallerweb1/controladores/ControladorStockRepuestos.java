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
import ar.edu.unlam.tallerweb1.servicios.ServicioRepuesto;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

@Controller
@RequestMapping(path = "/stockRepuestos" , method = RequestMethod.GET)
public class ControladorStockRepuestos {
	
	@Inject
	private ServicioRepuesto servicioRepuesto;
	
	@Inject
	private ServicioUsuario servicioUsuario;
	
	@RequestMapping("abmRepuestos")
	public ModelAndView abmRepuestos(HttpServletRequest request) {
		Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
		ModelMap model = new ModelMap();
		if (idUsuario != null) {
			if (servicioUsuario.buscarPorId(idUsuario).getRol().equals("admin")) {
				model.put("repuesto", servicioRepuesto.getAll());
				return new ModelAndView("repuestos/abmRepuesto", model);
			} else {
				return new ModelAndView("redirect:/login");
			}
		} else {
			return new ModelAndView("redirect:/login");
		}
	}
	
	@RequestMapping("/agregarRepuesto")
	public ModelAndView agregarRepuesto(HttpServletRequest request) {
		Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
		ModelMap model = new ModelMap();
		if (idUsuario != null) {
			if (servicioUsuario.buscarPorId(idUsuario).getRol().equals("admin")) {
				Repuesto repuesto = new Repuesto();
				model.put("Repuesto", repuesto);
				return new ModelAndView("repuestos/agregarRepuesto", model);
			} else {
				model.put("avisoError", "Acceso denegado");
				model.put("mensajeError", "Para acceder usted debe tener rol ADMINISTRADOR");
				return new ModelAndView("mensaje", model);}
		} else {
			return new ModelAndView("redirect:/login");
		}
	} 
	
	@RequestMapping(path = "/guardarRepuesto", method = RequestMethod.POST)
	public ModelAndView guardarRepuesto(@ModelAttribute("Repuesto") Repuesto repuesto,
			HttpServletRequest request) {
		Long idAdmin = (Long) request.getSession().getAttribute("idUsuario");
		ModelMap model = new ModelMap();
		if (idAdmin != null) {
			if (servicioUsuario.buscarPorId(idAdmin).getRol().equals("admin")) {
				servicioRepuesto.guardarRepuesto(repuesto);

				model.put("aviso", "Creacion Exitosa");
				model.put("mensaje",String.format("Se ha guardado con el id %d de manera exitosa", repuesto.getId()));
			} else {
				model.put("avisoError", "Creacion Fallida");
				model.put("mensajeError", String.format("No se ha podido crear el repuesto"));
			}
			return new ModelAndView("/mensaje", model);
		} else {
			return new ModelAndView("redirect:/login");
		}
	}

	@RequestMapping(path = "/actualizarRepuesto", method = RequestMethod.POST)
	public ModelAndView actualizarRepuesto(@ModelAttribute("repuesto") Repuesto repuesto,
			HttpServletRequest request) {

		Long idAdmin = (Long) request.getSession().getAttribute("idUsuario");
		ModelMap model = new ModelMap();
		if (idAdmin != null) {
			if (servicioUsuario.buscarPorId(idAdmin).getRol().equals("admin")) {
				servicioRepuesto.actualizarRepuesto(repuesto);
				model.put("aviso", "Actualización exitosa");
				model.put("mensaje", String.format("El repuesto con el id %d  se ha actualizado de manera exitosa",
						repuesto.getId()));
				return new ModelAndView("repuestos/mensaje", model);
			} else {
				return new ModelAndView("redirect:/login");
			}
		} else {
			return new ModelAndView("redirect:/login");
		}
	}

	@RequestMapping("/modificarRepuesto")
	public ModelAndView modificarRepuesto(@RequestParam("idRepuesto") Long idRepuesto, HttpServletRequest request) {

		Long idAdmin = (Long) request.getSession().getAttribute("idUsuario");
		ModelMap model = new ModelMap();
		if (idAdmin != null) {
			if (servicioUsuario.buscarPorId(idAdmin).getRol().equals("admin")) {
				Repuesto repuesto = servicioRepuesto.consultarRepuestoPorId(idRepuesto);
				
				model.put("repuesto", repuesto);
				return new ModelAndView("repuestos/modificarRepuesto", model);
			} else {
				return new ModelAndView("redirect:/login");
			}
		} else {
			return new ModelAndView("redirect:/login");
		}
	}

	@RequestMapping("/eliminarRepuesto")
	public ModelAndView eliminarRepuesto(@RequestParam("idRepuesto") Long idRepuesto, HttpServletRequest request) {

		Long idAdmin = (Long) request.getSession().getAttribute("idUsuario");
		ModelMap model = new ModelMap();
		if (idAdmin != null) {
			if (servicioUsuario.buscarPorId(idAdmin).getRol().equals("admin")) {
				Repuesto repuesto = servicioRepuesto.consultarRepuestoPorId(idRepuesto);
				servicioRepuesto.eliminarRepuesto(repuesto);
				model.put("aviso", "Eliminación exitosa");
				model.put("mensaje", "El repuesto se ha eliminado de manera exitosa");
			} else {
				model.put("avisoError", "Eliminacion Cancelada");
				model.put("mensajeError",String.format("El repuesto con el id %d  no pudo eliminarse"));
			}
			return new ModelAndView("repuestos/mensaje", model);
		} else {
			return new ModelAndView("redirect:/login");
		}
	}
	
}