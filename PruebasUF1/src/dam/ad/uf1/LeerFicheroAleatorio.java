package dam.ad.uf1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class LeerFicheroAleatorio {

	public static void main(String[] args) {
		// Ruta del archivo
		String ruta = "Ficheros/ejemplo.bin";

		try {
			RandomAccessFile raf = new RandomAccessFile(ruta, "r");

			// Mueve el puntero al inicio del archivo para comenzar a leer
			raf.seek(0);

			char caracterLeido;
			String cadenaLeida = "";

			for (int i = 0; i < 30; i++) {
				caracterLeido = raf.readChar();
				cadenaLeida += caracterLeido;
			}

			// Leer la cadena escrita
			System.out.println("Texto leido: " + cadenaLeida);

			// Leer entero
			System.out.println("Entero leido: " + raf.readInt());

			// Leer boolean
			System.out.println("Boolean leido: " + raf.readBoolean());

			// Leer caracter
			System.out.println("Caracter leido: " + raf.readChar());

			// Leer double
			System.out.println("Double leido: " + raf.readDouble());

			// Leer el double de nuevo
			raf.seek(30 * 2 + 47 + 4 + 1 + 2);
			System.out.println("Double leido: " + raf.readDouble());

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//JORGE
		
		// Ruta del fichero binario
		String rutaArchivo = "Ficheros/ejemplo.bin";

		try(
		RandomAccessFile archivo = new RandomAccessFile(rutaArchivo, "r"))
		{

			// Mueve el puntero al principio del archivo para empezar a leer

			archivo.seek(0);

			// Leer la cadena escrita con writeUTF()
			char caracterLeido;
			String cadenaLeida = "";
			for (int i = 0; i < 30; i++) { // longitud del texto es 30 bytes
				caracterLeido = archivo.readChar();
				cadenaLeida = cadenaLeida + caracterLeido;
			}
			System.out.println("Texto simple leído (UTF-8): " + cadenaLeida);

			// Leer el texto completo como UTF-8
			String textoCompletoLeido = archivo.readUTF();
			System.out.println("Texto completo leído (UTF-8): " + textoCompletoLeido);

			// Leer el valor entero
			int numeroEntero = archivo.readInt();
			System.out.println("Entero leído: " + numeroEntero);

			// Leer el valor booleano
			boolean valorBooleano = archivo.readBoolean();
			System.out.println("Booleano leído: " + valorBooleano);

			// Leer el carácter
			char caracterLeido2 = archivo.readChar();
			System.out.println("Carácter leído: " + caracterLeido2);

			// Leer el valor double
			double numeroDoubleLeido = archivo.readDouble();
			System.out.println("Double leído: " + numeroDoubleLeido);

			// Leer el booleano de nuevo
			// Tenemos que posicionarnos correctamente para leerlo

			archivo.seek(30 * 2 + 47 + 4 + 1 + 2); // 45+2=47 porque en UTF8 es 1 caracter = 1 byte y además + 2 bytes
													// siempre
			double valorDouble = archivo.readDouble();
			System.out.println("Double leído de forma aleatoria: " + valorDouble);

		}catch(
		IOException e)
		{
			System.out.println("Ocurrió un error al leer el archivo.");
			e.printStackTrace();
		}
	}

}
