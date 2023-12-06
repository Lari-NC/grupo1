package grupo1.buque.fases;

import grupo1.buque.Buque;

public class Departing implements Fase{
    
    public Departing() {
        super();
    }
    
    @Override
    public boolean condicionFase(Buque buque) {
    	return buque.tieneOrdenDepart();
    }
     
    @Override
    public Fase siguiente() {
    	return new Outbound();
    }
    
	@Override
	public void realizarAccion(Buque buque) {
		buque.darAvisoDepartATerminal();
	}
}