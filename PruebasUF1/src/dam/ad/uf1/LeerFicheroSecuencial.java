package dam.ad.uf1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeerFicheroSecuencial {
	
	public static void main(String[] args) {
		//Ruta del archivo a leer
		String rutaArch = "Ficheros/ejemplo.txt";
		
		//Leer el archivo de forma secuencial
		try {
			BufferedReader lector = new BufferedReader(new FileReader(rutaArch));
			String linea;
			
			while((linea = lector.readLine()) != null) { //Cuando no haya mas lineas para
				System.out.println(linea); //Imprime cada linea del archivo
			}
		} catch (FileNotFoundException e) {
			System.out.println("No se ha encontrado el archivo");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Ha ocurrido un error inseperado");
			e.printStackTrace();
		}
	}
}
