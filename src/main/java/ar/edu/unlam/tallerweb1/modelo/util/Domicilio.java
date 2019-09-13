package ar.edu.unlam.tallerweb1.modelo.util;

import javax.persistence.Entity;

@Entity
public class Domicilio {
    private String direccion;
    private Localidad localidad;

    public Domicilio(String direccion, Localidad localidad) {
        this.direccion = direccion;
        this.localidad = localidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }
}
