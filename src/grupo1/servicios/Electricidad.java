package grupo1.servicios;

import grupo1.containers.Container;
import grupo1.containers.Reefer;

public class Electricidad extends Servicio{
    
    public Electricidad(int precio) {
        super(precio);
    }
    
    
    public double getPrecioPara(Container container) {
    	//se asume que solo se le aplica a reefers
    	//habria que ver una como la de el amacenamiento que cuente las horas que est
    	//y le aplique esa cantidad de "servicios" pero franco no lo hizo asiq ue finjamos demencia??
    	
        Reefer reefer = (Reefer) container; //dowcastear para poder pedirle el consumo
        double consumo = reefer.getConsumo();
        
        return consumo * getPrecio(); 
    }
}