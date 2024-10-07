package dam.ad.practica6.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import dam.ad.practica6.pojos.LineaPedido;

public class LeerLineaPedidos {

	public static void main(String[] args) {
		leer();
	}

	private static void leer() {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Ficheros/lineaPedidos.dat"));
			boolean seguir = true;
			
			while(seguir) {
				
				try {
					LineaPedido lp = (LineaPedido) ois.readObject();
					System.out.println(lp);
					
				} catch (Exception e) {
					seguir = false;
				}
			}
			ois.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
