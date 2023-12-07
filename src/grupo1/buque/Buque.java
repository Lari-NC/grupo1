package grupo1.buque;

//import java.util.*;

import grupo1.Posicion;
import grupo1.TerminalGestionada;
import grupo1.buque.fases.Fase;
import grupo1.buque.fases.Outbound;
//import grupo1.containers.Container;

public class Buque {

//INITIALIZE:
	Posicion posicion;
	private Fase faseActual;
    private TerminalGestionada terminalG;
    private boolean ordenWorking;
    private boolean ordenDepart;
    
    public Buque(TerminalGestionada tg, Posicion posicion) {
    	this.faseActual   = new Outbound();
    	this.terminalG    = tg;
    	this.posicion 	  = posicion;
    	this.ordenWorking = false;
    	this.ordenDepart  = false;
    }


    //GETTERS:
    public Posicion getPosicion() {
    	return this.posicion;
    }
    
    public Fase getFase() {
    	return this.faseActual;
    }
    
    public TerminalGestionada getTerminal() {
    	return this.terminalG;
    }
    
    public int getDistanciaATerminalGestionada() {
    	int x = this.getPosicion().getCoordenadaX() - this.getTerminal().getPosicion().getCoordenadaX();
        int y = this.getPosicion().getCoordenadaY() - this.getTerminal().getPosicion().getCoordenadaY();
        return (int) Math.sqrt(x*x + y*y);
    }
    
    
    public void actualizarPosicion(Posicion posicionNueva) {
    	// Cuando nos movemos, tambien le preguntamos a la fase si se puede actualizar
    	//este mensaje se manda cada 1 segundo 
    	this.posicion = posicionNueva;
    	this.actualizarFase();
    }
    
    
    //ACTION:
    public void actualizarFase() {
    	if (this.getFase().siguiente().condicionFase(this)) {
    		this.faseActual = this.getFase().siguiente() ;
    		this.realizarAccionFase();
    	}
    }
    
    public void realizarAccionFase() {
    	this.faseActual.realizarAccion(this);
    }
    
    public void recibirOrdenWorking() {
    	this.ordenWorking = true;
    }
    
    public void recibirOrdenDepart() {
    	this.ordenDepart = true;
    }
    
    public void darAvisoInboundATerminal() {
    	this.getTerminal().recibirBuqueAvisoInbound(this);
    }
    
    public void darAvisoDepartATerminal() {
    	this.getTerminal().recibirBuqueAvisoDepart(this);
    }
    
    public void darAvisoOutboundATerminal() {
    	this.getTerminal().recibirBuqueAvisoOutbound(this);
    }


    //TESTING:
    public boolean tieneOrdenWorking() {
    	return this.ordenWorking;
    }
    
    public boolean tieneOrdenDepart() {
    	return this.ordenDepart;
    }
}
