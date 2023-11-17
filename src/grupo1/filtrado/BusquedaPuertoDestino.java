package grupo1.filtrado;

import java.util.*;
import java.util.stream.Collectors;

import grupo1.Terminal;
import grupo1.circuito.Circuito;

public class BusquedaPuertoDestino extends Buscador{
	 private Terminal terminalDestino;

	    public BusquedaPuertoDestino(Terminal terminalDestino) {
	        this.terminalDestino = terminalDestino;
	    }

	  @Override
	  public ArrayList<Circuito> buscar(ArrayList<Circuito> lista) {
		  /*falta ver como carajo le puedo pasar la terminal gestionada como parametro dfsjifwdjkfdskjjkdsf
		   * hice lo que pude. Talvex el buscador conoce a la terminal??? creo que si dsps pruebo*/
		   
	      return lista.stream()
	              .filter(circuito -> circuito.incluyeATerminalDespuesDeTerminal(terminalGestionada, terminalDestino))
	              .collect(Collectors.toCollection(ArrayList::new));
	      }
}
