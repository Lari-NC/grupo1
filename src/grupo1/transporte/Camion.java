package grupo1.transporte;

public class Camion {
    
    private Chofer chofer;

    public Camion() {
    	
    }

    public void asignarChofer(Chofer c) {
        this.chofer = c;
    }

    public Chofer getChofer() {
        return this.chofer;
    }
}