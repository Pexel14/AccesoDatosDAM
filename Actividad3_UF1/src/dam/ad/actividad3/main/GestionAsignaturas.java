package dam.ad.actividad3.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import dam.ad.actividad3.pojos.Asignatura;

public class GestionAsignaturas {

	static ArrayList<Asignatura> listaAsignatura;
	static Scanner sc;
	
	public static void main(String[] args) {
		listaAsignatura = new ArrayList<Asignatura>();
		sc = new Scanner(System.in);
		
		int opcion = 0;
		
		do {
			System.out.println("\nElije una opcion");
			System.out.println("1. Añadir asignatura");
			System.out.println("2. Ver Asignaturas");
			System.out.println("3. Salir");
			
			try {
				opcion = Integer.parseInt(sc.nextLine());
				
				switch (opcion) {
				case 1:
					aniadirAsignatura();
					break;
				case 2:
					verAsignaturas();
					break;
				case 3:
					System.out.println("Saliendo...");
					break;
				default:
					System.out.println("Debe ser un numero entre 1 y 3");
					break;
				}
				
			} catch (NumberFormatException e) {
				System.out.println("Debe introducir un numero");
			}
			
		} while(opcion != 3);
		
	}

	private static void verAsignaturas() {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("listaAsignaturas.dat"));
			boolean seguir = true;
			
			while(seguir) {
				try {
					Asignatura asig = (Asignatura) ois.readObject();
					System.out.println(asig);
				} catch (Exception e) {
					seguir = false;
				}
				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void aniadirAsignatura() {
		int codigo;
		String nombre;
		String profesor;
		ObjectOutputStream oos;
		int numHoras;
		
		for (int i = 0; i < 5; i++) {
			try {
				System.out.print("Codigo de la asignatura: ");
				codigo = Integer.parseInt(sc.nextLine());
				
				System.out.print("Nombre: ");
				nombre = sc.nextLine();
				
				System.out.print("Profesor: ");
				profesor = sc.nextLine();			
				
				try {
					System.out.print("Numero de horas: ");
					numHoras = Integer.parseInt(sc.nextLine());
					
					Asignatura asig = new Asignatura(codigo, nombre, profesor, numHoras);
					listaAsignatura.add(asig);
					
					System.out.println("\nAsignaturas añadida\n");
					
				}catch (NumberFormatException e) {
					System.out.println("El numero de horas debe ser un entero");
				}
				
			} catch (NumberFormatException e) {
				System.out.println("El codigo debe ser un entero");
			}
		}
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream("listaAsignaturas.dat"));
			for(Asignatura asignatura : listaAsignatura) {
				oos.writeObject(asignatura);							
			}
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
