package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import ar.edu.unlam.tallerweb1.modelo.cliente.Reserva;

@Entity
public class Orden {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	private Reserva reserva;
	private Integer horasDeTrabajo;
//	@ManyToMany
//	@JoinTable(name = "orden_repuesto",     
//		joinColumns = @JoinColumn(name = "orden_id"),
//	    inverseJoinColumns = @JoinColumn(name = "repuesto_id"))
//	private List<Repuesto> repuestos = new ArrayList<Repuesto>();
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
//	public List<Repuesto> getRepuestos() {
//		return repuestos;
//	}
//	public void setRepuestos(List<Repuesto> repuestos) {
//		this.repuestos = repuestos;
//	}
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
	
	public void calcularTotal() {
		this.total = this.horasDeTrabajo * this.reserva.getTaller().getManoDeObra();
//		for (Repuesto repuesto : this.repuestos) {
//			this.total += repuesto.getPrecio();
//			repuesto.setStock(repuesto.getStock()-1);
//		}
	}
}
