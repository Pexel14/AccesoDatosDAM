package dam.ad.uf1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import dam.ad.uf1.pojos.Alumno;

public class EscribirArchivoBinarioObj {
	
	public static void main(String[] args) {
		//Creamos un array de objetos de tipo Alumno
		Alumno [] alumnos = {
				new Alumno("Juan", 20, "2DAM"),
				new Alumno("Miguel", 19, "2DAM"),
				new Alumno("Carlos", 22, "2DAM"),
				new Alumno("Jaime", 28, "2DAM"),
				new Alumno("Pedro", 19, "2DAM"),
		};
		
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Ficheros/alumnos.dat"));
			//Cada objeto de tipo alumno en el array alumnos lo escribiremos en el archivo
			
			for(Alumno alumno : alumnos) {
				oos.writeObject(alumno);
			}
			System.out.println("Alumnos escritos correctamente");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
