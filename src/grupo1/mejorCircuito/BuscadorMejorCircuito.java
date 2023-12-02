package grupo1.mejorCircuito;

import java.util.*;

import grupo1.Terminal;
import grupo1.circuito.Circuito;

public interface BuscadorMejorCircuito {
	 public ArrayList<Circuito> mejorCircuito(ArrayList<Circuito> circuitos,Terminal terminalA, Terminal terminalB);
}
