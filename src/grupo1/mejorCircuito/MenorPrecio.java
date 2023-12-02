package grupo1.mejorCircuito;

import java.util.ArrayList;
import java.util.Comparator;

import grupo1.circuito.Circuito;

public class MenorPrecio implements BuscadorMejorCircuito {

	@Override
	public Circuito mejorCircuito(ArrayList<Circuito> circuitos){
		return 	circuitos.stream()
	            .min(Comparator.comparing(circuito -> circuito.getPrecioTotalDeCircuito()))
	            .orElse(null);
	}
}