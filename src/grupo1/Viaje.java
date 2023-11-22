package grupo1;

import grupo1.buque.Buque;
import grupo1.circuito.Circuito;

public class Viaje {
	
    private Buque buque;
    private Circuito circuito;

    public Viaje(Circuito c, Buque b) {
        this.circuito = c;
        this.buque = b;
    }

    
    public Circuito getCircuito() {
        return this.circuito;
    }
    
    public Terminal getTerminalDestino() {
    	return ;
    }
    
    public int getPrecioViaje() {
    	return this.getCircuito().getPrecioTotalDeCircuito();
    }
}
