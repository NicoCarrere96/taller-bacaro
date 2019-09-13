package ar.edu.unlam.tallerweb1.modelo.cliente;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vehiculo {
    @Id
    private String patente;
    private Cliente cliente;
    private String color;
    private String marca;
    private String modelo;

    public Vehiculo(Cliente cliente, String patente, String color, String marca, String modelo) {
        this.cliente = cliente;
        this.patente = patente;
        this.color = color;
        this.marca = marca;
        this.modelo = modelo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
