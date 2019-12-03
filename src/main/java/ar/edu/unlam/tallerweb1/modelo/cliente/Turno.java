package ar.edu.unlam.tallerweb1.modelo.cliente;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import ar.edu.unlam.tallerweb1.modelo.taller.Taller;



@Entity
public class Turno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	

	private String fecha;
	private String horario;
	private Integer cantidad;
	
	@ManyToOne
	private Taller taller;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Taller getTaller() {
		return taller;
	}
	public void setTaller(Taller taller) {
		this.taller = taller;
	}

}
