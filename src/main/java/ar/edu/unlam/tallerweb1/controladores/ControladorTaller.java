package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.taller.Localidad;
import ar.edu.unlam.tallerweb1.modelo.taller.Provincia;
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
		modelo.addAttribute("provincias", servicioLocalidad.consultarProvincias());

		return new ModelAndView("formularios/registrarse", modelo);
	}

	@RequestMapping(path = "/registro", method = RequestMethod.POST)
	@Transactional
	public ModelAndView registroPost(@ModelAttribute Taller taller) {

		taller.getUsuario().setRol("taller");
		servicioLogin.guardarUsuario(taller.getUsuario());
		servicioTaller.crearTaller(taller);

		return new ModelAndView("redirect:/login");
	}

	@RequestMapping(path = "/buscarLocalidades", method = RequestMethod.GET)
	@Transactional
	public @ResponseBody List<Localidad> buscarLocalidades(@RequestParam Long provinciaId) {
		List<Localidad> localidades = new ArrayList<>();
		Provincia provincia = new Provincia();

		provincia.setId(provinciaId);

		localidades.addAll(servicioLocalidad.buscarLocalidadesPorProvincia(provincia));

		return localidades;
	}

	@RequestMapping(path = "/filtro", method = RequestMethod.GET)
	@Transactional
	public ModelAndView filtrarTalleres(@RequestParam Long dniCliente) {
		ModelMap modelo = new ModelMap();

		modelo.addAttribute("especialidades", Especialidad.values());
		modelo.addAttribute("provincias", servicioLocalidad.consultarProvincias());
		modelo.addAttribute("dniCliente", dniCliente);

		return new ModelAndView("filtroTalleres", modelo);
	}

	@RequestMapping(path = "/filtrado", method = RequestMethod.GET)
	@Transactional
	public ModelAndView listarTalleresFiltrados(@RequestParam(required = false) Long provincia, @RequestParam(required = false) Long localidad,
			@RequestParam String especialidad, @RequestParam Long dniCliente) {
		ModelMap modelo = new ModelMap();

			
		Localidad localidadrtdo = localidad != null ? servicioLocalidad.buscarLocalidadPorId(localidad) : null;


		modelo.addAttribute("talleres",
				servicioTaller.filtrarTalleres(localidadrtdo, Especialidad.valueOf(especialidad)));

		modelo.addAttribute("dniCliente", dniCliente);

		return new ModelAndView("listados/talleresFiltrados", modelo);
	}

	@RequestMapping(path = "/homeTaller", method = RequestMethod.GET)
	public ModelAndView irAlHomeTaller(HttpServletRequest request) {
		Taller taller = (Taller) request.getSession().getAttribute("taller");

		if (taller != null) {
			ModelMap modelo = new ModelMap();
			modelo.put("taller", taller);

			return new ModelAndView("homeTaller", modelo);
		} else {
			return new ModelAndView("redirect:/login");
		}
	}

	@RequestMapping(path = "/modificarTaller", method = RequestMethod.GET)
	@Transactional
	public ModelAndView modificarTaller(HttpServletRequest request) {
		Taller taller = (Taller) request.getSession().getAttribute("taller");

		if (taller != null) {
			ModelMap modelo = new ModelMap();

			modelo.put("taller", servicioTaller.buscarTallerPorId(taller.getId()));
			modelo.put("provincias", servicioLocalidad.consultarProvincias());
			modelo.put("localidades",
					servicioLocalidad.buscarLocalidadesPorProvincia(taller.getLocalidad().getProvincia()));

			return new ModelAndView("formularios/modificarTaller", modelo);
		} else {

			return new ModelAndView("redirect:/login");
		}
	}

	@RequestMapping(path = "/modificarTaller", method = RequestMethod.POST)
	@Transactional
	public ModelAndView modificarTaller(HttpServletRequest request, @ModelAttribute Taller taller) {
		Usuario usuarioLogueado = (Usuario) request.getSession().getAttribute("usuario");

		if (usuarioLogueado != null) {
			ModelMap modelo = new ModelMap();
			taller.setLocalidad(servicioLocalidad.buscarLocalidadPorId(taller.getLocalidad().getId()));

			servicioTaller.update(taller);

			modelo.put("taller", taller);

			return new ModelAndView("homeTaller", modelo);
		} else {

			return new ModelAndView("redirect:/login");
		}
	}

	public void setServicioTaller(ServicioTaller servicio) {
		this.servicioTaller = servicio;
	}

}
