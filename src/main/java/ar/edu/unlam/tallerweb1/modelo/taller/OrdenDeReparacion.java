package ar.edu.unlam.tallerweb1.modelo.taller;

import ar.edu.unlam.tallerweb1.modelo.cliente.Turno;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class OrdenDeReparacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date fecha;
    private Turno turno;


}
