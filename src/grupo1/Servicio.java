public class Servicio {

    private double precioFijo;

    public Servicio(double precio) {
        this.precioFijo = precio
    }

    public abstract double getPrecioFijo();
}