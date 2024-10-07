package dam.ad.uf1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class EscribirFicheroAleatorio {

	public static void main(String[] args) {
		//Ruta del fichero binario
		String rutaArchivo = "Ficheros/ejemplo.bin";
		
		try {
			RandomAccessFile raf = new RandomAccessFile(rutaArchivo, "rw");
			
			//Borrar el archivo para comenzar de nuevo
			raf.setLength(0);
			
			//Posicionarme al final de un archivo
			raf.seek(raf.length());
			
			//Escribir una cadena como UTF-8
			String texto = "Hello world de forma aleatoria";
			
			for (int i = 0; i < texto.length(); i++) {
				raf.writeChar(texto.charAt(i));
			}
			
			//Escribir un entero
			raf.writeInt(12345);
			
			//Escribir un boolean
			raf.writeBoolean(true);
			
			//Escribir un caracter
			raf.writeChar('A');
			
			//Escribir un double
			raf.writeDouble(3.141596);
			
			System.out.println("Datos escritos correctamente en el archivo binario");
			
		} catch (FileNotFoundException e) {
			System.out.println("No se ha encontrado el archivo");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Ha ocurrido un error inesperado");
			e.printStackTrace();
		}
		
	}

}
