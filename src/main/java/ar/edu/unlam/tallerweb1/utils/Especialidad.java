package ar.edu.unlam.tallerweb1.utils;

public enum Especialidad {
	GOMERIA("Gomeria", 0),
	MECANICA_GENERAL("Mecanica General", 1),
	LUBRICENTRO("Lubricentro", 2),
	CHAPA_Y_PINTURA("Chapa y Pintura", 3),
	ELECTRICIDAD("Electricidad", 4),
	SUSPENSION("Suspension", 5),
	ESCAPE("Escapes", 6);

	final String name;
	final int ordinal; 
	
	Especialidad(String name, int ordinal) {
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
