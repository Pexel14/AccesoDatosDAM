package dam.ad.actividad2.main;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import dam.ad.actividad2.pojos.Cliente;

public class AlmacenarClientes {

	public static void main(String[] args) {
		Cliente[] clientes = { 
				new Cliente("Ana", "García", "ana.garcia@email.com", "Calle Mayor 5", "2023-05-20", "Madrid", "Madrid"), 
				new Cliente("Luis", "Pérez", "luis.perez@email.com", "Calle Sol 10", "2023-06-15", "Barcelona", "Barcelona"), 
				new Cliente("Laura", "Sánchez", "laura.sanchez@email.com", "Calle Luna 7", "2023-07-01", "Valencia", "Valencia"), 
				new Cliente("Carlos", "Romero", "carlos.romero@email.com", "Calle Estrella 22", "2023-08-20", "Sevilla", "Sevilla")
		};
		
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("listaClientes.dat"));
			
			for(Cliente cliente : clientes) {
				oos.writeObject(cliente);
			}
			System.out.println("Clientes guardados");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
