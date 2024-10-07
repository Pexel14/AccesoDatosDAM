package dam.ad.practica4;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class LeerEmpleadosBinario {

	static final int TAM_NOMBRE = 10;
	static final int TAM_REGISTRO = TAM_NOMBRE * 2 + 4 + 8;
	
	public static void main(String[] args) {
		
		try {
			RandomAccessFile raf = new RandomAccessFile("Ficheros/empleados.dat", "r");
			
			//Posicionarme el puntero al inicio del archivo
			raf.seek(0);
			
			//Variables para almacenar los datos leidos
			String nombre;
			char [] cNombre = new char[TAM_NOMBRE];
			int departamento;
			double salario;
			
			//Leer el archivo y mostrar el contenido de cada elemento
			
			while(raf.getFilePointer() < raf.length()) { //Siempre que existan datos y no se ha llegado al final seguire leyendo
				//Lectura del nombre
				//Caracter a caracter
				
				for (int i = 0; i < TAM_NOMBRE; i++) {
					cNombre[i] = raf.readChar(); //Leer cada caracter del nombre hasta 10 caracteres
				}
				nombre = new String(cNombre).trim();
				
				//Lectura del departamento
				departamento = raf.readInt();
				salario = raf.readDouble();
				
				System.out.println("Nombre: " + nombre + " - Departamento: " + departamento + " - Salario: " + salario);
			}
			
			raf.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
