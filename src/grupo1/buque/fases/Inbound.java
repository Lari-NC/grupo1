package grupo1.buque.fases;

import grupo1.TerminalGestionada;
import grupo1.buque.Buque;

public class Inbound extends Fase{
    
    public Inbound() {
        super();
    }
    
    @Override
    public boolean condicionFase(Buque buque) {
    	
    	if(buque.getDistancia(this.getTerminal()) <= 50 ) {
    		return true;
    	}
    	return false;
    }
    
    @Override
    public Fase siguiente() {
    	return new Arrived();
    
    }

	@Override
	public void realizarAccion(Buque buque) {
		this.getTerminal().darAvisoDeBuqueInbound(buque);
	}
}
