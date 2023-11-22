package grupo1.buque.fases;

import grupo1.TerminalGestionada;
import grupo1.buque.Buque;

public class Arrived extends Fase{
    
    public Arrived() {
        super();
    }
    
    @Override
    public boolean condicionFase(Buque buque) {
    	
    	   
    	if(buque.getDistancia(this.getTerminal()) == 0 ) {
    		return true;
    	}
    	return false;
    }
    
    @Override
    public Fase siguiente() {
    	return new Working();
    
    }

	@Override
	public void realizarAccion(Buque buque) {}

}