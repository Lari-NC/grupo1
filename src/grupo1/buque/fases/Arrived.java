package grupo1.buque.fases;

import grupo1.buque.Buque;
import grupo1.buque.Fase;

public class Arrived extends Fase{
    
    public Arrived() {
        super();
    }
    
    @Override
    public boolean verificarCambioFase(Buque buque) {
    	
    	if(buque.tieneOrdenWorking() ) {
    		return true;
    	}
    	return false;
    }
    
    @Override
    public Fase siguiente() {
    	return new Working();
    
    }

}