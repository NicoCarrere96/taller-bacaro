package ar.edu.unlam.tallerweb1.modelo.taller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Taller {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombreDelTaller;
	private String nombreDelDuenio;
	private String calle;
	private String numero;
	private String lista;
	private String telefono;
	private String paginaWeb;
	@ManyToOne
	private Localidad localidad;
	@OneToOne
	private Usuario usuario;
	private Double manoDeObra;
	


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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
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

	public String getLista() {
		return lista;
	}

	public void setLista(String lista) {
		this.lista = lista;
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

	

}
