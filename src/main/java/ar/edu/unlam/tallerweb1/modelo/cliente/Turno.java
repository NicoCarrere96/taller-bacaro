package ar.edu.unlam.tallerweb1.modelo.cliente;

import ar.edu.unlam.tallerweb1.modelo.taller.Taller;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Turno {
    private Cliente cliente;
    private Taller taller;
    private Date dia;
    private String problema;

    public Turno() {
    }

    public Turno(Cliente cliente, Taller taller, Date dia, String problema) {
        this.cliente = cliente;
        this.taller = taller;
        this.dia = dia;
        this.problema = problema;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Taller getTaller() {
        return taller;
    }

    public void setTaller(Taller taller) {
        this.taller = taller;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }
}
