package dam.ad.uf1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import dam.ad.uf1.pojos.Alumno;

public class LeerArchivoBinarioObj {
	
	public static void main(String[] args) {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Ficheros/alumnos.dat"));
			
			Alumno alumno;
			boolean seguir = true;
			//Bucle para leer objetos del archivo binario
			
			while(seguir) {
				try {
					alumno = (Alumno) ois.readObject(); //Leo el objeto Alumno
					System.out.println(alumno);					
				} catch (Exception e) {
					seguir = false;
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
