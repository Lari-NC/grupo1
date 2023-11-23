package grupo1.servicios;

import grupo1.containers.Container;

public class Lavado extends Servicio{
	
    public Lavado(int precio) {
        super(precio);
    }
    
    public int precioSiNoSuperaElVolumen() {
    	return this.getPrecio();
    }
    
    public int precioSiSuperaElVolumen() {
    	return this.getPrecio() * 2;
    }
    
    public int volumenAptoPrecioMinimo() {
    	return 70;
    }
    
    public int getPrecioPara(Container container) {
    	
    	if(container.metrosCubicos() > this.volumenAptoPrecioMinimo()) {
    		return this.precioSiSuperaElVolumen();
    	}
    	else {
    		return this.precioSiNoSuperaElVolumen();
    	}
    }
    
}
