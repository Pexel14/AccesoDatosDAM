package dam.ad.practica6.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import dam.ad.practica6.pojos.LineaPedido;
import dam.ad.practica6.pojos.Producto;

public class InsertLineaPedidos {

	public static void main(String[] args) {
		ArrayList<Producto> productos = new ArrayList<Producto>();
		
		productos.add(new Producto(1,"Pipas",0.99));
		productos.add(new Producto(2,"Zapatos",11.99));
		productos.add(new Producto(3,"Cacahuetes",2.99));
		productos.add(new Producto(4,"Anacardos",1.99));
		productos.add(new Producto(5,"Almendras",3.99));
		
		ArrayList<LineaPedido> lineaPedidos = new ArrayList<LineaPedido>();
		
		lineaPedidos.add(new LineaPedido(1, productos.get(0), 100, productos.get(0).getPrecio()*100, "12/06/2024"));
		lineaPedidos.add(new LineaPedido(2, productos.get(1), 10, productos.get(1).getPrecio()*10, "22/11/2023"));
		lineaPedidos.add(new LineaPedido(3, productos.get(2), 200, productos.get(2).getPrecio()*200, "03/05/2023"));
		lineaPedidos.add(new LineaPedido(4, productos.get(3), 50, productos.get(3).getPrecio()*50, "09/03/2023"));
		lineaPedidos.add(new LineaPedido(5, productos.get(4), 75, productos.get(4).getPrecio()*75, "15/12/2022"));
		
		escribir(lineaPedidos);
		
	}

	private static void escribir(ArrayList<LineaPedido> lineaPedidos) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Ficheros/lineaPedidos.dat"));
			
			for(LineaPedido pedido : lineaPedidos) {
				oos.writeObject(pedido);
			}
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
