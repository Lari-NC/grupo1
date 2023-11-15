package grupo1;

public class Arrived extends Fase{
    
    public Arrived() {
        super();
    }
    
    @Override
    public boolean verificarCambioFase(Buque buque) {
    	
    	if(buque.tieneOrdenWorking() ) {
    		return true;
    	}
    	return false;
    }
    
    @Override
    public Fase siguiente() {
    	return new Working();
    
    }

}