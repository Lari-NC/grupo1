package grupo1.filtrado;

import java.util.ArrayList;

import grupo1.circuito.Circuito;

public class FiltroNOT extends Filtrador {
	private Filtrador filtro;

    public FiltroNOT(Filtrador filtro) {
        this.filtro = filtro;
    }

    @Override
    public ArrayList<Circuito> filtrar(ArrayList<Circuito> lista) {
    	/*Saca de mi lista de circuitos, todos los que cumplen la condicion de filtrado*/
    	
        ArrayList<Circuito> resultadoFiltro = filtro.filtrar(lista);
        lista.removeAll(resultadoFiltro);
        return lista;
    }
	

}
