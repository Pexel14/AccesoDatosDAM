package dam.ad.practica1.javabeans;

public class Clientes {
	private String nombre;
	private String apellido;
	private String email;
	private String direccion;
	private String fechaAlta;
	private String provincia;
	private String ciudad;
	
	public Clientes(String nombre, String apellido, String email, String direccion, String fechaAlta, String provincia,
			String ciudad) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.direccion = direccion;
		this.fechaAlta = fechaAlta;
		this.provincia = provincia;
		this.ciudad = ciudad;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getEmail() {
		return email;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getFechaAlta() {
		return fechaAlta;
	}

	public String getProvincia() {
		return provincia;
	}

	public String getCiudad() {
		return ciudad;
	}

	@Override
	public String toString() {
		return nombre + ", " + email + ", Direccion: " + direccion 
				+ ", Fecha Alta: " + fechaAlta + ", Provincia: " + provincia + ", Ciudad: " + ciudad;
	}
	
	
	
}
