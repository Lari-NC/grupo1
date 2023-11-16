package grupo1.buque;


public class Fase {
    
    public Fase() {
    }
    
    
    public boolean verificarCambioFase(Buque buque) {
    	return false;
    }
    
    public Fase siguiente() {
    		return new Fase(); 
    }
    
}
