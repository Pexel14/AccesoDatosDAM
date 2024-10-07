package dam.ad.uf1;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class EscribirArchivoBinario {

	public static void main(String[] args) {
		//Indicar la ruta donde almacenar el archivo
		String carpeta = "Ficheros";
		
		//Creamos un objeto File para crear el fichero "ejemplo.dat" en binario
		File archivo = new File(carpeta, "ejemplo.dat");
		
		//Verificamos si el archivo existe
		if(archivo.exists()) {
			System.out.println("El archivo ya existe");
		} else {
			try {
				archivo.createNewFile();
				System.out.println("Archivo creado con exito");
				
			} catch (IOException e) {
				System.out.println("No se ha podido crear el fichero");
			}
		}
		
		//Escribir datos en el archivo binario de forma secuencial
		try {
			FileOutputStream fos = new FileOutputStream(archivo);
			
			DataOutputStream dos = new DataOutputStream(fos);
			
			//Escribir datos en el archivo binario
			dos.writeInt(100); //Escribo un entero
			dos.writeDouble(3.1415); //Escribo un double
			dos.writeUTF("Hola mundo en archivo binario"); //Escribo un String
			
			System.out.println("Datos escritos en un archivo binario de forma secuencial");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error al escribir en el archivo binario");
			e.printStackTrace();
		}
		
	}

}
