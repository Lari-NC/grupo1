package grupo1;

import java.util.*;

public class Buque {

	private List<Container> cargas = new ArrayList<>();
    
    public Buque() {
        this.cargas = new ArrayList<>();
    }

    public List<Container> getCargas() {
        return this.cargas;
    }

    public void addCarga(Container carga) {
        this.cargas.add(carga);
    }
}
