package grupo1.containers;

public class Container {

    private double ancho;
    private double largo;
    private double alto;
    private double pesoTotal;

    public Container(double ancho, double largo, double alto, double peso) {
        this.ancho     = ancho;
        this.largo     = largo;
        this.alto      = alto;
        this.pesoTotal = peso; 
    }

    public double getAncho() {
        return this.ancho;
    }

    public double getLargo() {
        return this.largo;
    }

    public double getAlto() {
        return this.alto;
    }

    public double getPesoTotal() {
        return this.pesoTotal;
    }
}