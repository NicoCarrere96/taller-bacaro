package ar.edu.unlam.tallerweb1.modelo.taller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.util.Domicilio;
import ar.edu.unlam.tallerweb1.modelo.util.Especialidad;

@Entity
public class Taller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Usuario usuario;
    private String nombreTaller;
    private String nombreDueno;
    private Domicilio domicilio;
    private String telefono;
    private String paginaWeb;
    private Especialidad especialidad;


    public Taller(Usuario usuario, String nombreTaller, String nombreDueno, Domicilio domicilio, String telefono, String paginaWeb, Especialidad especialidad) {
        this.usuario = usuario;
        this.nombreTaller = nombreTaller;
        this.nombreDueno = nombreDueno;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.paginaWeb = paginaWeb;
        this.especialidad = especialidad;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNombreTaller() {
        return nombreTaller;
    }

    public void setNombreTaller(String nombreTaller) {
        this.nombreTaller = nombreTaller;
    }

    public String getNombreDueno() {
        return nombreDueno;
    }

    public void setNombreDueno(String nombreDueno) {
        this.nombreDueno = nombreDueno;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
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

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }
}
