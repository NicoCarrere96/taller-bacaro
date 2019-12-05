package ar.edu.unlam.tallerweb1.servicios;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.inject.Inject;
import org.springframework.stereotype.Service;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import ar.edu.unlam.tallerweb1.dao.OrdenDao;
import ar.edu.unlam.tallerweb1.modelo.Orden;
import ar.edu.unlam.tallerweb1.modelo.cliente.Reserva;
import ar.edu.unlam.tallerweb1.modelo.taller.OrdenRepuesto;
import ar.edu.unlam.tallerweb1.utils.EstadoReserva;

@Service("servicioOrden")
public class ServicioOrdenImpl implements ServicioOrden {

	@Inject
	OrdenDao ordenDao;

	@Override
	public void guardarOrden(Orden orden) {
		ordenDao.guardarOrden(orden);

	}

	@Override
	public List<Orden> consultarOrdenes() {
		return ordenDao.consultarOrdenes();
	}

	@Override
	public Orden consultarOrdenPorId(Long id) {
		return ordenDao.consultarOrdenPorId(id);
	}
	
	

	@Override
	public Orden consultarOrdenPorReserva(Reserva reserva) {
		return ordenDao.consultarOrdenPorReserva(reserva);
	}

	@Override
	public void actualizarOrden(Orden orden) {
		orden.getReserva().setEstado(EstadoReserva.PRESUPUESTADA);
	}

	@Override
	public void aprobarOrden(Orden orden) {
		orden.getReserva().setEstado(EstadoReserva.APROBADA);

	}

	@Override
	public void rechazarOrden(Orden orden) {
		orden.getReserva().setEstado(EstadoReserva.RECHAZADA);

	}

	@Override
	public void modificarOrden(Orden orden) {
		orden.getReserva().setEstado(EstadoReserva.PRESUPUESTADA);

	}

	@Override
	public Document createPDF(Orden orden, List<OrdenRepuesto> ordRepList) {
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream("/tmp/factura-" + orden.getId()+".pdf"));
			document.open();
			Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN, 16, BaseColor.BLACK);
			Paragraph factura = new Paragraph("Factura Nro: " + orden.getId(), font);
			Paragraph taller = new Paragraph("Taller: " + orden.getReserva().getTaller().getNombreDelTaller(), font);
			Paragraph manoDeObra = new Paragraph(
					"Mano de obra: $" + (orden.getHorasDeTrabajo() * orden.getReserva().getTaller().getManoDeObra()),
					font);
			Paragraph detalle = new Paragraph("Detalle: ", font);
			
			document.add(factura);
			document.add(taller);
			document.add(manoDeObra);
			document.add(detalle);

			PdfPTable table = new PdfPTable(4);
			table.addCell("Repuesto");
			table.addCell("Precio U.");
			table.addCell("Cantidad");
			table.addCell("Precio Total");

			for (OrdenRepuesto ordRep : ordRepList) {
				Double precioTotal = ordRep.getRepuesto().getPrecio() * ordRep.getCantidad();
				table.addCell(ordRep.getRepuesto().getNombre());
				table.addCell(ordRep.getRepuesto().getPrecio().toString());
				table.addCell(ordRep.getCantidad().toString());
				table.addCell(precioTotal.toString());
			}
			
			document.add(table);
			
			document.add(new Paragraph("Total: $" + orden.getTotal(), font));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}

		document.close();
		
		return document;

	}

	@Override
	public byte[] obtenerFactura(Long idReserva) {
		try {
			return Files.readAllBytes(Paths.get("/tmp/factura-" + idReserva +".pdf"));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
