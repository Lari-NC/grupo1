package grupo1.buque;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import grupo1.Posicion;
import grupo1.TerminalGestionada;
import grupo1.buque.fases.Arrived;
import grupo1.buque.fases.Departing;
import grupo1.buque.fases.Inbound;
import grupo1.buque.fases.Outbound;
import grupo1.buque.fases.Working;

class BuqueTest {
	
	private Buque buque;
    private Posicion posicionInicialBuque;
    private Posicion posicionTerminal;
    private TerminalGestionada terminalG;
    
	@BeforeEach
	void setUp() throws Exception {
		this.posicionInicialBuque = new Posicion(0,0);
		this.posicionTerminal 	  = new Posicion(50,50);
		this.terminalG 			  = mock(TerminalGestionada.class);
			when(this.terminalG.getPosicion()).thenReturn(posicionTerminal);
		this.buque 				  = new Buque(terminalG,posicionInicialBuque);
	}
	
	@Test
	public void unBuquePuedeCalcularLaDistanciaALaTerminalGestionada() {	
	        int distancia = buque.getDistanciaATerminalGestionada();
	        assertEquals(70, distancia);
	    }
	

	@Test
	public void unBuqueSePuedeMoverSinCambiarDeFase() {
		boolean esOutbound = this.buque.getFase() instanceof Outbound;
		assertTrue(esOutbound);
		
		//mover buque
		Posicion nuevaPosicion = new Posicion(5,5);
		this.buque.actualizarPosicion(nuevaPosicion);
		
	    //asertar que me movi
		int distancia = buque.getDistanciaATerminalGestionada();
		assertEquals(63, distancia);
		
	    //asertar que sigo en outbound
		esOutbound = this.buque.getFase() instanceof Outbound;
		assertTrue(esOutbound);
	}
	
	@Test
	public void unBuqueSeMueveYPasaAFaseInbound() {		//mover buque		Posicion nuevaPosicion = new Posicion(30,20);
	    this.buque.actualizarPosicion(nuevaPosicion);
	     	
	    //asertar que me movi
	    int distancia = buque.getDistanciaATerminalGestionada();
	    assertEquals(36, distancia);
	    
	    //assertar si es inbound la nueva fase
	    boolean esInbound = this.buque.getFase() instanceof Inbound;
	    assertTrue(esInbound);
	    verify(terminalG).recibirBuqueAvisoInbound(buque);
	}
	 
	@Test
	public void unBuqueSeMueveYNOPasaDeFaseInboundAArrived() {
		Posicion posicionInbound = new Posicion(30,20);
	    this.buque.actualizarPosicion(posicionInbound);
	    //primeroPasarAInbound
	        
	    Posicion posicionNotArrived = new Posicion(50,49);
	    this.buque.actualizarPosicion(posicionNotArrived);
	    int distanciaA = buque.getDistanciaATerminalGestionada();
	    assertEquals(1, distanciaA);
	    
	    boolean esArrived = this.buque.getFase() instanceof Arrived ;
	    assertFalse(esArrived);
	}
	
	
	@Test
	public void unBuqueSeMueveYPasaDeFaseInboundAArrived() {
		Posicion posicionInbound = new Posicion(30,20);
	    this.buque.actualizarPosicion(posicionInbound);
	    //primeroPasarAInbound
	        
	    Posicion posicionArrived = new Posicion(50,50);
	    this.buque.actualizarPosicion(posicionArrived);
	    int distanciaA = buque.getDistanciaATerminalGestionada();
	    assertEquals(0, distanciaA);
	    
	    boolean esArrived = this.buque.getFase() instanceof Arrived ;
	    assertTrue(esArrived);
	}
	
	

	
	@Test
	public void laTerminalDaLaOrdenDeWorkingAUnBuqueYPasaDeFaseArrivedAWorking() {
		//Por cosas del mock no se puede testear sin una terminal de verdad,
		//porque verificamos que mandaba el mensaje pero el buque nunca lo recibia (al final comentado)
		
		Posicion posicionTerminal = new Posicion(50,50);
		TerminalGestionada terminalG_T = new TerminalGestionada(posicionTerminal,1,1,1);
		Buque buque_T = new Buque(terminalG_T, posicionInicialBuque);
		
			Posicion posicionInbound = new Posicion(30,20); //outbound
	     	buque_T.actualizarPosicion(posicionInbound); //inbound
	     	buque_T.actualizarPosicion(posicionTerminal); //arrived

	     	terminalG_T.darOrdenWorking(buque_T); 
	     	
	     	assertTrue(buque_T.tieneOrdenWorking());
	     	
	     	buque_T.actualizarPosicion(posicionTerminal); //actualizamos de vuelta apra que cambie la fase
	     	
	     	boolean esWorking = buque_T.getFase() instanceof Working;
	     	assertTrue(esWorking);
	}
	
