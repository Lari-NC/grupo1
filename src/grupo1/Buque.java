package grupo1;

import java.util.*;

public class Buque {

    private List<Container> cargas ;
    
    public Buque() {
        this.cargas = new ArrayList<>();
    }

    public ArrayList<Container> getCargas() {
        return this.cargas;
        // help
    }

    public void addCarga(Container carga) {
        this.cargas.add(carga);
    }
}
