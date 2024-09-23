package dam.ad.practica1.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import dam.ad.practica1.javabeans.Clientes;

public class GestionClientes {

	static final String RUTA_DIR = "Clientes";
	static final String RUTA_ARCH = "Clientes/ListaClientes.txt";
	
	static ArrayList<Clientes> listaClientes;
	static Scanner sc;
	static File archivo;
		
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		listaClientes = new ArrayList<Clientes>();
		archivo = new File(RUTA_ARCH);
		
		int opcion = 0;

		do {
			System.out.println("\nElija una opcion");
			System.out.println("1. Añadir Cliente");
			System.out.println("2. Ver Clientes");
			System.out.println("3. Salir");
			
			try {
				opcion = Integer.parseInt(sc.nextLine());
				
				if(opcion < 1 || opcion > 3) {
					System.out.println("\nEl numero debe estar entre 1 y 3");
				} else {
					switch (opcion) {
					case 1:
						aniadirClientes();
						break;
						
					case 2:
						verClientes();
						break;
						
					case 3:
						System.out.println("Saliendo");
						break;
					}
					
				}
				
			} catch (NumberFormatException e) {
				System.out.println("\nLa opcion debe ser un numero");
			}
			
		} while(opcion != 3);
		
	}

	private static void verClientes() {
		if(archivo.exists()) {
			try {
				BufferedReader lector = new BufferedReader(new FileReader(archivo));
				String linea;
				
				while((linea = lector.readLine()) != null) {
					String [] datos = linea.split(",");
					listaClientes.add(new Clientes(datos[0], "", datos[1], datos[2], datos[3], datos[4], datos[5]));
				}
				lector.close();
				mostrarClientes();
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Error al cargar");
				e.printStackTrace();
			}
		} else {
			System.out.println("El archivo no existe");
		}
	}

	private static void mostrarClientes() {
		System.out.println("\nLISTA CLIENTES\n");
		
		for (Clientes clientes : listaClientes) {
			System.out.println(clientes);
		}
		listaClientes.clear();
	}

	private static void aniadirClientes() {
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
		
		Clientes cliente = new Clientes(nombre, apellido, email, direccion, fechaAlta, provincia, ciudad);
		
		System.out.println("\nCliente Añadido");
		
		if(archivo.exists()) {
			try {
				insertarCliente(cliente);
				
			} catch (IOException e) {
				System.out.println("Ha surgido un problema inesperado");
				e.printStackTrace();
			}
		} else {
			File carpeta = new File(RUTA_DIR);
			
			if(!carpeta.exists()) {
				carpeta.mkdir();	
			}
			try {
				archivo.createNewFile();
				insertarCliente(cliente);
				
			} catch (IOException e) {
				System.out.println("Ha surgido un problema inesperado");
				e.printStackTrace();
			}
		}
	}

	private static void insertarCliente(Clientes cliente) throws IOException {
		BufferedWriter escritor = new BufferedWriter(new FileWriter(RUTA_ARCH, true));
		
		escritor.write(cliente.toString());
		escritor.newLine();
		escritor.close();
	}

}
