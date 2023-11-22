package grupo1.buque;

import java.util.*;

import grupo1.Posicion;
import grupo1.TerminalGestionada;
import grupo1.buque.fases.Fase;
import grupo1.buque.fases.Outbound;
import grupo1.containers.Container;

public class Buque{

    private List<Container> cargas = new ArrayList<>();
    private Fase faseActual;
    private GPS gps;
    private TerminalGestionada terminalG;
    
    public Buque(TerminalGestionada tg) {
     this.faseActual = new Outbound();
     this.terminalG = tg;
    }
    
    public Posicion getPosicion() {
    	return (this.gps.getPosicion());
    }
    
    public Fase getfase() {
    	return this.faseActual;
    }
    
    public List<Container> getCargas() {
        return this.cargas;
     
    }
    
    public TerminalGestionada getTerminal() {
    	return this.terminalG;
    }
    
    public int getDistancia() {
    
    	Posicion posicionT = this.getTerminal().getPosicion();
    	return (this.getPosicion()).distanciaHasta(posicionT);
    	
    }
    
    public void addCarga(Container carga) {
        this.cargas.add(carga);
    }
    
    public void actualizarFase() {
    	if (this.getfase().condicionFase(this)) {
    		this.faseActual = this.getfase().siguiente() ;
    		this.realizarAccionFase();
    	}
    }
    
    public void realizarAccionFase() {
    	this.faseActual.realizarAccion(this);
    }

    
}