	@Test
	public void laTermianlDaLaOrdenDeDepartAUnBuqueYPasaDeWorkingADeparting() {
		Posicion posicionTerminal = new Posicion(50,50);
		TerminalGestionada terminalG_T = new TerminalGestionada(posicionTerminal,1,1,1);
		Buque buque_T = new Buque(terminalG_T, posicionInicialBuque);
		
			Posicion posicionInbound = new Posicion(30,20);
	     	buque_T.actualizarPosicion(posicionInbound);
	     	buque_T.actualizarPosicion(posicionTerminal);
	     	terminalG_T.darOrdenWorking(buque_T);   	
	     	buque_T.actualizarPosicion(posicionTerminal);
	     	
	     	terminalG_T.darOrdenDepart(buque_T);
	     	
	     	assertTrue(buque_T.tieneOrdenDepart());
	     	buque_T.actualizarPosicion(posicionTerminal);
	     
	     	boolean esDeparting = buque_T.getFase() instanceof Departing;
	     	assertTrue(esDeparting);
	}
	
	@Test
	public void elBuqueSeVaYNOPasaDeDepartingAOutboundDeVuelta() {
		Posicion posicionTerminal = new Posicion(50,50);
		TerminalGestionada terminalG_T = new TerminalGestionada(posicionTerminal,1,1,1);
		Buque buque_T = new Buque(terminalG_T, posicionInicialBuque);
		
			Posicion posicionInbound = new Posicion(30,20);
	     	buque_T.actualizarPosicion(posicionInbound);
	     	buque_T.actualizarPosicion(posicionTerminal);
	     	terminalG_T.darOrdenWorking(buque_T);   	
	     	buque_T.actualizarPosicion(posicionTerminal);
	     	terminalG_T.darOrdenDepart(buque_T);
	     	buque_T.actualizarPosicion(posicionTerminal);
	     	
	     	Posicion posicionSalida = new Posicion(50,50);
	     	buque_T.actualizarPosicion(posicionSalida);
	     	
	     	int distanciaSaliendo = buque_T.getDistanciaATerminalGestionada();
	        assertEquals(0, distanciaSaliendo);
	        
	        boolean esOutbound = buque_T.getFase() instanceof Outbound;
	        assertFalse(esOutbound);
	}

	
	
	@Test
	public void elBuqueSeVaYPasaDeDepartingAOutboundDeVuelta() {
		Posicion posicionTerminal = new Posicion(50,50);
		TerminalGestionada terminalG_T = new TerminalGestionada(posicionTerminal,1,1,1);
		Buque buque_T = new Buque(terminalG_T, posicionInicialBuque);
		
			Posicion posicionInbound = new Posicion(30,20);
	     	buque_T.actualizarPosicion(posicionInbound);
	     	buque_T.actualizarPosicion(posicionTerminal);
	     	terminalG_T.darOrdenWorking(buque_T);   	
	     	buque_T.actualizarPosicion(posicionTerminal);
	     	terminalG_T.darOrdenDepart(buque_T);
	     	buque_T.actualizarPosicion(posicionTerminal);
	     	
	     	Posicion posicionSalida = new Posicion(52,50);
	     	buque_T.actualizarPosicion(posicionSalida);
	     	
	     	int distanciaSaliendo = buque_T.getDistanciaATerminalGestionada();
	        assertEquals(2, distanciaSaliendo);
	        
	        boolean esOutbound = buque_T.getFase() instanceof Outbound;
	        assertTrue(esOutbound);
	}
}
