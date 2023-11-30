package grupo1;

import grupo1.buque.Buque;
import grupo1.circuito.Circuito;

public class Viaje {
	
    private Buque buque;
    private Circuito circuito;
    private Terminal terminalInicial;
    private Terminal terminalDestino;

    public Viaje(Circuito c, Buque b, Terminal terminalInicial, Terminal terminalDestino) {
        this.circuito 		 = c.crearCircuitoEspecificoPara_Y_(terminalInicial, terminalDestino);
        this.buque 	  		 = b;
        this.terminalInicial = terminalInicial;
        this.terminalDestino = terminalDestino;
    }
    
	public Buque getBuque() {
		return buque;
	}
    
    public Circuito getCircuito() {
        return this.circuito;
    }
    
    public Terminal getTerminalInicial() {
    	return this.terminalInicial;
    }
    
    public Terminal getTerminalDestino() {
    	return this.terminalDestino;
    }
    
    public int getPrecioViaje() {
    	return this.getCircuito().getPrecioTotalDeCircuito();
    }
}
