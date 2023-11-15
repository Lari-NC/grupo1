package grupo1;

import java.util.*;

public class Circuito {

    private List<Tramo> tramos = new ArrayList<>();
   
    
    
    
    public void addTramo(Tramo tramo) {
    	//Se copnsidera que solo se peden agregar tramos consecuivos y respetando el orden establecido del Array.
    	//El primer tramo es el de empieza el ciurcuito y el ultimo es el de fin del circuito
    	this.tramos.add(tramo);
       }
    
   public List<Tramo> getTramos(){
	   return this.tramos;
   }
     
   public Date getFechaSalida() {
	   Date fechaSalida = primerTramo().getFechaSalida();
	   return   fechaSalida;
   }

	private Tramo primerTramo() {
		return this.tramos.get(0);
	}
	
	public Date getFechaLlegada() {
		Date fechaLlegada = ultimoTramo().getFechaLlegada();
		return   fechaLlegada;
	   }

	private Tramo ultimoTramo() {
		
		int tamano = tramos.size();	
		return this.tramos.get(tamano -1 );
		
		}
    
   public boolean incluyeATerminal(Terminal terminal) {
	   /*Recorrido buscando la terminal parametrizada en nuestros tramos de llegada, analizando el caso borde
	   de que la terminal sea la terminal de partida del circuito */
	   
	   Terminal primeraTerminal = this.primerTramo().getTerminalInicio();
	   boolean resultado =  primeraTerminal == terminal;
	   
	   while(!resultado) {
		   for(Tramo t : tramos ) {
			   resultado = t.getTerminalLlegada() == terminal;
		   }
	   }  
		   return resultado;
	}
	 
	   
	   
 }

