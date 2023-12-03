package grupo1.buscador;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import grupo1.Terminal;
import grupo1.circuito.Circuito;

public class BusquedaPorFechaDeLlegada extends Busqueda{
	 
	private LocalDate fechaLlegadaDeseada;
	private Terminal terminalDestino;

	public BusquedaPorFechaDeLlegada(Terminal terminalDestino, LocalDate fechaLlegadaDeseada) {
		this.fechaLlegadaDeseada = fechaLlegadaDeseada;
		this.terminalDestino  = terminalDestino;
	}

	@Override
	public ArrayList<Circuito> buscar(ArrayList<Circuito> lista) {
		// Denota de los circuitos dados, los que llegan a la terminal destino antes de la fecha deseada
		return lista.stream()
				.filter(circuito -> circuito.llegaEnLaFecha(this.terminalDestino, this.fechaLlegadaDeseada))
				.collect(Collectors.toCollection(ArrayList::new));
	}
}