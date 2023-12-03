package grupo1.circuito;

import grupo1.Terminal;

public class Tramo {

//INITIALIZE:
	private Terminal terminalInicio;
	private Terminal terminalFin;
	private int tiempo; 
    private int precio;

    public Tramo(Terminal tInicio, Terminal tFin, int tiempo, int precio) {
        this.terminalInicio = tInicio;
        this.terminalFin 	= tFin;
        this.precio 		= precio;
        this.tiempo 		= tiempo;
    }
 
    //GETTERS:
    public Terminal getTerminalInicio() {
    	return this.terminalInicio;
    }
    
    public Terminal getTerminalLlegada() {
    	return this.terminalFin;
    }
    
    public int getPrecio() {
    	return this.precio;
    }
    
    public int getTiempo() {
    	return this.tiempo;
    }
}