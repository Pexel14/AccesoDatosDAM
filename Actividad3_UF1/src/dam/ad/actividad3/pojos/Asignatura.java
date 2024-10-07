package dam.ad.actividad3.pojos;

import java.io.Serializable;

public class Asignatura implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int codigo;
	private String nombre;
	private String profesor;
	private int numHoras;
	
	public Asignatura(int codigo, String nombre, String profesor, int numHoras) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.profesor = profesor;
		this.numHoras = numHoras;
	}

	@Override
	public String toString() {
		return "Codigo: " + codigo + ", nombre asignatura: " + nombre + ", profesor: " + profesor + ", numero de horas: "
				+ numHoras;
	}
	
}
