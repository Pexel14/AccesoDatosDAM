package dam.ad.uf1;

import java.io.File;
import java.io.IOException;

public class CrearFichero {

	public static void main(String[] args) {
		//Ruta del directorio donde vamos a almacenar el archivo
		String nomDir = "Ficheros";

		//Creamos un objeto File para poder crear el fichero "ejemplo.txt" dentro del directorio Ficheros
		File archivo = new File(nomDir, "ejemplo2.txt");
		
		//Finalmente creamos el fichero
		if(!archivo.exists()) {
			try {
				archivo.createNewFile();
				System.out.println("Archivo creado con exito");
				
			} catch (IOException e) {
				System.out.println("El archivo no se ha podido crear");
				e.printStackTrace();
			}
			
		} else {
			System.out.println("El archivo ya existe");
		}
	}

}
