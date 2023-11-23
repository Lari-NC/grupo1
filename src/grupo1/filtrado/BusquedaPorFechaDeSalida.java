package grupo1.filtrado;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import grupo1.Terminal;
import grupo1.circuito.Circuito;

public class BusquedaPorFechaDeSalida extends Buscador{
	 
	private LocalDate fechaSalidaDeseada;
	private Terminal terminalOrigen;

	public BusquedaPorFechaDeSalida(Terminal terminalOrigen, LocalDate fechaSalidaDeseada) {
		this.fechaSalidaDeseada = fechaSalidaDeseada;
		this.terminalOrigen     = terminalOrigen;
	}

	@Override
	public ArrayList<Circuito> buscar(ArrayList<Circuito> lista) {
		
		return lista.stream()
				.filter(circuito -> circuito.saleDeTerminalEnLaFecha(this.terminalOrigen, this.fechaSalidaDeseada))
				.collect(Collectors.toCollection(ArrayList::new));
	}
}