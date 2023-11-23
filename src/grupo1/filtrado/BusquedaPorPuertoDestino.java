package grupo1.filtrado;

import java.util.*;
import java.util.stream.Collectors;

import grupo1.Terminal;
import grupo1.circuito.Circuito;

public class BusquedaPorPuertoDestino extends Buscador{
	 
	private Terminal terminalDestino;
	private Terminal terminalOrigen;

	public BusquedaPorPuertoDestino(Terminal terminalOrigen, Terminal terminalDestino) {
		this.terminalDestino = terminalDestino;
		this.terminalOrigen  = terminalOrigen;
	}

	@Override
	public ArrayList<Circuito> buscar(ArrayList<Circuito> lista) {
		
		return lista.stream()				.filter(circuito -> circuito.incluyeATerminalDespuesDeTerminal(this.terminalOrigen, this.terminalDestino))				.collect(Collectors.toCollection(ArrayList::new));
	}
}
