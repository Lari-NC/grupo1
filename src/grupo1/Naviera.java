public class Naviera {
    
    private Set<Circuito> circuitos;
    
    public Naviera() {
        this.circuitos = new Set<Circuito>();
    }

    public void addCircuito(Circuito circuito) {
        this.circuitos.add(circuito);
    }
}
