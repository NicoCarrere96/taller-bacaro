package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.test.web.client.RequestMatcher;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Orden;
import ar.edu.unlam.tallerweb1.modelo.taller.Factura;
import ar.edu.unlam.tallerweb1.modelo.taller.OrdenRepuesto;
import ar.edu.unlam.tallerweb1.servicios.ServicioOrden;
import ar.edu.unlam.tallerweb1.servicios.ServicioRepuesto;

@Controller
@RequestMapping(path = "/factura")
public class ControladorFactura {
	
	@Inject
	private ServicioOrden servicioOrden;
	@Inject
	private ServicioRepuesto servicioRepuesto;
	
	@RequestMapping(path = "/generarFactura", method = RequestMethod.GET)
	@Transactional
	// /factura/generarFactura?ordenId=
	public ModelAndView crearFactura(@RequestParam Long ordenId) {
		ModelMap modelo = new ModelMap();
		Factura factura = new Factura();
		Orden ordenBuscada = servicioOrden.consultarOrdenPorId(ordenId);
		List<OrdenRepuesto> listaRepuestos = servicioRepuesto.consultarRepuestosPorOrden(ordenBuscada);
		
		factura.setOrden(ordenBuscada);
		
		for(OrdenRepuesto repuesto : listaRepuestos){
			factura.setTotal(factura.getTotal() + (repuesto.getCantidad() * repuesto.getRepuesto().getPrecio()));
		}
		
		modelo.put("factura", factura);
		
		return new ModelAndView("factura", modelo);
		
	}
}
