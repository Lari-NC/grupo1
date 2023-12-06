package grupo1.buque.fases;

import grupo1.buque.Buque;

public class Outbound implements Fase{
    
    public Outbound() {
        super();
    }
    
    @Override
    public boolean condicionFase(Buque buque) {
    	return buque.getDistanciaATerminalGestionada() >= 1;
    }
    
    @Override
    public Fase siguiente() {
    	return new Inbound();
    }

	@Override
	public void realizarAccion(Buque buque) {
		buque.darAvisoOutboundATerminal();
	}  
}