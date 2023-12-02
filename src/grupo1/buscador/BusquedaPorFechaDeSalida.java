package grupo1.buscador;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import grupo1.circuito.Circuito;

public class BusquedaPorFechaDeSalida extends Busqueda{
	 
	private LocalDate fechaSalidaDeseada;

	public BusquedaPorFechaDeSalida(LocalDate fechaSalidaDeseada) {
		this.fechaSalidaDeseada = fechaSalidaDeseada;
	}

	@Override
	public ArrayList<Circuito> buscar(ArrayList<Circuito> lista) {
		//circuitos que salen de la terminal gestionada en la fecha de salida deseada
		return lista.stream()
				.filter(circuito -> circuito.getFechaDeSalida().isEqual(fechaSalidaDeseada))
				.collect(Collectors.toCollection(ArrayList::new));
	}
}