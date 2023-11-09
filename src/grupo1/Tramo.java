package grupo1;


public class Tramo {
    
    private double precio; // creoq ue no ?? dsps reviso
    private int tiempo; // cantidad de horas, mas simple :)
    private Terminal terminalInicio;
    private Terminal terminalFin;

    public Tramo(Terminal tInicio, Terminal tFin, int tiempo, int precio) {
        this.terminalInicio = tInicio;
        this.terminalFin = tFin;
        this.precio = precio;
        this.tiempo = this.tiempoEntre(tInicio, tFin);
    }

    private int tiempoEntre(Terminal tInicio, Terminal tFin) {
        return this.tiempo;
    }

    
    
}
