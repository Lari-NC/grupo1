package grupo1;

public class Outbound extends Fase{
    
    public Outbound() {
        super();
    }
    
    @Override
    public boolean verificarCambioFase(Buque buque) {
    	
    	if(buque.getPosicion() <= 50 ) {
    		return true;
    	}
    	return false;
    }
    
    @Override
    public Fase siguiente() {
    	return new Inbound();
    
    }
    
    
}
