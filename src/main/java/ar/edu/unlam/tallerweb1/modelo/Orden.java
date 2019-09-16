package ar.edu.unlam.tallerweb1.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import ar.edu.unlam.tallerweb1.modelo.cliente.Reserva;
import ar.edu.unlam.tallerweb1.modelo.taller.Repuesto;

@Entity
public class Orden {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	private Reserva reserva;
	private Integer horasDeTrabajo;
	@ManyToMany
	@JoinTable(name = "orden_repuesto",     
		joinColumns = @JoinColumn(name = "orden_id"),
	    inverseJoinColumns = @JoinColumn(name = "repuesto_id"))
	private List<Repuesto> repuestos = new ArrayList<Repuesto>();
	private Double total;
	
	public Long getId() {
		return id;
	}
	public Integer getHorasDeTrabajo() {
		return horasDeTrabajo;
	}
	public void setHorasDeTrabajo(Integer horasDeTrabajo) {
		this.horasDeTrabajo = horasDeTrabajo;
	}
	public List<Repuesto> getRepuestos() {
		return repuestos;
	}
	public void setRepuestos(List<Repuesto> repuestos) {
		this.repuestos = repuestos;
	}
	public Reserva getReserva() {
		return reserva;
	}
	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
}
