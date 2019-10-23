package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.TurnoDao;
import ar.edu.unlam.tallerweb1.modelo.cliente.DiaDeAtencion;
import ar.edu.unlam.tallerweb1.modelo.cliente.Reserva;
import ar.edu.unlam.tallerweb1.modelo.cliente.Turno;

@Service("servicioTurno")
@Transactional 
public class ServicioTurnoImpl implements ServicioTurno{

    @Inject
	private TurnoDao turnoDao;
    
    @Override
	public List<DiaDeAtencion> consultarDiaDeAtencion(){
		return turnoDao.consultarDiaDeAtencionDao();
	}
    
    @Override
	public DiaDeAtencion obtenerDiaDeAtencion(Long diaDeAtencionId){
		return turnoDao.obtenerDiaDeAtencion(diaDeAtencionId);
	}

	@Override
	public List<Turno> listaDeTurnos(Long diaDeAtencionId){
		return turnoDao.listaDeTurnosDao(diaDeAtencionId);
	}


	
	@Override
	public List<Date> obtenerHorariosOcupados(Date fecha){
		// setear la hora a 00:00:00 para q coincidan las fechas exactamente en el criteria 
		Calendar fechaC = new GregorianCalendar();
		fechaC.setTime(fecha);
		fechaC.add(Calendar.MONTH, -1);
		fechaC.set(Calendar.HOUR, 00);
		fechaC.set(Calendar.MINUTE, 00);
		fechaC.set(Calendar.SECOND,	00);
		
		
		
		fecha = fechaC.getTime();
		System.out.println("la fecha q se va a pasar al dao es "+fecha);
		System.out.println("la fechaC q se va a pasar al dao es "+fechaC.getTime());
		
//		List<Date> turnos = 
//		System.out.println("turnooooo : "+turnos);
//		List<Date> horarios = new ArrayList<>();
		return turnoDao.obtenerHorariosOcupadosDao(fecha) ;
	}
	
	
	
//	fechas de hoy a dos meses 
	@Override
	public List<Date> consultarFechaDeElDiaSeleccionadoADosMeses(Long diaDeAtencionId){
			
		DiaDeAtencion dia = turnoDao.obtenerDiaDeAtencion(diaDeAtencionId);
		dia.getDia() ; // dia de atencion , ejemplo LUNES
		List<Date> listResultado = new ArrayList<Date>();
					
			
		// https://www.discoduroderoer.es/clase-calendar-en-java/
		// https://dosideas.com/wiki/Fechas_En_Java
			
		Calendar inicioGC = GregorianCalendar.getInstance();
		Calendar finGC = GregorianCalendar.getInstance();
		finGC.add(Calendar.MONTH,2);
			
		
		int diaSemana = 0;
			
		if(dia.getDia().equalsIgnoreCase("lunes")) {
			diaSemana = Calendar.MONDAY;		
		}else if (dia.getDia().equalsIgnoreCase("martes")){
			diaSemana = Calendar.TUESDAY;
		}else if (dia.getDia().equalsIgnoreCase("miercoles")){
			diaSemana = Calendar.WEDNESDAY;
		}else if (dia.getDia().equalsIgnoreCase("jueves")){
			diaSemana = Calendar.THURSDAY;
		}else if (dia.getDia().equalsIgnoreCase("viernes")){
			diaSemana = Calendar.FRIDAY;
		}else if (dia.getDia().equalsIgnoreCase("sabado")){
			diaSemana = Calendar.SATURDAY;
		}else if (dia.getDia().equalsIgnoreCase("domingo")){
			diaSemana = Calendar.SUNDAY;
		}
			
		inicioGC.set(Calendar.DAY_OF_WEEK, diaSemana);

			
		// fechas de hoy a dos meses 
		while ( inicioGC.before(finGC) ) {
			inicioGC.add(Calendar.DAY_OF_WEEK,7 ); 	
			listResultado.add(inicioGC.getTime());
		}
			
			
		return listResultado;
	}
	
	


	@Override
	public List<Date> obtenerHorariosPosibles(Date fecha, Long diaDeAtencionId){
						 
		
		Calendar fechaC = new GregorianCalendar();
		fechaC.setTime(fecha);
		fechaC.add(Calendar.MONTH, -1);
		
//		System.out.println("FECHA PASADA POR PARAMETRO: " + fechaC.getTime());
		
		DiaDeAtencion dia = turnoDao.obtenerDiaDeAtencion(diaDeAtencionId); 
		dia.getHoraAtencionInicio(); 
		dia.getHoraAtencionFinalizacion(); 
		
	
		Reserva reserva = dia.getReserva() ;
		reserva.getDuracion(); 
		
		Turno miTurno = new Turno(); 
		miTurno.setFechaTurno(fecha);
		miTurno.setDiaDeAtencion(dia);
		miTurno.setHoraTurno(dia.getHoraAtencionInicio());
	
//		Turno turnoConhoraDao = new Turno();
		
//		System.out.println("hora de atencion inicia" +dia.getHoraAtencionInicio());
//		System.out.println("fecha del turno"+miTurno.getFechaTurno());
//		System.out.println("hora del turno"+miTurno.getHoraTurno());
		
		// agregas a la lista turno
		List<Date> listHorariosPosibles = new ArrayList<>();
		listHorariosPosibles.add(miTurno.getHoraTurno());
		

		Calendar fechaDesde = new GregorianCalendar();
		fechaDesde.setTime(miTurno.getHoraTurno());
		
		// agregar una fecha de fin para que el bucle termine en el mismo dia 
		Calendar fechaHasta = new GregorianCalendar();
		fechaHasta.setTime(dia.getHoraAtencionFinalizacion());
	
//		System.out.println("/n /n");
//		System.out.println("fecha desde: "+fechaDesde.getTime());
//		System.out.println("fecha hasta: "+fechaHasta.getTime());
//		List<Turno> horariosOcupados = turnoDao.obtenerHorariosOcupadosDao(miTurno);
//		System.out.println("horarios ocupados desde el DAO" + horariosOcupados);
		
		while (fechaHasta.after(fechaDesde)) {

			fechaDesde.add(Calendar.MINUTE, reserva.getDuracion());
			
			miTurno.setHoraTurno(fechaDesde.getTime());
		
			listHorariosPosibles.add(miTurno.getHoraTurno());
			
		}
	
		
		
		
		
//		listHorariosPosibles.removeAll(horariosOcupados);


		return listHorariosPosibles;
	}



	@Override
	public void guardarTurno(Turno turno) {
		 turnoDao.saveTurnoDao(turno);
	}



}
