package grupo1.filtrado;

import java.util.ArrayList;
import grupo1.circuito.Circuito;

public class FiltroOR extends Binario {

	public FiltroOR(Busqueda filtro1, Busqueda filtro2) {
		super(filtro1, filtro2);
	}

    @Override
    public ArrayList<Circuito> buscar(ArrayList<Circuito> lista) {
    	
    	// Se hacen copias de la lista para no sobreescribirlas y se filtra una condición a la vez
    	ArrayList<Circuito> resultadoFiltro1 = getFiltro1().buscar(new ArrayList<>(lista));
    	ArrayList<Circuito> resultadoFiltro2 = getFiltro2().buscar(new ArrayList<>(lista));
        
    	// Se combinan los resultados de ambas listas resultantes anteriormente
        resultadoFiltro1.addAll(resultadoFiltro2);

        return resultadoFiltro1;
    }
}
