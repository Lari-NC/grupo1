package grupo1.circuito;
import java.util.Date;

import grupo1.Terminal;

public class Tramo {
    
    private double precio; // creoq ue no ?? dsps reviso
    private int tiempo; 
    private Terminal terminalInicio;
    private Date fechaSalida;
    private Terminal terminalFin;
    private Date fechaLlegada;

    public Tramo(Terminal tInicio, Terminal tFin, int tiempo, int precio, Date fechaSalida, Date fechaLlegada) {
        this.terminalInicio = tInicio;
        this.terminalFin = tFin;
        this.precio = precio;
        this.tiempo = tiempo;
        this.fechaLlegada = fechaLlegada;
        this.fechaSalida = fechaSalida;
    }
    
    public Date getFechaSalida() {
    	return this.fechaSalida;
    }
    
    public Date getFechaLlegada() {
    	return this.fechaLlegada;
    }

    public Terminal getTerminalInicio() {
    	return this.terminalInicio;
    }
    
    public Terminal getTerminalLlegada() {
    	return this.getTerminalLlegada();
    }
    
}
