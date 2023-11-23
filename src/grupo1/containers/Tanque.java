package grupo1.containers;

public class Tanque extends Container {
    
    private int consumo;

    public Tanque(int ancho, int largo, int alto, int peso, int consumo) {
        super(ancho, largo, alto, peso);
        this.consumo = consumo;
    }

    public int getConsumo() {
        return this.consumo;
    }
}
