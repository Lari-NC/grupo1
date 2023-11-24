package grupo1.containers;

public class Reefer extends Container {
	
	private int consumo = 0;
	
	public Reefer(int ancho, int largo, int alto, int peso) {
        super(ancho, largo, alto, peso);
    }

	public int getConsumo() {
		return consumo;
	}
	
	//DeberiamosPoderIncresarleElNuevoConsumo, cuandohaya consumido energia.
}
