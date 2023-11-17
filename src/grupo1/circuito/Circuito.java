package grupo1.circuito;

import java.util.*;

import grupo1.Terminal;

public class Circuito {

    private List<Tramo> tramos = new ArrayList<>();
   
    
    
    
    public void addTramo(Tramo tramo) {
    	//Se copnsidera que solo se peden agregar tramos consecuivos y respetando el orden establecido del Array.
    	//El primer tramo es el de empieza el ciurcuito y el ultimo es el de fin del circuito
    	this.tramos.add(tramo);
       }
    
   public List<Tramo> getTramos(){
	   return this.tramos;
   }
	
	private Tramo primerTramo() {
		return this.getTramos().get(0);
	}

	private Tramo ultimoTramo() {
		
		int tamano = getTramos().size();	
		return this.getTramos().get(tamano -1 );
		
		}
    
   public boolean incluyeATerminal(Terminal terminal) {
	   /*Recorrido buscando la terminal parametrizada en nuestros tramos de llegada, analizando el caso borde
	   de que la terminal sea la terminal de partida del circuito 
	   
	   Terminal primeraTerminal = this.primerTramo().getTerminalInicio();
	   boolean resultado =  primeraTerminal.equals(terminal);
	   
	   while(!resultado) {
		   for(Tramo t : tramos ) {
			   resultado = t.getTerminalLlegada().equals(terminal);
		   }
	   }  
		   return resultado;
		   
		   *
		   *
		  segun chat gpt tira bucle infinito ^^  */
	   
	   	//bsuco caso borde de que sea la primera terminal de todo el circuito
	    Terminal primeraTerminal = this.primerTramo().getTerminalInicio();
	    boolean resultado = primeraTerminal.equals(terminal);

	    // Recorrido buscando la terminal en los tramos de llegada
	    for (Tramo t : this.getTramos()) {
	        // Verificar si la terminal es la terminal de llegada en algún tramo
	        if (t.getTerminalLlegada().equals(terminal)) {
	            resultado = true;
	        }
	    }

	    return resultado;
	}
	
   public boolean incluyeATerminalDespuesDeTerminal(Terminal terminalGestionada, Terminal terminalDestino) {
	  //mucho texto pero funciona no quiero tocarlo
	  
	    boolean encontreGestionada = false;
	    boolean estaDestinoDespuesDeGestionada = false;
	    
	    for (Tramo tramo : this.getTramos()) {
	    	//chequeo si encuentro la gestionada(primero)
	        if (tramo.getTerminalInicio().equals(terminalGestionada)) {
	            encontreGestionada = true;
	        }
	        //chequeo  si ya encontre la gestionada y ahora encuento la destino
	        if (encontreGestionada && (tramo.getTerminalInicio().equals(terminalDestino) || tramo.getTerminalLlegada().equals(terminalDestino) )) {
	        
	        	estaDestinoDespuesDeGestionada = true;
	        }
	    }
	    
	    return estaDestinoDespuesDeGestionada;
	    
	} 
   	   
	   
 }

