package grupo1.mejorCircuito;

import java.util.ArrayList;
import java.util.Comparator;

import grupo1.circuito.Circuito;

public class MenorCantidadTerminales implements BuscadorMejorCircuito {

	@Override
	public Circuito mejorCircuito(ArrayList<Circuito> circuitos){
		return 	circuitos.stream()
	            .min(Comparator.comparing(circuito -> circuito.getTramos().size()))
	            .orElse(null);
	}
	
}
