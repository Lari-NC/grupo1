package grupo1.servicios;

import grupo1.containers.Container;
import grupo1.containers.Reefer;

public class Electricidad extends Servicio{
    
    public Electricidad(int precio) {
        super(precio);
    }
    
    public int getPrecioPara(Container container) {
    	// PRECONDICIÓN: Sólo aplica a Reefers
    	// OBSERVACIÓN: Se aplica como el almacenamiento (uno por dia que está en la terminal esperando el retiro).
    	
        Reefer reefer = (Reefer) container; //dowcastear para poder pedirle el consumo
        
        double consumo = reefer.getConsumo(); 
        return (int) consumo * this.getPrecio() * 24; 
    }
}