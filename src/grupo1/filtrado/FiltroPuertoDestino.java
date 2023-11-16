package grupo1.filtrado;

import java.util.*;
import java.util.stream.Collectors;

import grupo1.Terminal;
import grupo1.circuito.Circuito;

public class FiltroPuertoDestino extends Filtrador{
	 private Terminal terminalDestino;

	    public FiltroPuertoDestino(Terminal terminalDestino) {
	        this.terminalDestino = terminalDestino;
	    }

	  @Override
	  public ArrayList<Circuito> evaluar(ArrayList<Circuito> lista) {
		  /*evalua mi lista de circuitos que le de y me devuelve una nuieva lista con los
		   * que tengan mi puerto de llegada como un puerto de destino. No considera casos bordes ej:
		   * esta atras en el circuito,, no me pidan mucho soy solo una chica :(  dsps sigo
		   */
	      return lista.stream()
	              .filter(circuito -> circuito.incluyeATerminal(terminalDestino))
	              .collect(Collectors.toCollection(ArrayList::new));
	      }
}
