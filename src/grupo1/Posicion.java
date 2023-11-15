package grupo1;

public class Posicion {
	private int coordenadaX;
	private int coordenadaY;

	public int getCoordenadaX() {
		return this.coordenadaX;
		
	}
	public int getCoordenadaY() {
		return this.coordenadaY;
		
	}

	public int distanciaEntre(Posicion otraPosicion) {
        
        int x = otraPosicion.getCoordenadaX() - this.coordenadaX;
        int y = otraPosicion.getCoordenadaY() - this.coordenadaY;

        //hipotenusa :*
        return (int) Math.sqrt(x*x + y*y);
    }
}
