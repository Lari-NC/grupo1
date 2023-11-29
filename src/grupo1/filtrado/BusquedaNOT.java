package grupo1.filtrado;

import java.util.ArrayList;

import grupo1.circuito.Circuito;

public class BusquedaNOT extends Busqueda {
	private Busqueda filtro;

    public BusquedaNOT(Busqueda filtro) {
        this.filtro = filtro;
    }

    @Override
    public ArrayList<Circuito> buscar(ArrayList<Circuito> lista) {
    	
    	// Saca de mi lista de circuitos, todos los que cumplen la condicion de filtrado
    	ArrayList<Circuito> resultadoBusqueda = filtro.buscar(lista);
        lista.removeAll(resultadoBusqueda);
        return lista;
    }
	
}
