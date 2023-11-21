package grupo1.servicios;

public class Servicio {

    private int precio;

    public Servicio(int precio) {
        this.precio = precio;
    }

    public int getPrecio() {
    	return this.precio;
    };
    
    public String getTipoServicio() {
    	return this.getClass().getSimpleName();
    }
}