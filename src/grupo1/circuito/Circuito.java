package grupo1.circuito;

import java.time.LocalDate;
import java.util.*;
import java.util.LinkedHashSet;

import grupo1.Terminal;

public class Circuito {

	private List<Tramo> tramos = new ArrayList<>();
	private LocalDate fechaDeSalida;
   
	public Circuito(LocalDate fechaSalida) {
		this.fechaDeSalida = fechaSalida;
	}
    
    public void addTramo(Tramo tramo) {
    	//Se considera que solo se pueden agregar tramos consecuivos y respetando el orden establecido del Array.
    	//El primer tramo es el de empieza el ciurcuito y el ultimo es el de fin del circuito.
    	this.tramos.add(tramo);
       }
    
    public List<Tramo> getTramos(){
    	return this.tramos;
    }
    
    public LocalDate getFechaDeSalida() {
    	return this.fechaDeSalida;
    }
	
	private Tramo primerTramo() {
		return this.getTramos().get(0);
	}

	private Tramo ultimoTramo() {
		int tamano = getTramos().size();	
		return this.getTramos().get(tamano -1 );
	}

	public List<Terminal> terminalesRecorridas() {
		// Primero lo guardo en un set para que no haya repetidos.
		LinkedHashSet<Terminal> terminalesRecorridas = new LinkedHashSet<>();

		for (Tramo tramo : this.getTramos()) {
			terminalesRecorridas.add(tramo.getTerminalInicio());
			terminalesRecorridas.add(tramo.getTerminalLlegada());
		}

		return new ArrayList<>(terminalesRecorridas); // Convierto el conjunto a una lista para el retorno.
	}

	public boolean incluyeATerminal(Terminal terminal) {

		return this.terminalesRecorridas().contains(terminal);

	}

	public boolean incluyeATerminalDespuesDeTerminal(Terminal terminalGestionada, Terminal terminalDestino) {

		return incluyeATerminal(terminalGestionada) && incluyeATerminal(terminalDestino) && (posicionDeTerminal_EnRecorrido(terminalGestionada) > posicionDeTerminal_EnRecorrido(terminalDestino));

	}

	public int posicionDeTerminal_EnRecorrido(Terminal terminal) {
		// PRECONDICIÓN: La terminal dada debe existir en el recorrido.
		for (int i = 0 ; i < this.terminalesRecorridas().size() ; i++) {
			if (this.terminalesRecorridas().get(i).equals(terminal)) {
				return i;
			}
		}
		return -1; // Nunca debería retornar este valor.
	}
   
	public int precioTotalDeCircuito() {
   		int precioTotal = 0;
   		for (Tramo tramo : this.tramos) {
   			precioTotal += tramo.getPrecio();
   		}
   		return precioTotal;
   	}
    
	//
    public LocalDate getFechaSalidaTramo(Tramo tramo) {
    	// PRECONDICIÓN: El tramo dado debe existir en el circuito.
    	LocalDate fecha = this.getFechaDeSalida();
    	for (Tramo t : tramos) {
    		if(t != tramo) {
    			fecha = fecha.plusDays(t.getTiempo());
    		}
    	}
    		
    	return fecha;
    }
    
    //
 }

/* ELIMINADOS (?:

	public boolean incluyeATerminal(Terminal terminal) {
		Recorrido buscando la terminal parametrizada en nuestros tramos de llegada, analizando el caso borde
		de que la terminal sea la terminal de partida del circuito 
	   
		Terminal primeraTerminal = this.primerTramo().getTerminalInicio();
		boolean resultado = primeraTerminal.equals(terminal);
	   
		while(!resultado) {
			for(Tramo t : tramos ) {
				resultado = t.getTerminalLlegada().equals(terminal);
			}
		}  
		   return resultado;
		   
		   *
		   *
		  segun chat gpt tira bucle infinito ^^ 
		  
		//bsuco caso borde de que sea la primera terminal de todo el circuito
	    Terminal primeraTerminal = this.primerTramo().getTerminalInicio();
	    boolean resultado = primeraTerminal.equals(terminal);
	}

	public boolean incluyeATerminal(Terminal terminal) {
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
	        encontreGestionada = tramo.getTerminalInicio().equals(terminalGestionada);
	        //chequeo  si ya encontre la gestionada y ahora encuento la destino
	        estaDestinoDespuesDeGestionada = encontreGestionada && (tramo.getTerminalInicio().equals(terminalDestino) || tramo.getTerminalLlegada().equals(terminalDestino));
	    }
	    return estaDestinoDespuesDeGestionada;
   }
   
 */

