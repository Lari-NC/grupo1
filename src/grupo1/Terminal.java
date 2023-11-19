package grupo1;

public class Terminal {
	
	private Posicion posicion;
	//posición deberia ser una interfaz, y terminal deberia implemetarla, para hacer uso de su metodo para obtener distancia.
	  
    public Terminal() {}
    
    public Posicion getPosicion(){
    	return this.posicion;
    }
    
}
