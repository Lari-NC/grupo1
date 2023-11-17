package grupo1.buque.fases;

import grupo1.buque.Buque;

public class Arrived extends Fase{
    
    public Arrived() {
        super();
    }
    
    @Override
    public boolean condicionFase(Buque buque) {
    	
    	   
    	if(buque.getDistancia(terminal) == 0 ) {
    		return true;
    	}
    	return false;
    }
    
    @Override
    public Fase siguiente() {
    	return new Working();
    
    }

}