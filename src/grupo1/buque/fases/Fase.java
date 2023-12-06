package grupo1.buque.fases;

import grupo1.buque.Buque;

public interface Fase {
    
    public abstract boolean condicionFase(Buque buque);
    
    public abstract Fase siguiente();
    
    public abstract void realizarAccion(Buque buque);
    
}