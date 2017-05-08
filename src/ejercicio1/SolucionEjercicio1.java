package ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class SolucionEjercicio1 {
	
	private Punto a;
	private Punto b;
	private int cantInstrucciones;
	
	public SolucionEjercicio1(Punto a, Punto b, int cantInstrucciones) {
		this.a = a;
		this.b = b;
		this.cantInstrucciones = cantInstrucciones;
	}
	
	public SolucionEjercicio1(int cantInstrucciones) {
		this.cantInstrucciones = cantInstrucciones;
	}
	
	public Punto getA() {
		return a;
	}

	public Punto getB() {
		return b;
	}

	public int getCantInstrucciones() {
		return cantInstrucciones;
	}

	public SolucionEjercicio1 distanciaMinimaIterativa(List<Punto> points){
		
		double dmin = Double.MAX_VALUE; this.cantInstrucciones++;
		SolucionEjercicio1 puntosMenorDist = new SolucionEjercicio1(points.get(0),points.get(1),this.cantInstrucciones); this.cantInstrucciones++;
			
		for(int i = 0; i < points.size();i++){
			for(int j = i+1; j < points.size();j++){
				double dist = points.get(i).calcularDistancia(points.get(j)); this.cantInstrucciones++;
				
				if (dist < dmin){
					dmin = dist; this.cantInstrucciones++;					
					puntosMenorDist = new SolucionEjercicio1(points.get(i),points.get(j),this.cantInstrucciones); this.cantInstrucciones++;					
				}
			}
		}
	
		return puntosMenorDist;
	}
	

	
	public SolucionEjercicio1 Ejercicio1(List<Punto> points){
		
		List<Punto> puntosOrdenados = mergeSort(points); this.cantInstrucciones++;
		List<Punto> puntosIzq = new ArrayList<Punto>(puntosOrdenados.subList(0, 15)); this.cantInstrucciones++;
		List<Punto> puntosDer = new ArrayList<Punto>(puntosOrdenados.subList(16, 31)); this.cantInstrucciones++;
		//List<Punto> puntosMed = new ArrayList<Punto>(puntosOrdenados.subList(15, 17)); this.cantInstrucciones++;
		SolucionEjercicio1 puntosMenor; this.cantInstrucciones++;
		

		SolucionEjercicio1 puntosIzqMenor = distanciaMinimaIterativa(puntosIzq); this.cantInstrucciones++;
		SolucionEjercicio1 puntosDerMenor = distanciaMinimaIterativa(puntosDer); this.cantInstrucciones++;
		//SolucionEjercicio1 puntosMedMenor = distanciaMinimaIterativa(puntosMed); this.cantInstrucciones++;
				
		double distIzq = puntosIzqMenor.getA().calcularDistancia(puntosIzqMenor.getB()); this.cantInstrucciones++;
		double distDer = puntosDerMenor.getA().calcularDistancia(puntosDerMenor.getB()); this.cantInstrucciones++;
		//double distMed = puntosMedMenor.getA().calcularDistancia(puntosMedMenor.getB()); this.cantInstrucciones++;

		this.cantInstrucciones++;
		if (distIzq < distDer)
			puntosMenor = new SolucionEjercicio1(puntosIzqMenor.getA(),puntosIzqMenor.getB(),this.cantInstrucciones);
		else
			puntosMenor = new SolucionEjercicio1(puntosDerMenor.getA(),puntosDerMenor.getB(),this.cantInstrucciones);
			
//		this.cantInstrucciones++;
//		if (distIzq < distDer && distIzq < distMed)
//			puntosMenor = new SolucionEjercicio1(puntosIzqMenor.getA(),puntosIzqMenor.getB(),this.cantInstrucciones);
//		else
//			if(distDer < distIzq && distDer < distMed)
//				puntosMenor = new SolucionEjercicio1(puntosDerMenor.getA(),puntosDerMenor.getB(),this.cantInstrucciones);
//			else
//				puntosMenor = new SolucionEjercicio1(puntosMedMenor.getA(),puntosMedMenor.getB(),this.cantInstrucciones);
		
		return puntosMenor;
	}
	
	

	public List<Punto> mergeSort(List<Punto> puntos){
		
		List<Punto>	Sres = new ArrayList<Punto>();  this.cantInstrucciones++;
		
		List<Punto>	S1 = new ArrayList<Punto>();
		List<Punto>	S2 = new ArrayList<Punto>();
		
		this.cantInstrucciones++;
		if(puntos.size() == 1){
			Sres.add(puntos.get(0));
		}
		else{
			this.cantInstrucciones++;
			
			S1 = puntos.subList(0, puntos.size()/2);
			S2 = puntos.subList((puntos.size()/2), puntos.size());
		
			S1 = mergeSort(S1); this.cantInstrucciones++;
			S2 = mergeSort(S2); this.cantInstrucciones++;
			Sres = merge(S1,S2); this.cantInstrucciones++;
		}
		
		return Sres;
	}
	
	
	public List<Punto> merge(List<Punto> puntosIzq, List<Punto> puntosDer){
		
		List<Punto> puntosOrd = new ArrayList<Punto>();
		
		this.cantInstrucciones++;
		
		int i=0;
		int j=0;
		while(i < puntosIzq.size() && j < puntosDer.size()){
			if(puntosIzq.get(i).getX() < puntosDer.get(j).getX()){
				puntosOrd.add(puntosIzq.get(i));
				i++;
				this.cantInstrucciones++;
			}
			else{
				puntosOrd.add(puntosDer.get(j));
				j++;
				this.cantInstrucciones++;
			}
		}
		
		if(i < puntosIzq.size()){
			for(int k = i; k < puntosIzq.size();k++){
				puntosOrd.add(puntosIzq.get(k));
				this.cantInstrucciones++;
			}
		}
		else{
			for(int k = j; k < puntosIzq.size();k++){
				puntosOrd.add(puntosDer.get(k));
				this.cantInstrucciones++;
			}
		}
			
		return puntosOrd;
	}
	
	public List<Punto> crearPuntos(){
		List<Punto> puntos = new ArrayList<Punto>();
		
		Punto a = new Punto(10,3);
		Punto b = new Punto(50,4);
		Punto c = new Punto(10,16);
		Punto d = new Punto(-50,1);
		Punto e = new Punto(-20,4);
		Punto f = new Punto(20,4);
		Punto g = new Punto(50,1);
		Punto h = new Punto(-10,1);
		
		Punto aa = new Punto(20,-2);
		Punto bb = new Punto(40,-2);
		Punto cc = new Punto(30,3);
		Punto dd = new Punto(104,0);
		Punto ee = new Punto(0,0);
		Punto ff = new Punto(0,1);
		Punto gg = new Punto(20,-5);
		Punto hh = new Punto(-20,-5);
		
		Punto aaa = new Punto(0,20);
		Punto bbb = new Punto(50,10);
		Punto ccc = new Punto(4,0);
		Punto ddd = new Punto(-3,10);
		Punto eee = new Punto(-2,10);
		Punto fff = new Punto(-4,20);
		Punto ggg = new Punto(-1,40);
		Punto hhh = new Punto(-2,70);
		
		Punto aaaa = new Punto(256,-1);
		Punto bbbb = new Punto(-4,0);
		Punto cccc = new Punto(-2,3);
		Punto dddd = new Punto(-54,4);
		Punto eeee = new Punto(-24,5);
		Punto ffff = new Punto(-36,4);
		Punto gggg = new Punto(-39,-1);
		Punto hhhh = new Punto(-48,3);
	
		puntos.add(a);
		puntos.add(b);
		puntos.add(c);
		puntos.add(d);
		puntos.add(e);
		puntos.add(f);
		puntos.add(g);
		puntos.add(h);
		
		puntos.add(aa);
		puntos.add(bb);
		puntos.add(cc);
		puntos.add(dd);
		puntos.add(ee);
		puntos.add(ff);
		puntos.add(gg);
		puntos.add(hh);
		
		puntos.add(aaa);
		puntos.add(bbb);
		puntos.add(ccc);
		puntos.add(ddd);
		puntos.add(eee);
		puntos.add(fff);
		puntos.add(ggg);
		puntos.add(hhh);
		
		puntos.add(aaaa);
		puntos.add(bbbb);
		puntos.add(cccc);
		puntos.add(dddd);
		puntos.add(eeee);
		puntos.add(ffff);
		puntos.add(gggg);
		puntos.add(hhhh);
		
		return puntos;
	}
	

}
