package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mercadopago.resources.Preference;

import ar.edu.unlam.tallerweb1.modelo.Orden;
import ar.edu.unlam.tallerweb1.modelo.cliente.Cliente;
import ar.edu.unlam.tallerweb1.modelo.cliente.Reserva;
import ar.edu.unlam.tallerweb1.modelo.taller.OrdenRepuesto;
import ar.edu.unlam.tallerweb1.modelo.taller.Taller;
import ar.edu.unlam.tallerweb1.servicios.ServicioEnvioMail;
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
	@Inject
	private ServicioEnvioMail servicioEnvioMail;

	@RequestMapping(path = "/generarFactura", method = RequestMethod.GET)
	@Transactional
	public ModelAndView crearFactura(@RequestParam Long ordenId) {
		ModelMap modelo = new ModelMap();
		Orden ordenBuscada = servicioOrden.consultarOrdenPorId(ordenId);
		List<OrdenRepuesto> listaRepuestos = servicioRepuesto.consultarRepuestosPorOrden(ordenBuscada);
		Taller taller = ordenBuscada.getReserva().getTaller();
		Cliente cliente = ordenBuscada.getReserva().getCliente();
		ordenBuscada.setTotal(taller.getManoDeObra() * ordenBuscada.getHorasDeTrabajo());

		for (OrdenRepuesto repuesto : listaRepuestos) {
			ordenBuscada
					.setTotal(ordenBuscada.getTotal() + (repuesto.getCantidad() * repuesto.getRepuesto().getPrecio()));
		repuesto.getRepuesto().setStock(repuesto.getRepuesto().getStock() - repuesto.getCantidad());
		}
		ordenBuscada.getReserva().setEstado(EstadoReserva.FACTURADA);

		servicioReserva.guardarReserva(ordenBuscada.getReserva());
		servicioOrden.guardarOrden(ordenBuscada);
		servicioEnvioMail.enviarMail(ordenBuscada.getReserva(), cliente, taller, ordenBuscada);
		servicioOrden.createPDF(ordenBuscada, listaRepuestos);

		modelo.put("factura", ordenBuscada);
		modelo.put("listaRepuestos", listaRepuestos);

		return new ModelAndView("facturaGenerada", modelo);

	}

	@RequestMapping(path = "/generadaFactura", method = RequestMethod.GET)
	@Transactional
	public ModelAndView verFactura(@RequestParam Long reservaId) {
		ModelMap modelo = new ModelMap();
		Orden ordenBuscada = servicioOrden.consultarOrdenPorReserva(servicioReserva.buscarReservaPorId(reservaId));
		List<OrdenRepuesto> listaRepuestos = servicioRepuesto.consultarRepuestosPorOrden(ordenBuscada);

		Taller taller = ordenBuscada.getReserva().getTaller();
		Cliente cliente = ordenBuscada.getReserva().getCliente();
		ordenBuscada.setTotal(taller.getManoDeObra() * ordenBuscada.getHorasDeTrabajo());

		for (OrdenRepuesto repuesto : listaRepuestos) {
			ordenBuscada
					.setTotal(ordenBuscada.getTotal() + (repuesto.getCantidad() * repuesto.getRepuesto().getPrecio()));
		}
		ordenBuscada.getReserva().setEstado(EstadoReserva.FACTURADA);

		servicioReserva.guardarReserva(ordenBuscada.getReserva());
		servicioOrden.guardarOrden(ordenBuscada);

		Double orden = ordenBuscada.getTotal();
		modelo.put("factura", ordenBuscada);
		modelo.put("listaRepuestos", listaRepuestos);
		Preference preference = servicioPago.realizarPago(cliente, taller, orden);

		modelo.put("preference", preference);

		if (preference == null)
			return new ModelAndView("Error");
		ordenBuscada.getReserva().setEstado(EstadoReserva.PAGADA);
		
		return new ModelAndView("facturaGenerada2", modelo);

	}

	@RequestMapping(path = "/getPdf", method = RequestMethod.GET)
	@Transactional
	public ResponseEntity<byte[]> imprimirFactura(@RequestParam Long ordenId) {

		byte[] contents = null;
		contents = servicioOrden.obtenerFactura(ordenId);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType("application/pdf"));
		String filename = "factura-" + ordenId + ".pdf";
		headers.setContentDispositionFormData(filename, filename);
		headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
		ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(contents, headers, HttpStatus.OK);

		return response;

	}

	@RequestMapping(path = "/verFactura", method = RequestMethod.GET)
	@Transactional
	public ModelAndView verFactura(@RequestParam Long reservaId, HttpServletRequest request) {
		ModelMap modelo = new ModelMap();

		Reserva reserva = servicioReserva.buscarReservaPorId(reservaId);
		Orden ordenBuscada = servicioOrden.consultarOrdenPorReserva(reserva);
		List<OrdenRepuesto> listaRepuestos = servicioRepuesto.consultarRepuestosPorOrden(ordenBuscada);

		Boolean cliente = request.getSession().getAttribute("taller") != null ? false : true;

		modelo.put("factura", ordenBuscada);
		modelo.put("listaRepuestos", listaRepuestos);
		modelo.put("cliente", cliente);

		return new ModelAndView("facturaGenerada", modelo);

	}

	public void setServicioOrden(ServicioOrden servicioOrden) {
		this.servicioOrden = servicioOrden;
	}

	public void setServicioRepuesto(ServicioRepuesto servicioRepuesto) {
		this.servicioRepuesto = servicioRepuesto;
	}

	public void setServicioReserva(ServicioReserva servicioReserva) {
		this.servicioReserva = servicioReserva;
	}
	
	public void setServicioEnvioMail(ServicioEnvioMail servicioEnvioMail) {
		this.servicioEnvioMail = servicioEnvioMail;		
	}

	@RequestMapping(path = "/datosFacturacion", method = RequestMethod.GET)
	@Transactional
	public ModelAndView traerDatosFacturacion(HttpServletRequest request) {

		ModelMap modelo = new ModelMap();
		Taller taller = (Taller) request.getSession().getAttribute("taller");
		List<Reserva> reservas = servicioReserva.consultarReservasPorTaller(taller);
		List<Orden> ordenes = new ArrayList<Orden>();
		
		for (Reserva reserva : reservas) {
			Orden orden = servicioOrden.consultarOrdenPorReserva(reserva);
			
			if (orden != null && orden.getTotal() != null) {
				ordenes.add(orden);				
			}
		}
		
		modelo.put("reserva", reservas);
		modelo.put("ordenes", ordenes);
		modelo.put("taller", taller);

		return new ModelAndView("listados/datosFacturacion", modelo);

	}

}
