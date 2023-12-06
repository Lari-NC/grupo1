package grupo1.servicios;

import grupo1.containers.Container;

public class Servicio {

    protected int precio;

    public Servicio(int precio) {
        this.precio = precio;
    }

    public int getPrecioPara(Container container) {
    	return this.getPrecio();
    }
    
    public String getTipoServicio() {
    	return this.getClass().getSimpleName();
    }

	public int getPrecio() {
		return precio;
	}
}