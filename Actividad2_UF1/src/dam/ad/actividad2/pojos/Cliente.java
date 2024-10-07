package dam.ad.actividad2.pojos;

import java.io.Serializable;

public class Cliente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nombre;
	private String apellido;
	private String email;
	private String direccion;
	private String fechaAlta;
	private String provincia;
	private String ciudad;
	
	public Cliente(String nombre, String apellido, String email, String direccion, String fechaAlta, String provincia,
			String ciudad) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.direccion = direccion;
		this.fechaAlta = fechaAlta;
		this.provincia = provincia;
		this.ciudad = ciudad;
	}

	@Override
	public String toString() {
		return "Cliente: " + nombre + " " + apellido + ", Email: " + email + ", Dirección: " + direccion 
				+ ", Fecha de alta: " + fechaAlta + "Provincia:"  + provincia + ", Ciudad: " + ciudad;
	}
	
	
	
}
