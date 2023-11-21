package grupo1;

import grupo1.circuito.Circuito;

public class Viaje {
    
    private Circuito circuito;

    public Viaje(Circuito c) {
        this.circuito = c;
    }
    
    public Viaje() {} //para mockito
    
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
