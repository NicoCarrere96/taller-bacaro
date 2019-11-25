package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.cliente.Cliente;
import ar.edu.unlam.tallerweb1.servicios.ServicioCliente;

@Controller
@RequestMapping(path = "/cliente")
public class ControladorCliente {
	
	@Inject
	private ServicioCliente servicioCliente;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView mostrarFormBuscaCliente() {
		ModelMap modelo = new ModelMap();
		
		modelo.addAttribute("cliente", new Cliente());
		
		return new ModelAndView("formularios/cliente", modelo);
	}
	
	@RequestMapping(path = "/buscarCliente", method = RequestMethod.POST)
	@Transactional
	public ModelAndView buscaCliente(@ModelAttribute Cliente cliente) {
		ModelMap modelo = new ModelMap();
		Cliente clienteEncontrado = servicioCliente.consultarClientePorDni(cliente.getDni());
		
		if (clienteEncontrado != null) {
			modelo.addAttribute("cliente", clienteEncontrado);
			modelo.addAttribute("encontrado", true);
		} else {
			modelo.addAttribute("cliente", cliente);
			modelo.addAttribute("encontrado", false);
		}
		
		return new ModelAndView("formularios/cliente", modelo);
	}
	
	@RequestMapping(path = "/guardarCliente", method = RequestMethod.POST)
	@Transactional
	public ModelAndView guardaCliente(@ModelAttribute Cliente cliente) {
		
		servicioCliente.guardarCliente(cliente);
		
		return new ModelAndView("redirect:/reserva/cliente?dni="+ cliente.getDni());
	}
	public void setServicioCliente(ServicioCliente servicio) {
		this.servicioCliente = servicio;		
	}
}
