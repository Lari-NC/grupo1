package grupo1.filtrado;

import java.util.ArrayList;

import grupo1.circuito.Circuito;

public class FiltroNOT extends Buscador {
	private Buscador filtro;

    public FiltroNOT(Buscador filtro) {
        this.filtro = filtro;
    }

    @Override
    public ArrayList<Circuito> buscar(ArrayList<Circuito> lista) {
    	/*Saca de mi lista de circuitos, todos los que cumplen la condicion de filtrado*/
    	
        ArrayList<Circuito> resultadoFiltro = filtro.buscar(lista);
        lista.removeAll(resultadoFiltro);
        return lista;
    }
	

}
