package grupo1.buque;

import java.util.*;

import grupo1.Orden;
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
    private boolean ordenWorking;
    private boolean ordenDepart;
    
    public Buque(TerminalGestionada tg) {
     this.faseActual   = new Outbound();
     this.terminalG    = tg;
     this.ordenWorking = false;
     this.ordenDepart  = false;
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
    	// Asumimos que este mensaje se manda automáticamente cada cierto tiempo para no tener que aplicar un observer
    	// (según clase de consulta).
    	
    	if (this.getfase().condicionFase(this)) {
    		this.faseActual = this.getfase().siguiente() ;
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

	public void addCargasDe(List<Orden> ordenes) {
		for(Orden o : ordenes) {
			this.addCarga(o.getContainer());
		}
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


    public boolean tieneOrdenWorking() {
    	return this.ordenWorking;
    }
    
    public boolean tieneOrdenDepart() {
    	return this.ordenDepart;
    }
    
}
