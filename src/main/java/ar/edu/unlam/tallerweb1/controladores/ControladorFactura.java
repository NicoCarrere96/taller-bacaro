package ar.edu.unlam.tallerweb1.controladores;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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

import ar.edu.unlam.tallerweb1.modelo.Orden;
import ar.edu.unlam.tallerweb1.modelo.cliente.Reserva;
import ar.edu.unlam.tallerweb1.modelo.taller.OrdenRepuesto;
import ar.edu.unlam.tallerweb1.servicios.ServicioOrden;
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

	@RequestMapping(path = "/generarFactura", method = RequestMethod.GET)
	@Transactional
	public ModelAndView crearFactura(@RequestParam Long ordenId) {
		ModelMap modelo = new ModelMap();
		Orden ordenBuscada = servicioOrden.consultarOrdenPorId(ordenId);
		List<OrdenRepuesto> listaRepuestos = servicioRepuesto.consultarRepuestosPorOrden(ordenBuscada);

		ordenBuscada.setTotal(ordenBuscada.getReserva().getTaller().getManoDeObra() * ordenBuscada.getHorasDeTrabajo());

		for (OrdenRepuesto repuesto : listaRepuestos) {
			ordenBuscada
					.setTotal(ordenBuscada.getTotal() + (repuesto.getCantidad() * repuesto.getRepuesto().getPrecio()));
		}
		ordenBuscada.getReserva().setEstado(EstadoReserva.FACTURADA);

		servicioReserva.guardarReserva(ordenBuscada.getReserva());
		servicioOrden.guardarOrden(ordenBuscada);

		modelo.put("factura", ordenBuscada);
		modelo.put("listaRepuestos", listaRepuestos);

		servicioOrden.createPDF(ordenBuscada, listaRepuestos);


		return new ModelAndView("facturaGenerada", modelo);

	}
	
	@RequestMapping(path = "/getPdf", method = RequestMethod.GET)
	@Transactional
	public ResponseEntity<byte[]> imprimirFactura(@RequestParam Long reservaId) {

		byte[] contents = null;
		try {
			contents = Files.readAllBytes(Paths.get("/temp/factura-" + reservaId +".pdf"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType("application/pdf"));
	    String filename = "factura-" + reservaId +".pdf";
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
}
