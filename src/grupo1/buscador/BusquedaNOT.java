package grupo1.buscador;

import java.util.ArrayList;

import grupo1.circuito.Circuito;

public class BusquedaNOT implements Busqueda {
	private Busqueda filtro;

    public BusquedaNOT(Busqueda filtro) {
        this.filtro = filtro;
    }

    @Override
    public ArrayList<Circuito> buscar(ArrayList<Circuito> lista) {
    	// Remueve de mi lista de circuitos, todos los que cumplen la condicion de filtrado
    	ArrayList<Circuito> resultadoBusqueda = filtro.buscar(lista);
        lista.removeAll(resultadoBusqueda);
        return lista;
    }
}
