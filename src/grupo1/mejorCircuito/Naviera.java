package grupo1.mejorCircuito;

import java.util.*;
import java.util.stream.Collectors;

import grupo1.Terminal;
import grupo1.circuito.Circuito;

public class Naviera {

    private List<Circuito> circuitos = new ArrayList<>();
    private BuscadorMejorCircuito buscadorNaviera;
    
    public Naviera(BuscadorMejorCircuito buscadorNaviera){
    	 this.buscadorNaviera = buscadorNaviera;
    }
    
    public List<Circuito> getCircuitos(){
    	return this.circuitos;
    }
    
    public void setBuscador(BuscadorMejorCircuito buscador) {
        this.buscadorNaviera = buscador;
    }
    
    public BuscadorMejorCircuito getBuscador() {
        return this.buscadorNaviera;
    }
    
    public void addCircuito(Circuito circuito) {
    	this.circuitos.add(circuito);
    }
    
    public Circuito buscarMejorCircuitoQueConecta(Terminal terminalA, Terminal terminalB) {
 
    	return this.getBuscador().mejorCircuito(this.getCircuitosQueConectanTerminalAYTerminalB(terminalA, terminalB)); 
    }
    
    
    

    public ArrayList<Circuito> getCircuitosQueConectanTerminalAYTerminalB(Terminal terminalA, Terminal terminalB) {
       
        return getCircuitos().stream()
                .filter(circuito -> circuito.incluyeATerminalAntesDeTerminalB(terminalA, terminalB))
                .map(circuito -> {
                    	circuito.crearCircuitoEspecificoPara_Y_(terminalA, terminalB);
                    	return circuito;	})
                .collect(Collectors.toCollection(ArrayList::new));	
    }

	public List<Circuito> circuitosQuePasanPorTerminal(Terminal terminal){
		return 	getCircuitos().stream()
	            .filter(circuito -> circuito.incluyeATerminal(terminal))
	            .collect(Collectors.toCollection(ArrayList::new));
    }
    
    public int tiempoDeViajeDesdeHastaTerminal(Terminal terminalA, Terminal terminalDestino) {
    	return 	getCircuitos().stream()
                .filter(circuito -> circuito.incluyeATerminalAntesDeTerminalB(terminalA, terminalDestino))
                .mapToInt(circuito -> circuito.crearCircuitoEspecificoPara_Y_(terminalA, terminalDestino).getTiempoTotal())
                .min()
                .orElse(0);
    }
}
