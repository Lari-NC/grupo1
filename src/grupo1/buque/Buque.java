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
    // en todas las fases ahora maneja la posicion comoo distancia a la termianl, supongo que eso hayq ue arreglarlo muchisimo
    
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
    
    
    public /*int*/ getDistancia(TerminalGestionada terminal) {
    	// problema, deberia concoer a al terminal en vez de ser parametrizado,
    	//porque sino pierdo el polimorfismo de las fases comentente el int asi sale error y lo ven 
    	Posicion posicionB = this.getPosicion();
    	Posicion posicionT = terminal.getPosicion();
    	return posicionB.distanciaEntre(posicionT);
    	
    }
    
    public void actualizarFase() {
    	
    	if (this.getfase().condicionFase(this)) {
    		this.faseActual = this.getfase().siguiente() ;
    	}
    }
    

}
