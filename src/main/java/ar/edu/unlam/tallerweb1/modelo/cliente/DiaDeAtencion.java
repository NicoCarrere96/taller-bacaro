package ar.edu.unlam.tallerweb1.modelo.cliente;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import ar.edu.unlam.tallerweb1.modelo.taller.Taller;

@Entity
public class DiaDeAtencion {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String dia;
	private Date horaAtencionInicio;
	private Date horaAtencionFinalizacion;
	
	@ManyToOne
	private Reserva reserva;
	
	@ManyToOne
	private Taller taller;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public Date getHoraAtencionInicio() {
		return horaAtencionInicio;
	}

	public void setHoraAtencionInicio(Date horaAtencionInicio) {
		this.horaAtencionInicio = horaAtencionInicio;
	}

	public Date getHoraAtencionFinalizacion() {
		return horaAtencionFinalizacion;
	}

	public void setHoraAtencionFinalizacion(Date horaAtencionFinalizacion) {
		this.horaAtencionFinalizacion = horaAtencionFinalizacion;
	}
	
	

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public Taller getTaller() {
		return taller;
	}

	public void setTaller(Taller taller) {
		this.taller = taller;
	}
	
	

}
