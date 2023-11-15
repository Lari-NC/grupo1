package grupo1;

public class Inbound extends Fase{
    
    public Inbound() {
        super();
    }
    
    @Override
    public boolean verificarCambioFase(Buque buque) {
    	
    	if(buque.getPosicion() = 0 ) {
    		return true;
    	}
    	return false;
    }
    
    @Override
    public Fase siguiente() {
    	return new Arrived();
    
    }
}
