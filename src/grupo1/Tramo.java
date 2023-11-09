package grupo1;

public class Tramo {
    
    private double precio;
    private LocalTime tiempo; // lo pasamos a int y que sean cantidad
    private Terminal terminalInicio;
    private Terminal terminalFin;

    public Tramo(Terminal tInicio, Terminal tFin) {
        this.terminalInicio = tInicio;
        this.terminalFin = tFin;
        this.precio = ;
        this.tiempo = this.tiempoEntre(tInicio, tFin);
    }

    private LocalTime tiempoEntre(Terminal tInicio, Terminal tFin) {
        return null;
    }

    
    
}
