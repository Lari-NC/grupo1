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
    
    public Buque() {
     this.faseActual = new Outbound();
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

    public void addCarga(Container carga) {
        this.cargas.add(carga);
    }
    
    
    public int getDistancia(TerminalGestionada terminal) {
    
    	Posicion posicionT = terminal.getPosicion();
    	return (this.getPosicion()).distanciaHasta(posicionT);
    	
    }
    
    public void actualizarFase(TerminalGestionada terminal) {
    	
    	if (this.getfase().condicionFase(this)) {
    		this.faseActual = this.getfase().siguiente() ;
    		this.realizarAccionFase();
    	}
    }
    
    public void realizarAccionFase() {
    	this.faseActual.realizarAccion(this);
    }

    
}
