package grupo1.buque.fases;

import grupo1.TerminalGestionada;
import grupo1.buque.Buque;

public class Departing extends Fase{
    
    public Departing() {
        super();
    }
    
    @Override
    public boolean condicionFase(Buque buque) {
    	
    	if(buque.tieneOrdenDepart() ) {
    		return true;
    	}
    	return false;
    }
     
    @Override
    public Fase siguiente() {
    	return new Outbound();
    
    }
    
	@Override
	public void realizarAccion() {
		// TODO Auto-generated method stub
		}
}
