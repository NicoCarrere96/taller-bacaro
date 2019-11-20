package ar.edu.unlam.tallerweb1.modelo.cliente;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import ar.edu.unlam.tallerweb1.modelo.taller.Taller;
import ar.edu.unlam.tallerweb1.utils.EstadoReserva;

@Entity
public class Reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Taller taller;
	@ManyToOne
	private Cliente cliente;
	private String fecha;
	private String problema;
	private EstadoReserva estado;
	
	public Taller getTaller() {
		return taller;
	}
	public void setTaller(Taller taller) {
		this.taller = taller;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String getProblema() {
		return problema;
	}
	public void setProblema(String problema) {
		this.problema = problema;
	}
	public Long getId() {
		return id;
	}
	public EstadoReserva getEstado() {
		return estado;
	}
	public void setEstado(EstadoReserva estado) {
		this.estado = estado;
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

	
}
