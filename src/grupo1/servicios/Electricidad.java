package grupo1.servicios;

import grupo1.containers.Container;
import grupo1.containers.Reefer;

public class Electricidad extends Servicio{
    
    public Electricidad(int precio) {
        super(precio);
    }
    
    
    public double getPrecioPara(Container container) {
    	//se asume que solo se le aplica a reefers
    	//se aplica como el almacenamiento, uno por dia que esta en la terminal esperando el retiro
    	
        Reefer reefer = (Reefer) container; //dowcastear para poder pedirle el consumo
        double consumo = reefer.getConsumo(); 
        return consumo * getPrecio() * 24; 
    }
}