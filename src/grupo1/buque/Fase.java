package grupo1.buque;


public abstract class Fase {
    
    public Fase() {}
    
    
    public abstract boolean verificarCambioFase(Buque buque);
    
    public abstract Fase siguiente();
    
}
