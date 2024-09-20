package dam.ad.uf1;

import java.io.File;

public class ComprobarDirectorio {

	public static void main(String[] args) {
		//Instanciamos objeto de la clase File y pasamos el nombre del directorio a comprobar
		File file = new File("Ficheros");
		
		//Verificamos si el fichero o el directorio existe
		if(file.exists()){
			System.out.println("El fichero/directorio existe");
			
			//Dentro del mismo if comprobaremos si es una carpeta o un archivo
			if(file.isDirectory()) {
				System.out.println("Es un directorio");
				System.out.println("Nombre del directorio: " + file.getName());
				System.out.println("Ruta completa: " + file.getAbsolutePath());
				System.out.println("Tamaño directorio: " + file.length());
				
				//Mostrar lista de archivos dentro del directorio
				File [] listaArchivos = file.listFiles();
				System.out.println("\nLista de archivos");
				System.out.println("--------------------");
				
				for(File nombre : listaArchivos) {
					System.out.println(nombre.getName()); //Imprimir cada uno de los nombres de archivo
				}
				
			} else if (file.isFile()){
				System.out.println("Es un fichero");
				
			} else {
				System.out.println("El elemento no existe");
			}
			
		} else {
			System.out.println("El fichero/directorio no existe");
		}
	}

}
