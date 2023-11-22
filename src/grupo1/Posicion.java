package grupo1;

public class Posicion {
	private int coordenadaX;
	private int coordenadaY;
	
	public Posicion(int x,int y) {
		this.coordenadaX = x;
		this.coordenadaY = y;
	}

	public int getCoordenadaX() {
		return this.coordenadaX;
	}
	
	public int getCoordenadaY() {
		return this.coordenadaY;
	}

	public int distanciaHasta(Posicion otraPosicion) {
        int x = otraPosicion.getCoordenadaX() - this.coordenadaX;
        int y = otraPosicion.getCoordenadaY() - this.coordenadaY;
        return (int) Math.sqrt(x*x + y*y);
    }
}
