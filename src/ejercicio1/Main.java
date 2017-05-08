package ejercicio1;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		
		SolucionEjercicio1 test = new SolucionEjercicio1(0);
		
		List<Punto> puntos = test.crearPuntos(); 
			
		SolucionEjercicio1 puntosMenorDist = test.Ejercicio1(puntos);
		
		System.out.print(puntosMenorDist.getA().getX());
		System.out.print("/");
		System.out.println(puntosMenorDist.getA().getY());
		System.out.print(puntosMenorDist.getB().getX());
		System.out.print("/");
		System.out.println(puntosMenorDist.getB().getY());
		
		System.out.println(puntosMenorDist.getCantInstrucciones());
	
	}

}
