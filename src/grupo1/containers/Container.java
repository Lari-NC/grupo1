package grupo1.containers;

public class Container {

    private int ancho;
    private int largo;
    private int alto;
    private int pesoTotal;


    public Container(int ancho, int largo, int alto, int peso) {
        this.ancho     = ancho;
        this.largo     = largo;
        this.alto      = alto;
        this.pesoTotal = peso; 
    }

    public int getAncho() {
        return this.ancho;
    }

    public int getLargo() {
        return this.largo;
    }

    public int getAlto() {
        return this.alto;
    }

    public int getPesoTotal() {
        return this.pesoTotal;
    }
    
    public int metrosCubicos() {
    	return getAncho() * getLargo() * getAlto();
    }
}