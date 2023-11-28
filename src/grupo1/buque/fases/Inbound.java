package grupo1.buque.fases;

import grupo1.buque.Buque;

public class Inbound extends Fase{
    
    public Inbound() {
        super();
    }
    
    @Override
    public boolean condicionFase(Buque buque) {
    	return buque.getDistanciaATerminalGestionada() <= 50;
    }
    
    
    @Override
    public Fase siguiente() {
    	return new Arrived();
    }

	@Override
	public void realizarAccion(Buque buque) {
		buque.darAvisoInboundATerminal();
	}
}
