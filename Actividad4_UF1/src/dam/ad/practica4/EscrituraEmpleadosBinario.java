package dam.ad.practica4;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class EscrituraEmpleadosBinario {
	//2 Bytes por caracter, 4 Bytes un entero, 8 Bytes un double
	static final int TAM_NOMBRE = 10; //Tamaño maximo del nombre
	static final int TAM_REGISTRO = TAM_NOMBRE * 2 + 4 + 8; //Tamaño del registro
	
	public static void main(String[] args) {
		//Incluir manualmente informacion de empleados
		String [] nombres = {"Jorge", "David", "Pablo", "Ines", "Paula"};
		int [] departamentos = {10,10,20,20,30};
		double [] salarios = {28000.6, 33000.9, 42000.4, 27000.2, 37000.5};
		
		try {
			RandomAccessFile raf = new RandomAccessFile("Ficheros/empleados.dat", "rw");
			
			//Me posiciono al final del archivo
			raf.seek(raf.length());
			
			//Escribir los datos de los empleados
			StringBuffer sb;
			for (int i = 0; i < salarios.length; i++) {
				//Escribir los nombres
				sb = new StringBuffer(nombres[i]); //Guardo cada nombre en el StringBuffer
				sb.setLength(TAM_NOMBRE); //Ajusto el tamaño a 10 caracteres como maximo
				raf.writeChars(sb.toString());
				
				raf.writeInt(departamentos[i]); //Escritura del departamento
				raf.writeDouble(salarios[i]); //Escritura del salario
			}
			raf.close();
			System.out.println("Datos Guardados");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
