package grupo1.servicios;

public class Servicio {

    private int precio;

    public Servicio(int precio) {
        this.precio = precio
    }

    public abstract int getPrecio();
}