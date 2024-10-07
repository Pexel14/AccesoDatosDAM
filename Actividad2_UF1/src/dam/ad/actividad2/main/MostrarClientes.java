package dam.ad.actividad2.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import dam.ad.actividad2.pojos.Cliente;

public class MostrarClientes {

	public static void main(String[] args) {
		
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("listaClientes.dat"));
			boolean seguir = true;
			
			while(seguir) {
				try {
					Cliente cliente = (Cliente) ois.readObject();
					System.out.println(cliente);
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

}
