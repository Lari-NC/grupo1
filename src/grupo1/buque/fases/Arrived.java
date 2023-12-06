package grupo1.buque.fases;

import grupo1.buque.Buque;

public class Arrived implements Fase{
    
    public Arrived() {
        super();
    }

    @Override
    public boolean condicionFase(Buque buque) {
    	return buque.getDistanciaATerminalGestionada() == 0;
    }

    @Override
    public Fase siguiente() {
    	return new Working();
    }
    
	@Override
	public void realizarAccion(Buque buque) {
		
	}
}