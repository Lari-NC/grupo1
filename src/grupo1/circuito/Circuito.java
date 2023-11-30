package grupo1.circuito;

import java.time.LocalDate;
import java.util.*;

import grupo1.Terminal;

public class Circuito {

	private List<Tramo> tramos = new ArrayList<>();
	private LocalDate fechaDeSalida;
   
	public Circuito(LocalDate fechaSalida) {
		this.fechaDeSalida = fechaSalida;
	}
    
    public void addTramo(Tramo tramo) {
    	// Se considera que solo se pueden agregar tramos consecuivos y respetando el orden establecido del Array.
    	this.tramos.add(tramo);
       }
    
    // GETTERS: 
    public List<Tramo> getTramos(){
    	return this.tramos;
    }
    
    public LocalDate getFechaDeSalida() {
    	return this.fechaDeSalida;
    }
	
	private Tramo getPrimerTramo() {
		return this.getTramos().get(0);
	}

	public LocalDate getFechaSalidaTramo(Tramo tramo) {
    	// PRECONDICIÓN: El tramo dado debe existir en el circuito.
    	LocalDate fecha = this.getFechaDeSalida();
    	for (Tramo t : tramos) {
    		if(!t.equals(tramo)) {
    			fecha = fecha.plusDays(t.getTiempo());
    			break;
    		}
    	}
    	return fecha;
    }
	
	public LocalDate getFechaLlegadaTramo(Tramo tramo) {
		// PRECONDICIÓN: El tramo dado debe existir en el circuito.
    	LocalDate fecha = this.getFechaDeSalida();
    	for (Tramo t : tramos) {
    		if(!t.equals(tramo)) {
    			fecha = fecha.plusDays(t.getTiempo());
    		}
    		else {
    			fecha = fecha.plusDays(t.getTiempo() - 1);
    			break;
    		}
    	}
    	return fecha; 
	}
	
	public List<Terminal> terminalesRecorridas() {
		
		List<Terminal> terminalesRecorridas = new ArrayList<>();
		terminalesRecorridas.add((this.getPrimerTramo()).getTerminalInicio());	
		for(Tramo tramo : this.getTramos()) {
			terminalesRecorridas.add(tramo.getTerminalLlegada());
		}
		return terminalesRecorridas; 
	}
	
	public int posicionDeTerminalEnRecorrido(Terminal terminal) {
		// PRECONDICIÓN: La terminal dada debe existir en el recorrido.
		for (int i = 0 ; i < this.terminalesRecorridas().size() ; i++) {
			if (this.terminalesRecorridas().get(i).equals(terminal)) {
				return i;
			}
		}
		return -1; // Nunca debería retornar este valor.
	}
   
	public int getPrecioTotalDeCircuito() {
   		int precioTotal = 0;
   		for (Tramo tramo : this.tramos) {
   			precioTotal += tramo.getPrecio();
   		}
   		return precioTotal;
   	}
	

	public int getTiempoTotal() {
		int tiempoTotal = 0;
		for (Tramo t : tramos) {
			tiempoTotal += t.getTiempo();
		}
		return tiempoTotal;
	}
	
	public Tramo getTramoConSalidaDesde(Terminal terminalSalida) {
		// PRECONDICIÓN: Existe un tramo con salida desde esta terminal.
		for(Tramo tramo : this.getTramos()) {
			if(tramo.getTerminalInicio().equals(terminalSalida)) {
				return tramo;
			}
		}
		return this.getPrimerTramo(); // Esto no debe suceder, si el retorno resulta ser el primer tramo es 
									  // casualidad pero debe haberse dado en la rama del if.
	}
	

	// TESTING:
	public boolean incluyeATerminal(Terminal terminal) {
		return this.terminalesRecorridas().contains(terminal);
	}

	public boolean incluyeATerminalAntesDeTerminal(Terminal terminalA, Terminal terminalB) {

		return incluyeATerminal(terminalA) && 
			   incluyeATerminal(terminalB) && 
			   (posicionDeTerminalEnRecorrido(terminalA) < posicionDeTerminalEnRecorrido(terminalB));
	}
	
	public boolean incluyeATerminalDespuesDeTerminal(Terminal terminalA, Terminal terminalB) {	
		// En nuestro caso la terminalA siempre debería ser la gestionada.
		return incluyeATerminal(terminalA) && 
			   incluyeATerminal(terminalB) && 
			   (posicionDeTerminalEnRecorrido(terminalA) > posicionDeTerminalEnRecorrido(terminalB));
	}
	
	public boolean saleDeTerminalEnLaFecha(Terminal terminalSalida, LocalDate fecha) {
		// En nuestro caso la terminal de origen siempre debería ser la gestionada.
		// NOTA: Usé streams para evitar que con un for siga iterando a pedar de haber 
		// encontrado una coincidencia y que lo haga con mayor legibilidad.
		return tramos.stream()
				.anyMatch(tramo -> tramo.getTerminalInicio().equals(terminalSalida) &&
						  this.getFechaSalidaTramo(tramo).equals(fecha));
	}
	
	public boolean llegaEnLaFecha(Terminal terminalDestino, LocalDate fecha) {
		// En nuestro caso la terminal de origen siempre debería ser la gestionada.
		// NOTA: Usé streams para evitar el miedo al booleano con un if addentro de 
		// un for que retorne directamente true o false.
		return tramos.stream()
                .anyMatch(tramo -> (this.getFechaLlegadaTramo(tramo).isBefore(fecha))&&(tramo.getTerminalLlegada().equals(terminalDestino)));
	}
	
	public Circuito crearCircuitoEspecificoPara_Y_(Terminal terminalInicial, Terminal TerminalFinal) {
		Circuito circuitoEspecifico = new Circuito(this.fechaDeSalida);
		List<Tramo> listaDeTramosAcordada = this.getTramos().subList(this.posicionDeTramoConTerminalInicial(terminalInicial), this.posicionDeTramoConTerminalFinal(TerminalFinal)+1);
		circuitoEspecifico.getTramos().addAll(listaDeTramosAcordada);
		return circuitoEspecifico;
	}
	
	public int posicionDeTramoConTerminalInicial(Terminal terminalInicial) {
		for (int i = 0; i < this.getTramos().size(); i++) {
            if (this.getTramos().get(i).getTerminalInicio().equals(terminalInicial)) {
                return i; // Elemento encontrado, devuelve el índice
            }
        }
        return -1; // Elemento no encontrado
	}
	
	public int posicionDeTramoConTerminalFinal(Terminal terminalFinal) {
		for (int i = 0; i < this.getTramos().size(); i++) {
            if (this.getTramos().get(i).getTerminalLlegada().equals(terminalFinal)) {
                return i; // Elemento encontrado, devuelve el índice
            }
        }
        return -1; // Elemento no encontrado
	}
 }


