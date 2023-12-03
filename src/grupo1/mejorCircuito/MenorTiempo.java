package grupo1.mejorCircuito;

import java.util.ArrayList;
import java.util.Comparator;

import grupo1.circuito.Circuito;

public class MenorTiempo implements BuscadorMejorCircuito {

	@Override
	public Circuito mejorCircuito(ArrayList<Circuito> circuitos){
		return 	circuitos.stream()
		        .min(Comparator.comparingInt(circuito -> circuito.getTiempoTotal()))
		        .orElse(null);
	}
}