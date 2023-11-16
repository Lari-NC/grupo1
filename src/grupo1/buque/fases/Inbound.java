package grupo1.buque.fases;

import grupo1.buque.Buque;
import grupo1.buque.Fase;

public class Inbound extends Fase{
    
    public Inbound() {
        super();
    }
    
    @Override
    public boolean verificarCambioFase(Buque buque) {
    	
    	if(buque.getPosicion() = 0 ) {
    		return true;
    	}
    	return false;
    }
    
    @Override
    public Fase siguiente() {
    	return new Arrived();
    
    }
}
