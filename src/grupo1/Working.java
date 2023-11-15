package grupo1;

public class Working extends Fase{
    
    public Working() {
        super();
    }
    
    @Override
    public boolean verificarCambioFase(Buque buque) {
    	
    	if(buque.tieneOrdenDepart() ) {
    		return true;
    	}
    	return false;
    }
    
    @Override
    public Fase siguiente() {
    	return new Departing();
    
    }

}