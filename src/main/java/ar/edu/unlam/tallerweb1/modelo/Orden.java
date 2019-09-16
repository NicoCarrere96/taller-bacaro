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
import javax.persistence.ManyToOne;

import ar.edu.unlam.tallerweb1.modelo.taller.Repuesto;
import ar.edu.unlam.tallerweb1.modelo.taller.Taller;

@Entity
public class Orden {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long idReserva;
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
	public Long getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(Long idReserva) {
		this.idReserva = idReserva;
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

	
}
