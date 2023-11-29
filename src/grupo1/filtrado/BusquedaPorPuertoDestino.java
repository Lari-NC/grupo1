package grupo1.filtrado;

import java.util.*;
import java.util.stream.Collectors;

import grupo1.Terminal;
import grupo1.circuito.Circuito;

public class BusquedaPorPuertoDestino extends Busqueda{
	 
	private Terminal terminalDestino;
	

	public BusquedaPorPuertoDestino(Terminal terminalDestino) {
		this.terminalDestino = terminalDestino;

	}

	@Override
	public ArrayList<Circuito> buscar(ArrayList<Circuito> lista) {
		
		return lista.stream()				.filter(circuito -> circuito.incluyeATerminal(this.terminalDestino))				.collect(Collectors.toCollection(ArrayList::new));
	}
}
