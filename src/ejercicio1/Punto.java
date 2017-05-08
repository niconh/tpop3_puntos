package ejercicio1;

public class Punto {
	
	private int x;
	private int y;

	
	public Punto(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public double calcularDistancia(Punto a){	
		return Math.sqrt(Math.pow((this.x - a.x), 2) + Math.pow((this.y - a.y), 2));
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	
}
