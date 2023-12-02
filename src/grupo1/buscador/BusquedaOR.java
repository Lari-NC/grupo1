package grupo1.buscador;

import java.util.*;

import grupo1.circuito.Circuito;

public class BusquedaOR extends Binario {

	public BusquedaOR(Busqueda busqueda1, Busqueda busqueda2) {
		super(busqueda1, busqueda2);
	}

    @Override
    public ArrayList<Circuito> buscar(ArrayList<Circuito> lista) {
    	
    	// Se hacen copias de la lista para no sobreescribirlas y se filtra una condición a la vez
    	ArrayList<Circuito> resultadoBusqueda1 = getBusqueda1().buscar(new ArrayList<>(lista));
    	ArrayList<Circuito> resultadoBusqueda2 = getBusqueda2().buscar(new ArrayList<>(lista));
        
    	// Se combinan los resultados de ambas listas resultantes anteriormente
        resultadoBusqueda1.addAll(resultadoBusqueda2);

        return resultadoBusqueda1;
    }
}
