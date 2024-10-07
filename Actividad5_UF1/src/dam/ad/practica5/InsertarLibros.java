package dam.ad.practica5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class InsertarLibros {

	static final int TAM_TITULO = 30;
	static final int TAM_AUTOR = 20;
	static final int TAM_REGISTRO = TAM_TITULO * 2 + TAM_AUTOR * 2 + 4 + 4 + 4;
	
	static Scanner sc;
	static RandomAccessFile raf;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		try {
			raf = new RandomAccessFile("Ficheros/libros.dat", "rw");
			
			escribir();
			
			leer();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private static void leer() throws IOException {
		int id;
		String titulo;
		String autor;
		int anio;
		int numPag;
		char [] cAutor = new char[TAM_AUTOR];
		char [] cTitulo = new char[TAM_TITULO];
		raf.seek(0);
		
		while(raf.getFilePointer() < raf.length()) {
			id = raf.readInt();
			
			for (int i = 0; i < TAM_TITULO; i++) {
				cTitulo[i] = raf.readChar();
			}
			titulo = new String(cTitulo).trim();
			
			for (int i = 0; i < TAM_AUTOR; i++) {
				cAutor[i] = raf.readChar();
			}
			autor = new String(cAutor).trim();
			
			anio = raf.readInt();
			
			numPag = raf.readInt();
			
			System.out.println("ID: " + id + " - TITULO: " + titulo 
					+ " - AUTOR: " + autor + " - AÑO DE EDICION: " + anio 
					+ " - NUMERO PAGINAS: " + numPag);
			
		}
	}

	private static void escribir() throws IOException {
		int id;
		StringBuffer sbTitulo;
		StringBuffer sbAutor;
		int anio;
		int numPag;
		String res;
		
		boolean seguir = true;
		while(seguir) {			
			if(raf.length() != 0) {
				raf.seek(raf.length() - TAM_REGISTRO);
				id = raf.readInt() + 1;
			} else {
				id = 1;
			}
			raf.seek(raf.length());
			
			sbTitulo = new StringBuffer(pedirDatos("Titulo", TAM_TITULO));
			sbAutor = new StringBuffer(pedirDatos("Autor", TAM_AUTOR));
			
			sbTitulo.setLength(TAM_TITULO);
			sbAutor.setLength(TAM_AUTOR);
			
			anio = pedirEnteros("Año de edicion");
			numPag = pedirEnteros("Numero de paginas");
			
			raf.writeInt(id);
			
			raf.writeChars(sbTitulo.toString());
			
			raf.writeChars(sbAutor.toString());
			
			raf.writeInt(anio);
			
			raf.writeInt(numPag);
			
			System.out.println("¿Desea registrar otro libro? SI/NO");
			res = sc.nextLine();
			
			if(res.equalsIgnoreCase("NO")) {
				seguir = false;
			}
		}
	}

	private static int pedirEnteros(String dato) {
		int i = 0;
		boolean valido = true;
		try {
			do {
				System.out.println("Introduce el " + dato);
				i = Integer.parseInt(sc.nextLine());
				valido = true;
			} while(!valido);
			
		} catch (NumberFormatException e) {
			System.out.println("El " + dato + " debe ser numerico");
			valido = false;
		}
		
		return i;
	}

	private static String pedirDatos(String dato, int max) {
		String s = "";
		
		while(s.isEmpty() || s.length() > max) {
			System.out.println("Introduce el " + dato);
			s = sc.nextLine();
			
			if(s.isEmpty()) {
				System.out.println("El " + dato + " no puede estar vacio");
			} else if (s.length() > max) {
				System.out.println("El " + dato + " no puede exceder los " + max + " caracteres");
			}
			
		}
		return s;
	}

}
