package grupo1.buque.fases;

import grupo1.buque.Buque;
import grupo1.buque.Fase;

public class Departing extends Fase{
    
    public Departing() {
        super();
    }
    
    @Override
    public boolean verificarCambioFase(Buque buque) {
    	
    	if(buque.getPosicion() >= 1 ) {
    		return true;
    	}
    	return false;
    }
    
    @Override
    public Fase siguiente() {
    	return new Outbound();
    
    }
}
