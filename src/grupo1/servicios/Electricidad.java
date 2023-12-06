package grupo1.servicios;

import grupo1.containers.Container;
import grupo1.containers.Reefer;

public class Electricidad extends Servicio{
    
    public Electricidad(int precio) {
        super(precio);
    }
    
    public int getPrecioPara(Container container) {
    	// PRECONDICIÓN: Sólo aplica a Reefers
    	// OBSERVACIÓN: el cliente DEBE declarar cuantos dias quiere su container conectado en la orden
    	//representado como la cantidad de servicios que se le aplican al container.
    	
        Reefer reefer = (Reefer) container; //dowcastear para poder pedirle el consumo
        
        double consumo = reefer.getConsumo(); 
        return (int) consumo * this.getPrecio() * 24; 
    }
}