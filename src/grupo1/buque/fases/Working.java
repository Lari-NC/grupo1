package grupo1.buque.fases;

import grupo1.buque.Buque;
import grupo1.buque.Fase;

public class Working extends Fase{
    
    public Working() {
        super();
    }
    
    @Override
    public boolean verificarCambioFase(Buque buque) {
    	
    	if(buque.tieneOrdenDepart() ) {
    		return true;
    	}
    	return false;
    }
    
    @Override
    public Fase siguiente() {
    	return new Departing();
    
    }

}