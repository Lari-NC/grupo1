package grupo1;

public class Naviera {
    
    private Set<Circuito> circuitos;
    
    public Naviera() {
        this.circuitos = new Set<Circuito>();
    }

    public void addCircuito(Circuito circuito) {
        this.circuitos.add(circuito);
    }

    public Array<Circuito> circuitosQuePasanPor(Terminal terminal){
        Array<Circuito> circuitosQuePasanPorLaTeminalDada = new Array<Circuito>();
        for (Circuito circuito : this.circuitos) {
            circuitosQuePasanPorLaTeminalDada.add(circuito.circuitosQueIncluyenATerminal(terminal));
        }
        return circuitosQuePasanPorLaTeminalDada;
    }
}
