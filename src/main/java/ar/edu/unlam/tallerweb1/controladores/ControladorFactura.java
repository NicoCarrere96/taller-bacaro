package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;
import com.mercadopago.resources.Preference;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Orden;
import ar.edu.unlam.tallerweb1.modelo.cliente.Cliente;
import ar.edu.unlam.tallerweb1.modelo.taller.OrdenRepuesto;
import ar.edu.unlam.tallerweb1.modelo.taller.Taller;
import ar.edu.unlam.tallerweb1.servicios.ServicioOrden;
import ar.edu.unlam.tallerweb1.servicios.ServicioPago;
import ar.edu.unlam.tallerweb1.servicios.ServicioRepuesto;
import ar.edu.unlam.tallerweb1.servicios.ServicioReserva;
import ar.edu.unlam.tallerweb1.utils.EstadoReserva;

@Controller
@RequestMapping(path = "/factura")
public class ControladorFactura {
	
	@Inject
	private ServicioOrden servicioOrden;
	@Inject
	private ServicioRepuesto servicioRepuesto;
	@Inject
	private ServicioReserva servicioReserva;
	@Inject
	private ServicioPago servicioPago;
	
	@RequestMapping(path = "/generadaFactura", method = RequestMethod.GET)
	@Transactional
	public ModelAndView verFactura(@RequestParam Long ordenId) {
		ModelMap modelo = new ModelMap();
		Orden ordenBuscada = servicioOrden.consultarOrdenPorId(ordenId);
		List<OrdenRepuesto> listaRepuestos = servicioRepuesto.consultarRepuestosPorOrden(ordenBuscada);
		Taller taller = ordenBuscada.getReserva().getTaller();
		Cliente cliente = ordenBuscada.getReserva().getCliente();
		ordenBuscada.setTotal(taller.getManoDeObra() * ordenBuscada.getHorasDeTrabajo());
		
		for(OrdenRepuesto repuesto : listaRepuestos){
			ordenBuscada.setTotal(ordenBuscada.getTotal() + (repuesto.getCantidad() * repuesto.getRepuesto().getPrecio()));
		}
		ordenBuscada.getReserva().setEstado(EstadoReserva.FACTURADA);
		
		servicioReserva.guardarReserva(ordenBuscada.getReserva());
		servicioOrden.guardarOrden(ordenBuscada);
		Double orden = ordenBuscada.getTotal();
		modelo.put("factura", ordenBuscada);
		modelo.put("listaRepuestos", listaRepuestos);
		Preference preference = servicioPago.realizarPago(cliente,taller, orden);
		
		if (preference == null)
			return new ModelAndView("Error");
		modelo.put("preference", preference);
		return new ModelAndView("facturaGenerada2", modelo);
		
	}
	
}