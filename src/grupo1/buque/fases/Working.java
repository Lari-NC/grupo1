package grupo1.buque.fases;

import grupo1.TerminalGestionada;
import grupo1.buque.Buque;

public class Working extends Fase{
    
    public Working() {
        super();
    }
    
    @Override
    public boolean condicionFase(Buque buque) {
    	return buque.tieneOrdenWorking();
    }
    
    @Override
    public Fase siguiente() {
    	return new Departing();
    
    }

	@Override
	public void realizarAccion(Buque buque) {
		//(buque.getTerminal().getOrdenesPorRetirar()).addAll(buque.getCargas()); LO QUE ESTABA ANTES
		TerminalGestionada t = buque.getTerminal(); 
		t.agregarOrdenesPorRetirar(buque);
	}

}