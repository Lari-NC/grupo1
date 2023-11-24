package grupo1;

import java.util.*;

import grupo1.circuito.Circuito;

public class Naviera {

    private List<Circuito> circuitos = new ArrayList<>();
    
    public Naviera(){
    	
    }
    
    public List<Circuito> getCircuitos(){
    	return this.circuitos;
    }
    
    public void addCircuito(Circuito circuito) {
        this.circuitos.add(circuito);
    }

    public List<Circuito> circuitosQuePasanPorTerminal(Terminal terminal){
        List<Circuito> circuitosQuePasanPorLaTeminalDada = new ArrayList<>();
        for (Circuito circuito : this.getCircuitos()) {
            if (circuito.incluyeATerminal(terminal)) {
            	circuitosQuePasanPorLaTeminalDada.add(circuito);
            }
        }
        return circuitosQuePasanPorLaTeminalDada;
    }
    
    public int tiempoDeViajeDesdeHastaTerminal(Terminal terminalA, Terminal terminalDestino) {
    	List<Integer> cantidadDeDiasQueTardan = new ArrayList<>(); 
    	for(Circuito c : this.getCircuitos()) {
    		if (c.incluyeATerminalAntesDeTerminal(terminalA, terminalDestino)) {
    			cantidadDeDiasQueTardan.add(c.crearCircuitoEspecificoPara_Y_(terminalA, terminalDestino).getTiempoTotal());
    		}
    	}
    	return Collections.min(cantidadDeDiasQueTardan);
    }
}
