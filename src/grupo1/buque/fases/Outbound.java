package grupo1.buque.fases;

import grupo1.buque.Buque;

public class Outbound extends Fase{
    
    public Outbound() {
        super();
    }
    
    @Override
    public boolean condicionFase(Buque buque) {
    	return buque.getDistancia() >= 1;
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
