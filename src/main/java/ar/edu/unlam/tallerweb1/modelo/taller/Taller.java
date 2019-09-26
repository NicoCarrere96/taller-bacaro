package ar.edu.unlam.tallerweb1.modelo.taller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import ar.edu.unlam.tallerweb1.utils.Especialidad;


@Entity
public class Taller {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombreDelTaller;
	private String nombreDelDuenio;
	private String telefono;
	private String paginaWeb;
	private String calle;
	private Integer numero;
	@ManyToOne
	private Localidad localidad;
	@OneToOne
	@Cascade(CascadeType.ALL)
	private Usuario usuario;
	private Double manoDeObra;
	private Especialidad especialidad;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreDelTaller() {
		return nombreDelTaller;
	}

	public void setNombreDelTaller(String nombreDelTaller) {
		this.nombreDelTaller = nombreDelTaller;
	}

	public String getNombreDelDuenio() {
		return nombreDelDuenio;
	}

	public void setNombreDelDuenio(String nombreDelDuenio) {
		this.nombreDelDuenio = nombreDelDuenio;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getPaginaWeb() {
		return paginaWeb;
	}

	public void setPaginaWeb(String paginaWeb) {
		this.paginaWeb = paginaWeb;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Double getManoDeObra() {
		return manoDeObra;
	}

	public void setManoDeObra(Double manoDeObra) {
		this.manoDeObra = manoDeObra;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	

}
