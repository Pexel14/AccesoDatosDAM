package dam.ad.uf1;

import java.io.File;

public class ComprobarFichero {

	public static void main(String[] args) {
		//Ruta de la carpeta
		File file = new File("Ficheros", "ejemplo.txt");
		
		//Verificamos si el archivo o carpeta existen
		if(file.exists()) {
			System.out.println("El archivo/carpeta existen");
			if(file.isFile()) {
				System.out.println("Es un archivo");
			} else if (file.isDirectory()){
				System.out.println("Es una carpeta");
			} else {
				System.out.println("El elemento no existe");
			}
			
		}
	}

}
