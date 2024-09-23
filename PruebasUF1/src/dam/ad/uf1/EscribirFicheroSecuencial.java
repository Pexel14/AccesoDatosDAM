package dam.ad.uf1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EscribirFicheroSecuencial {

	public static void main(String[] args) {
		//Ruta del archvio ya existente
		String rutaArch = "Ficheros/ejemplo.txt";
		
		//Escribimos la frase "Hello World" en el archvio de forma secuencial
		try {
			BufferedWriter escritor = new BufferedWriter(new FileWriter(rutaArch, true)); //Unida a la creacion de registros
			escritor.write("Hello World"); //Se puede usar el \n
			escritor.newLine();
			System.out.println("Escritura completada");
			escritor.close();
			
		} catch (IOException e) {
			System.out.println("Ocurrio un error al escribir en el archivo");
			e.printStackTrace();
		}
		
	}

}
