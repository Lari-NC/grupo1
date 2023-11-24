package grupo1.filtrado;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import grupo1.Terminal;
import grupo1.circuito.Circuito;

public class BusquedaPorFechaDeLlegada extends Busqueda{
	 
	private LocalDate fechaLlegadaDeseada;
	private Terminal terminalGestionada;

	public BusquedaPorFechaDeLlegada(Terminal terminalGestionada, LocalDate fechaLlegadaDeseada) {
		this.fechaLlegadaDeseada = fechaLlegadaDeseada;
		this.terminalGestionada  = terminalGestionada;
	}

	@Override
	public List<Circuito> buscar(List<Circuito> lista) {
		
		return lista.stream()
				.filter(circuito -> circuito.llegaEnLaFecha(this.terminalGestionada, this.fechaLlegadaDeseada))
				.collect(Collectors.toCollection(ArrayList::new));
	}
}