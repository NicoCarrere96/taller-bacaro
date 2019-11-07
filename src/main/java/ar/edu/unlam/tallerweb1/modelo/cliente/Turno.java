package ar.edu.unlam.tallerweb1.modelo.cliente;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Turno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "fecha", columnDefinition="DATETIME") @Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	 
	private Date horaTurno;
	private Date fechaTurno;
	
	@ManyToOne
	private DiaDeAtencion diaDeAtencion;
	


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getHoraTurno() {
		return horaTurno;
	}

	public void setHoraTurno(Date horaTurno) {
		this.horaTurno = horaTurno;
	}

	public Date getFechaTurno() {
		return fechaTurno;
	}

	public void setFechaTurno(Date fechaTurno) {
		this.fechaTurno = fechaTurno;
	}


	public DiaDeAtencion getDiaDeAtencion() {
		return diaDeAtencion;
	}

	public void setDiaDeAtencion(DiaDeAtencion diaDeAtencion) {
		this.diaDeAtencion = diaDeAtencion;
	}

	

}
