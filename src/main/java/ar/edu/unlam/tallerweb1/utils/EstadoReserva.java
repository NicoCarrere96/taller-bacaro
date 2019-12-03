package ar.edu.unlam.tallerweb1.utils;

public enum EstadoReserva{
	PENDIENTE("Pendiente", 0),
	PRESUPUESTADA("Presupuestada", 1),
	APROBADA("Aprobada", 2),
	RECHAZADA("Rechazada", 3),
	FACTURADA("Facturada", 4),
	PAGADA("Pagada", 5);

	final String name;
	final int ordinal; 
	
	EstadoReserva(String name, int ordinal) {
		this.name = name;
		this.ordinal = ordinal;
	}

	public String getName() {
		return name;
	}

	public int getOrdinal() {
		return ordinal;
	}
		
	
}
