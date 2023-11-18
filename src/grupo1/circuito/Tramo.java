package grupo1.circuito;
import java.util.Date;

import grupo1.Terminal;

public class Tramo {
    
    private int precio; // creoq ue no ?? dsps reviso
    private int tiempo; 
    private Terminal terminalInicio;
    private Terminal terminalFin;


    public Tramo(Terminal tInicio, Terminal tFin, int tiempo, int precio) {
        this.terminalInicio = tInicio;
        this.terminalFin = tFin;
        this.precio = precio;
        this.tiempo = tiempo;

    }
    
    public int getPrecio() {
    	return this.precio;
    }

    public Terminal getTerminalInicio() {
    	return this.terminalInicio;
    }
    
    public Terminal getTerminalLlegada() {
    	return this.terminalFin;
    }
    
}
