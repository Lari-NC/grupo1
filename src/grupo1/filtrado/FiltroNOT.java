package grupo1.filtrado;

import java.util.List;

import grupo1.circuito.Circuito;

public class FiltroNOT extends Busqueda {
	private Busqueda filtro;

    public FiltroNOT(Busqueda filtro) {
        this.filtro = filtro;
    }

    @Override
    public List<Circuito> buscar(List<Circuito> lista) {
    	
    	// Saca de mi lista de circuitos, todos los que cumplen la condicion de filtrado
    	List<Circuito> resultadoFiltro = filtro.buscar(lista);
        lista.removeAll(resultadoFiltro);
        return lista;
    }
	
}
