package grupo1;

import java.util.*;

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
    
    
    public int getDistancia(TerminalGestionada terminal) {
    	// creoq ue poodrias er todo si o si respecto anuestra gesrionada en vewz de saber donde esta  
    	Posicion posicionB = this.getPosicion();
    	Posicion posicionT = terminal.getPosicion();
    	return posicionB.distanciaEntre(posicionT);
    	
    }
    
    public void actualizarFase() {
    	
    	if (this.getfase().verificarCambioFase(this)) {
    		this.faseActual = this.getfase().siguiente() ;
    	}
    }
    

}
