package grupo1.containers;

public class Reefer extends Container {
	
	private int consumo;
	
	public Reefer(int ancho, int largo, int alto, int peso, int consumo) {
        super(ancho, largo, alto, peso);
        this.consumo = consumo;
    }

	public int getConsumo() {
		return consumo;
	}
	
}
