package dam.ad.uf1;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LeerArchivoBinario {

	public static void main(String[] args) {
		//Hay que recordar las posiciones de los datos
		//Si primero he escrito un int debo leer un int primero
		File archivo = new File("Ficheros", "ejemplo.dat");
		
		if(!archivo.exists()) {
			System.out.println("El archivo no existe");
			return;
		}
		
		try {
			FileInputStream fis = new FileInputStream(archivo);
			DataInputStream dis = new DataInputStream(fis);
			
			//Leer datos en el mismo orden que fueron escritos
			int entero = dis.readInt(); //Leer un entero
			double decimal = dis.readDouble(); //Leer un double
			String cadena = dis.readUTF(); //Leer un String
			
			//Escribimos por consola el resultado
			System.out.println("Entero: " + entero);
			System.out.println("Decimal: " + decimal);
			System.out.println("String: " + cadena);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
