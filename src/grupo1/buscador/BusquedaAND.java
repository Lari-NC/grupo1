package grupo1.buscador;

import java.util.ArrayList;

import grupo1.circuito.Circuito;

public class BusquedaAND extends Binario {

	  public BusquedaAND(Busqueda busqueda1, Busqueda busqueda2) {
	        super(busqueda1, busqueda2);
	    }

    @Override
    public ArrayList<Circuito> buscar(ArrayList<Circuito> lista) {
    	
    	// Filtro los resultados en base a mi primer filtro sobre la lista original
    	ArrayList<Circuito> resultadoBusqueda = getBusqueda1().buscar(lista);
        
    	// Vuelvo a filtrar el resultado del primer filtro en base a mi segundo
        resultadoBusqueda = getBusqueda2().buscar(resultadoBusqueda);
  
        return resultadoBusqueda;
    }
}
