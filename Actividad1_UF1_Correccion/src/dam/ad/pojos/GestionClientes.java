package dam.ad.pojos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import dam.ad.main.Cliente;

public class GestionClientes {
	
	//Declaro variables
	static ArrayList<Cliente> listaClientes;
	static Scanner sc;
	
	public static void main(String[] args) {
		listaClientes = new ArrayList<Cliente>();
		sc = new Scanner(System.in);
		
		boolean salir = false; //Variable salir para poder controlar la ejecucion mas tarde
		cargarClientes(); //Cargar clientes al inicio
		
		//Creo el menu para el usuario
		
		int opcion;
		
		while(!salir) {
			System.out.println("\nElija la opcion que desee");
			System.out.println("1. Añadir clientes");
			System.out.println("2. Ver clientes");
			System.out.println("3. Salir");
			
			try {
				opcion = Integer.parseInt(sc.nextLine());
				
				switch (opcion) {
				case 1:
					aniadirCliente();
					break;
				case 2:
					verClientes();
					break;
				case 3:
					System.out.println("Saliendo...");
					salir = true;
					sc.close();
					break;
				default:
					System.out.println("Opcion no valida");
					break;
				}
				
			} catch (NumberFormatException e) {
				System.out.println("Debe ser un numerico");
			}
			
		}
		
	}

	private static void verClientes() {
		System.out.println("LISTA DE CLIENTES");
		System.out.println("-----------------");
		
		for(Cliente cliente : listaClientes) {
			System.out.println(cliente);
		}
		
	}

	private static void aniadirCliente() {
		//Metodo par aañadir nuevos clientes por consola
		System.out.print("Nombre: ");
		String nombre = sc.nextLine();
		
		System.out.print("Apellido: ");
		String apellido = sc.nextLine();
		
		System.out.print("Email: ");
		String email = sc.nextLine();
		
		System.out.print("Direccion: ");
		String direccion = sc.nextLine();
		
		System.out.print("Fecha Alta: ");
		String fechaAlta = sc.nextLine();
		
		System.out.print("Provincia: ");
		String provincia = sc.nextLine();
		
		System.out.print("Ciudad: ");
		String ciudad = sc.nextLine();
		
		Cliente cliente = new Cliente(nombre, apellido, email, direccion, fechaAlta, provincia, ciudad);
		
		listaClientes.add(cliente);
		System.out.println("El cliente se ha añadido");
		
		//Creo la carpeta Ficheros si no existe
		File carpeta = new File("Ficheros");
		
		if(!carpeta.exists()) {
			carpeta.mkdir();
		}
		
		//Archivo dentro de la carpeta Ficheros
		File file = new File(carpeta, "clientes.txt"); //No es necesario el BufferedWriter lo crea
		
		//Guardar el cliente en el archivo de texto inmediatamente despues de añadirlo
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
			writer.write(cliente.getNombre() + ", " + cliente.getApellido() 
			+ ", " + cliente.getEmail() + ", " + cliente.getDireccion() + ", " + cliente.getFechaAlta() 
			+ ", " + cliente.getProvincia() + ", " + cliente.getCiudad());
			writer.newLine();
			writer.close();
		} catch (IOException e) {
			System.out.println("Error al crear el cliente");
			e.printStackTrace();
		}
		
	}

	private static void cargarClientes() {
		//Crear el directorio "Ficheros" si no existe
		File directorio = new File("Ficheros");
		
		if(!directorio.exists()) {
			System.out.println("No existe el directorio Ficheros");
			return;
		}
		
		//Archivo dentro de Ficheros
		File file = new File(directorio, "clientes.txt");
		
		if(!file.exists()) {
			System.out.println("El archivo clientes.txt no existe");
			return; //Evitamos que siga con el codigo
		}
		
		//Si el arhivo existe sigo cargando el arhivo para mostrar los clientes si el usuario lo pide
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String linea;
			
			while((linea = reader.readLine()) != null) {
				String [] datos = linea.split(",");
				Cliente cliente = new Cliente(datos[0], datos[1], datos[2], datos[3], datos[4], datos[5], datos[6]);
				listaClientes.add(cliente);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Ha habido un error");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Ha ocurrido un error al tratar de leer clientes.txt");
			e.printStackTrace();
		}
	}

}
