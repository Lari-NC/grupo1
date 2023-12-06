package grupo1.buque.fases;

import grupo1.buque.Buque;

public interface Fase {
    
    public boolean condicionFase(Buque buque);
    
    public Fase siguiente();
    
    public void realizarAccion(Buque buque);
    
}