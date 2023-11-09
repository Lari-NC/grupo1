package grupo1;

public class Tanque extends Container {
    
    private double consumo;

    public Tanque(double ancho, double largo, double alto, double peso, double consumo) {
        super(ancho, largo, alto, peso);
        this.consumo = consumo;
    }

    public double getConsumo() {
        return this.consumo;
    }
}
