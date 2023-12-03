package grupo1.buque.fases;

import grupo1.buque.Buque;

public abstract class Fase {
	
	public Fase() {
    	
    }
    
    public abstract boolean condicionFase(Buque buque);
    
    public abstract Fase siguiente();
    
    public abstract void realizarAccion(Buque buque);
    
}