package grupo1.containers;

public class Reefer extends Container {
	
	private int consumo;
	
	public Reefer(int ancho, int largo, int alto, int peso) {
        super(ancho, largo, alto, peso);
        this.consumo = 0;
    }

	public int getConsumo() {
		return consumo;
	}
}
