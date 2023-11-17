package grupo1.buque.fases;

import grupo1.buque.Buque;

public class Working extends Fase{
    
    public Working() {
        super();
    }
    
    @Override
    public boolean condicionFase(Buque buque) {
    	
    	if(buque.tieneOrdenWorking() ) {
    		return true;
    	}
    	return false;
    }
    
    @Override
    public Fase siguiente() {
    	return new Departing();
    
    }

}