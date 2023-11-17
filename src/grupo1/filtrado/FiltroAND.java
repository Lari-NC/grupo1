package grupo1.filtrado;

import java.util.ArrayList;

import grupo1.circuito.Circuito;

public class FiltroAND extends Binario {

	  public FiltroAND(Buscador filtro1, Buscador filtro2) {
	        super(filtro1, filtro2);
	    }

    @Override
    public ArrayList<Circuito> buscar(ArrayList<Circuito> lista) {
    	
    	/*Filtro primeor mi primera condicion sobre la lista original*/
        ArrayList<Circuito> resultadoFiltro1 = getFiltro1().buscar(lista);
        
    	/*Vuelvo a filtrar el resultado de el priemr filtro con mi segundo*/
        ArrayList<Circuito> resultadoFiltro2 = getFiltro2().buscar(resultadoFiltro1);
  

        return resultadoFiltro2;
    }
}
