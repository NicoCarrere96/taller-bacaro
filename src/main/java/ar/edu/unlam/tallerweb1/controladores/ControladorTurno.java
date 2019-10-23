package ar.edu.unlam.tallerweb1.controladores;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.cliente.DiaDeAtencion;
import ar.edu.unlam.tallerweb1.modelo.cliente.Reserva;
import ar.edu.unlam.tallerweb1.modelo.cliente.Turno;
import ar.edu.unlam.tallerweb1.servicios.ServicioReserva;
import ar.edu.unlam.tallerweb1.servicios.ServicioTurno;

@Controller
public class ControladorTurno {
	@Inject
	private ServicioTurno servicioTurno;
	
	@Inject
	private ServicioReserva servicioReserva;
	
	@RequestMapping(path="/fechas/{diaDeAtencionId}") 
	public ModelAndView irAConsultarFecha(@PathVariable Long diaDeAtencionId) {
		
		
		ModelMap model =new ModelMap();
		List<Date> fechasADosMeses = servicioTurno.consultarFechaDeElDiaSeleccionadoADosMeses(diaDeAtencionId);
		
		model.put("fechas",fechasADosMeses);
		model.put("diaDeAtencion", diaDeAtencionId);
		
		
		return new ModelAndView ("buscarFechas",model);
	}
	
	
	
	
	@RequestMapping(path="/horarios/{dia}/{mes}/{anio}/{diaDeAtencionId}") 
	public ModelAndView irAConsultarHorarios(
			@PathVariable int dia,
			@PathVariable int mes,
			@PathVariable int anio,
			@PathVariable Long diaDeAtencionId ,HttpServletRequest request) {
		
//		Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
		
		Calendar fechaGC = new GregorianCalendar();
		fechaGC.set(Calendar.DATE, dia);
		fechaGC.set(Calendar.MONTH, mes);
		fechaGC.set(Calendar.YEAR, anio);
		
		Date fecha = fechaGC.getTime();
		
		
		ModelMap model =new ModelMap();
		List<Date> listHorariosPosibles = servicioTurno.obtenerHorariosPosibles(fecha, diaDeAtencionId);

		
		
		
		model.put("horarios", listHorariosPosibles);
		
		fechaGC.add(Calendar.MONTH, -1);
		fechaGC.set(Calendar.HOUR, 00);
		fechaGC.add(Calendar.MINUTE,00);
		fechaGC.add(Calendar.SECOND,00);
		fecha = fechaGC.getTime();
		model.put("fechaTurno", fecha);
		
		DiaDeAtencion diaDeAtencion = servicioTurno.obtenerDiaDeAtencion(diaDeAtencionId);
		
		
		Turno miTurno = new Turno();
		miTurno.setDiaDeAtencion(diaDeAtencion);
		model.put("turno", miTurno);		
		model.put("diaDeAtencion", diaDeAtencion);
		
				
		return new ModelAndView ("buscarHorarios",model);
	}
	
	@RequestMapping(path = "/validarTurno", method = RequestMethod.POST)
	@Transactional
	public ModelAndView guardarTurno(@ModelAttribute("Reserva") Reserva reserva) {
		
		ModelMap model = new ModelMap();
         servicioReserva.guardarReserva(reserva);
         model.put("aviso", "Creacion Exitosa");
		
		
		return new ModelAndView("repuestos/mensaje",model);
		
	}
	

}

