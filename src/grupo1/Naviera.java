package grupo1;

import java.util.*;

public class Naviera {

    private List<Circuito> circuitos;
    
    public Naviera() {
        this.circuitos = new ArrayList<>();
    }

    public void addCircuito(Circuito circuito) {
        this.circuitos.add(circuito);
    }

    public ArrayList<Circuito> circuitosQuePasanPorTerminal(Terminal terminal){
    	
        ArrayList<Circuito> circuitosQuePasanPorLaTeminalDada = new ArrayList<>();
        
        for (Circuito circuito : this.circuitos) {
            if (circuito.incluyeATerminal(terminal)) {
            	circuitosQuePasanPorLaTeminalDada.add(circuito);
            };
        }
        return circuitosQuePasanPorLaTeminalDada;
    }
}
