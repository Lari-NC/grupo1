package grupo1;

public class Posicion {
	
//INITIALIZE:
	private int coordenadaX;
	private int coordenadaY;
	
	public Posicion(int x,int y) {
		this.coordenadaX = x;
		this.coordenadaY = y;
	}

	
	//GETTERS:
	public int getCoordenadaX() {
		return this.coordenadaX;
	}
	
	public int getCoordenadaY() {
		return this.coordenadaY;
	}

}