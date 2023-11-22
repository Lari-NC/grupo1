package grupo1.buque.fases;

import grupo1.TerminalGestionada;
import grupo1.buque.Buque;

public abstract class Fase {
    private TerminalGestionada terminalG;
    
    public Fase(TerminalGestionada tg) {
    	this.terminalG = tg;
    }
    
    public TerminalGestionada getTerminal() {
    	return this.terminalG;
    }
    
    
    public abstract boolean condicionFase(Buque buque);
    public abstract Fase siguiente();
    
    public Fase() {}
    
    public boolean puedoCambiarFase(Buque buque) {
    	return buque.getfase().siguiente().condicionFase(buque);
    }
    public abstract void realizarAccion(Buque buque);
    
}
