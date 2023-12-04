package grupo1;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import grupo1.buque.Buque;
import grupo1.buque.fases.Arrived;
import grupo1.buque.fases.Departing;
import grupo1.buque.fases.Inbound;
import grupo1.buque.fases.Outbound;
import grupo1.buque.fases.Working;
import grupo1.cliente.Consignee;
import grupo1.cliente.Shipper;
import grupo1.servicios.Almacenamiento;
import grupo1.transporte.Camion;
import grupo1.transporte.Chofer;

class exportacionCompleta {
	
	private TerminalGestionada terminalGestionada;
	private Posicion posicionT;
	private Buque buqueExpo;
	private Buque otroBuque;
	private Posicion posicionInicialB;
	private Orden exportacion1;
	private Orden exportacion2;
	private Viaje viaje1;
	private Viaje viaje;
	private Consignee pepe;
	private Consignee pepita;
	private Shipper percy;
	private Shipper anna;
	private Chofer mario;
	private Camion camion;
	
	
	
	 
	@BeforeEach
	void setUp() throws Exception {
		this.posicionT = new Posicion(50,50);
		this.terminalGestionada = new TerminalGestionada(posicionT,300,200,100);
		this.posicionInicialB = new Posicion(0,0);
		this.buqueExpo = new Buque(terminalGestionada, posicionInicialB);
		
		this.otroBuque = mock(Buque.class);
		
		this.pepe = mock(Consignee.class);
		this.pepita = mock(Consignee.class);
		
		this.percy = mock(Shipper.class);
		this.anna = mock(Shipper.class);
		
		this.mario = mock(Chofer.class);
		this.camion = mock(Camion.class);
		
		when(this.camion.getChofer()).thenReturn(mario);
		
			
		this.viaje = mock(Viaje.class);
			when(this.viaje.getBuque()).thenReturn(buqueExpo);
		
			
		this.exportacion1 = mock(Orden.class);
			when(this.exportacion1.getViaje()).thenReturn(viaje);
			when(this.exportacion1.getConsignee()).thenReturn(pepe);
			when(this.exportacion1.getShipper()).thenReturn(percy);
			when(this.exportacion1.getCamion()).thenReturn(camion);
			when(this.exportacion1.getChofer()).thenReturn(mario);
			
		this.exportacion2 = mock(Orden.class);
			when(this.exportacion2.getViaje()).thenReturn(viaje);
			when(this.exportacion2.getConsignee()).thenReturn(pepita);
			when(this.exportacion2.getShipper()).thenReturn(anna);
			when(this.exportacion2.getCamion()).thenReturn(camion);
			when(this.exportacion2.getChofer()).thenReturn(mario);
			
			
		terminalGestionada.registrarExportacion(exportacion1);
		terminalGestionada.registrarExportacion(exportacion2);
		
		terminalGestionada.registrarCamion(camion);
		terminalGestionada.registrarChofer(mario);
	}

	@Test
	void testCompleto() {
		
        terminalGestionada.recibirCargaAExportar(exportacion1,camion);
        
		terminalGestionada.recibirCargaAExportar(exportacion2,camion);
        
			//buque outbound en camino
			boolean esOutbound = this.buqueExpo.getFase() instanceof Outbound;
			assertTrue(esOutbound);
			
			//buque incoming
			Posicion posicionInbound = new Posicion(30,20);
	     	buqueExpo.actualizarPosicion(posicionInbound);
	     	
	     	boolean esInbound = this.buqueExpo.getFase() instanceof Inbound;
		    assertTrue(esInbound);
		    
	     	//buque Arrived
	     	buqueExpo.actualizarPosicion(posicionT);
	     	
	     	boolean esArrived = this.buqueExpo.getFase() instanceof Arrived ;
		    assertTrue(esArrived);
	     	
		    //buque Working
	     	terminalGestionada.darOrdenWorking(buqueExpo);   	
	     	assertTrue(buqueExpo.tieneOrdenWorking());
	     	
	     	buqueExpo.actualizarPosicion(posicionT); //actualizamos de vuelta apra que cambie la fase
	     	
	     	boolean esWorking = buqueExpo.getFase() instanceof Working;
	     	assertTrue(esWorking);
	     	
	     	//buque Departing
	     	terminalGestionada.darOrdenDepart(buqueExpo);
	     	assertTrue(buqueExpo.tieneOrdenDepart());
	     	buqueExpo.actualizarPosicion(posicionT);
	     
	     	boolean esDeparting = buqueExpo.getFase() instanceof Departing;
	     	assertTrue(esDeparting);
	     	
	     	//buque Outbound de vuelta
	     	Posicion posicionSalida = new Posicion(52,50);
	     	buqueExpo.actualizarPosicion(posicionSalida);
	        
	        boolean esOutboundPartida = buqueExpo.getFase() instanceof Outbound;
	        assertTrue(esOutboundPartida);
	        verify(percy).recibirMailCargaEnviada();	      
	        verify(anna).recibirMailCargaEnviada();	  
	       
	}
	
}
