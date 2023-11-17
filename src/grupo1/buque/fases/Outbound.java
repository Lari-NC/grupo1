package grupo1.buque.fases;

import grupo1.TerminalGestionada;
import grupo1.buque.Buque;

public class Outbound extends Fase{
    
    public Outbound() {
        super();
    }
    
    @Override
    public boolean condicionFase(Buque buque) {
   	
    	if(buque.getDistancia(terminal) >= 1 ) {
    		return true;
    	}
    	return false;
    }
    
    @Override
    public Fase siguiente() {
    	return new Inbound();
    
    }
    
    
}
