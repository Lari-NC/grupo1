package grupo1;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import grupo1.buque.Buque;
import grupo1.circuito.Circuito;
import grupo1.circuito.Tramo;

class ViajeTest {
	
	private Terminal terminalA;
	private Terminal terminalB;
	private Terminal terminalC;
	private Terminal terminalD;
	private Terminal terminalE;
	private Tramo tramo1;
	private Tramo tramo2;
	private Tramo tramo3;
	private Tramo tramo4;
	private Circuito circuito;
	private Buque buque;
	private Viaje viaje;
	
    @BeforeEach
    public void setUp() {
    	
    	this.terminalA = mock(Terminal.class);
	    this.terminalB = mock(Terminal.class);
	    this.terminalC = mock(Terminal.class);
	    this.terminalD = mock(Terminal.class);
	    this.terminalE = mock(Terminal.class);
	      
	    this.tramo1 = mock(Tramo.class);
			when(this.tramo1.getTerminalInicio()).thenReturn(terminalA);
		    when(this.tramo1.getTerminalLlegada()).thenReturn(terminalB);
		    when(this.tramo1.getTiempo()).thenReturn(1);
		    when(this.tramo1.getPrecio()).thenReturn(1000);
		    
		this.tramo2 = mock(Tramo.class);
	      	when(this.tramo2.getTerminalInicio()).thenReturn(terminalB);
	      	when(this.tramo2.getTerminalLlegada()).thenReturn(terminalC);
	      	when(this.tramo2.getTiempo()).thenReturn(3);
	      	when(this.tramo2.getPrecio()).thenReturn(2000);
	      	
	    this.tramo3 = mock(Tramo.class);
	      	when(this.tramo3.getTerminalInicio()).thenReturn(terminalC);
	      	when(this.tramo3.getTerminalLlegada()).thenReturn(terminalD);
	      	when(this.tramo3.getTiempo()).thenReturn(3);
	      	when(this.tramo3.getPrecio()).thenReturn(2000);
	      	
	    this.tramo4 = mock(Tramo.class);
	      	when(this.tramo4.getTerminalInicio()).thenReturn(terminalD);
	      	when(this.tramo4.getTerminalLlegada()).thenReturn(terminalE);
	      	when(this.tramo4.getTiempo()).thenReturn(3);
	      	when(this.tramo4.getPrecio()).thenReturn(2000);
	     	
	    this.circuito = new Circuito(LocalDate.of(2023, 11, 15));
	    this.circuito.addTramo(tramo1);
	    this.circuito.addTramo(tramo2);
	    this.circuito.addTramo(tramo3);
	    this.circuito.addTramo(tramo4);
		
		this.buque = mock(Buque.class);
				
    	this.viaje = new Viaje(circuito, buque, terminalB, terminalD);
    }
    
    @Test
    public void testInstanciacionDeViaje() {
    	assertTrue(this.viaje.getCircuito().getTramos().contains(tramo2));
    	assertTrue(this.viaje.getCircuito().getTramos().contains(tramo3));
    	assertEquals(4000, viaje.getPrecioViaje());
    	assertEquals(buque, viaje.getBuque());
    	assertEquals(terminalB, viaje.getTerminalInicial());
    	assertEquals(terminalD, viaje.getTerminalDestino());
    }
}
