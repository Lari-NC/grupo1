package grupo1.filtrado;

import java.util.ArrayList;

import grupo1.circuito.Circuito;

public class FiltroOR extends Binario {

	public FiltroOR(Buscador filtro1, Buscador filtro2) {
		super(filtro1, filtro2);
	}

    @Override
    public ArrayList<Circuito> buscar(ArrayList<Circuito> lista) {
    	
    	/*se hacen copias de la lista apra no taparlas y se filtra una concdicion a la vez*/
        ArrayList<Circuito> resultadoFiltro1 = getFiltro1().buscar(new ArrayList<>(lista));
        ArrayList<Circuito> resultadoFiltro2 = getFiltro2().buscar(new ArrayList<>(lista));
        
    	/*se suman los resultados de las listas resultantes*/
        resultadoFiltro1.addAll(resultadoFiltro2);

        return resultadoFiltro1;
    }
}
