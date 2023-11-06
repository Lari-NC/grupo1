public class Tramo {
    
    private double precio;
    private LocalTime tiempo;
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
