package grupo1;

import java.util.*;

import grupo1.circuito.Circuito;

public class Naviera {

    private List<Circuito> circuitos = new ArrayList<>();
    
    public Naviera(){}

    public void addCircuito(Circuito circuito) {
        this.circuitos.add(circuito);
    }

    public List<Circuito> circuitosQuePasanPorTerminal(Terminal terminal){
        List<Circuito> circuitosQuePasanPorLaTeminalDada = new ArrayList<>();
        for (Circuito circuito : this.circuitos) {
            if (circuito.incluyeATerminal(terminal)) {
            	circuitosQuePasanPorLaTeminalDada.add(circuito);
            }
        }
        return circuitosQuePasanPorLaTeminalDada;
    }
    
    
}
