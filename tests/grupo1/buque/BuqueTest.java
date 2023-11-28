package grupo1.buque;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import grupo1.Posicion;
import grupo1.TerminalGestionada;
import grupo1.buque.fases.Arrived;
import grupo1.buque.fases.Departing;
import grupo1.buque.fases.Fase;
import grupo1.buque.fases.Inbound;
import grupo1.buque.fases.Outbound;
import grupo1.buque.fases.Working;
import grupo1.containers.Container;

class BuqueTest {
	
	private Buque buque;
    private Posicion posicionInicialBuque;
    private Posicion posicionTerminal;
    private TerminalGestionada terminalG;
    private boolean ordenWorking;
    private boolean ordenDepart;
    
    
	@BeforeEach
	void setUp() throws Exception {
		
		this.posicionInicialBuque = new Posicion(0,0);
		
		this.posicionTerminal = new Posicion(50,50);
		
		this.terminalG = mock(TerminalGestionada.class);
			when(this.terminalG.getPosicion()).thenReturn(posicionTerminal);
			
		this.buque = new Buque(terminalG,posicionInicialBuque);
		
	}
	
	@Test
	public void unBuquePuedeCalcularLaDistanciaALaTerminalGestionada() {	
	        int distancia = buque.getDistanciaATerminalGestionada();
	        assertEquals(70, distancia);
	    }
	

	@Test
	public void unBuqueSePuedeMoverSinCambiarDeFase() {
		
			boolean esOutbound = this.buque.getfase() instanceof Outbound ;
			assertTrue(esOutbound);
			//mover buque
			Posicion nuevaPosicion = new Posicion(5,5);
	     	this.buque.actualizarPosicion(nuevaPosicion);
	     	
	     	//asertar que me movi
	     	int distancia = buque.getDistanciaATerminalGestionada();
	        assertEquals(63, distancia);
	        //asertar que sigo en outbound
	        esOutbound = this.buque.getfase() instanceof Outbound ;
	        assertTrue(esOutbound);
	    }
	
	@Test
	public void unBuqueSeMueveYPasaAFaseInbound() {
			//mover buque
			Posicion nuevaPosicion = new Posicion(30,20);
	     	this.buque.actualizarPosicion(nuevaPosicion);
	     	
	     	//asertar que me movi
	     	int distancia = buque.getDistanciaATerminalGestionada();
	        assertEquals(36, distancia);
	        //assertar si es inbound la nueva fase
	        boolean esInbound = this.buque.getfase() instanceof Inbound ;
	        assertTrue(esInbound);
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
	    
	        boolean esArrived = this.buque.getfase() instanceof Arrived ;
	        assertTrue(esArrived);
	        
	        
	    }
	
	//a partir de aca no funcionan hay que verlos bien solo estan planteados
	//seguro es un error super boludo
	//creo que es tema de mockito pero no se el jueve sisno pregunto
	
	@Test
	public void laTermianlDaLaOrdenDeWorrkingAUnBuqueYPasaDeFaseArrivedAWorking() {
			
			Posicion posicionInbound = new Posicion(30,20);
	     	this.buque.actualizarPosicion(posicionInbound);
	        Posicion posicionArrived = new Posicion(50,50);
	     	this.buque.actualizarPosicion(posicionArrived);
	
	     	this.terminalG.darOrdenWorking(buque);
	     	verify(terminalG).darOrdenWorking(buque);
	     	
	     	assertTrue(buque.tieneOrdenWorking());
	     	    //no quiere funcionar asjjdfhdfu
	    }
	
	@Test
	public void laTermianlDaLaOrdenDeDepartAUnBuqueYPasaDeWorkingADeparting() {
			
			Posicion posicionInbound = new Posicion(30,20);
	     	this.buque.actualizarPosicion(posicionInbound);
	        Posicion posicionArrived = new Posicion(50,50);
	     	this.buque.actualizarPosicion(posicionArrived);
	     	this.terminalG.darOrdenWorking(buque);
	     	verify(terminalG).darOrdenWorking(buque);
	     	
	     	this.terminalG.darOrdenDepart(buque);
	     	verify(terminalG).darOrdenDepart(buque);
	     	
	     	assertTrue(buque.tieneOrdenDepart());
	     	
	     	    
	    }
	
	@Test
	public void elBuqueSeVaYPasaDeDepartingAOutboundDeVuelta() {
			
			Posicion posicionInbound = new Posicion(30,20);
	     	this.buque.actualizarPosicion(posicionInbound);
	        Posicion posicionArrived = new Posicion(50,50);
	     	this.buque.actualizarPosicion(posicionArrived);
	     	this.terminalG.darOrdenWorking(buque);
	     	verify(terminalG).darOrdenWorking(buque);
	     	
	     	this.terminalG.darOrdenDepart(buque);
	     	verify(terminalG).darOrdenDepart(buque);
	     	
	     	Posicion posicionSalida = new Posicion(1,1);
	     	this.buque.actualizarPosicion(posicionSalida);
	     	
	     	int distanciaSaliendo = buque.getDistanciaATerminalGestionada();
	        assertEquals(0, distanciaSaliendo);
	     	 
	    }
	
	
	
	
}
