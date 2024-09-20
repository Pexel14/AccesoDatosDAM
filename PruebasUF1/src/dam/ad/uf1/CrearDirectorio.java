package dam.ad.uf1;

import java.io.File;

public class CrearDirectorio {

	public static void main(String[] args) {
		//Especificamos el nombre del directorio
		String nomDir = "Ficheros";
		
		//Creamos un objeto File para el directorio
		File directorio = new File(nomDir);
		
		//Creamos el directorio con el nombre definido, comprobar si existe antes
		if(!directorio.exists()) {
			directorio.mkdir();
			System.out.println("Se ha creado el directorio");
		} else {
			System.out.println("El directorio ya existe, no se ha creado ningun directorio");
		}
	}

}
