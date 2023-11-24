package grupo1.filtrado;

import java.util.List;

import grupo1.circuito.Circuito;

public class FiltroAND extends Binario {

	  public FiltroAND(Busqueda filtro1, Busqueda filtro2) {
	        super(filtro1, filtro2);
	    }

    @Override
    public List<Circuito> buscar(List<Circuito> lista) {
    	
    	// Filtro los resultados en base a mi primer filtro sobre la lista original
    	List<Circuito> resultadoFiltro = getFiltro1().buscar(lista);
        
    	// Vuelvo a filtrar el resultado del primer filtro en base a mi segundo
        resultadoFiltro = getFiltro2().buscar(resultadoFiltro);
  
        return resultadoFiltro;
    }
}
