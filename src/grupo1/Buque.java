package grupo1;

public class Buque {

    private Set<Container> cargas;
    
    public Buque() {
        this.cargas = new Set<Container>();
    }

    public Set<Container> getCargas() {
        return this.cargas
    }

    public void addCarga(Container carga) {
        this.cargas.add(carga);
    }
}
