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

class importacionCompletaTest {
	
	private TerminalGestionada terminalGestionada;
	private Posicion posicionT;
	private Buque buqueImp;
	private Buque otroBuque;
	private Posicion posicionInicialB;
	private Orden importacion1;
	private Orden importacion2;
	private Orden importacion3;
	private Viaje viaje1;
	private Viaje viaje2;
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
		this.buqueImp = new Buque(terminalGestionada, posicionInicialB);
		
		this.otroBuque = mock(Buque.class);
		
		this.pepe = mock(Consignee.class);
		this.pepita = mock(Consignee.class);
		
		this.percy = mock(Shipper.class);
		this.anna = mock(Shipper.class);
		
		this.mario = mock(Chofer.class);
		this.camion = mock(Camion.class);
		
		when(this.camion.getChofer()).thenReturn(mario);
		
		
		this.viaje1 = mock(Viaje.class);
			when(this.viaje1.getBuque()).thenReturn(otroBuque);
			
		this.viaje2 = mock(Viaje.class);
			when(this.viaje2.getBuque()).thenReturn(buqueImp);
		
		this.importacion1 = mock(Orden.class);
			when(this.importacion1.getViaje()).thenReturn(viaje1);
			
		this.importacion2 = mock(Orden.class);
			when(this.importacion2.getViaje()).thenReturn(viaje2);
			when(this.importacion2.getConsignee()).thenReturn(pepe);
			when(this.importacion2.getShipper()).thenReturn(percy);
			when(this.importacion2.getCamion()).thenReturn(camion);
			when(this.importacion2.getChofer()).thenReturn(mario);
			when(this.importacion2.getFechaDeLlegada()).thenReturn(LocalDate.of(2023, 1, 1));
			
		this.importacion3 = mock(Orden.class);
			when(this.importacion3.getViaje()).thenReturn(viaje2);
			when(this.importacion3.getConsignee()).thenReturn(pepita);
			when(this.importacion3.getShipper()).thenReturn(anna);
			when(this.importacion3.getCamion()).thenReturn(camion);
			when(this.importacion3.getChofer()).thenReturn(mario);
			when(this.importacion3.getFechaDeLlegada()).thenReturn(LocalDate.of(2023, 1, 1));
			
			
		terminalGestionada.agregarOrdenImportacion(importacion1);
		terminalGestionada.agregarOrdenImportacion(importacion2);
		terminalGestionada.agregarOrdenImportacion(importacion3);
		
		terminalGestionada.registrarCamion(camion);
		terminalGestionada.registrarChofer(mario);
	}

	@Test
	void testCompleto() {
			
			
			//buque outbound en camino
			boolean esOutbound = this.buqueImp.getFase() instanceof Outbound;
			assertTrue(esOutbound);
			
			//buque incoming
			Posicion posicionInbound = new Posicion(30,20);
	     	buqueImp.actualizarPosicion(posicionInbound);
	     	
	     	boolean esInbound = this.buqueImp.getFase() instanceof Inbound;
		    assertTrue(esInbound);
		    
	     	verify(pepe).recibirMailParaRetiro();
	     	verify(pepita).recibirMailParaRetiro();
		    
	     	//buque Arrived
	     	buqueImp.actualizarPosicion(posicionT);
	     	
	     	boolean esArrived = this.buqueImp.getFase() instanceof Arrived ;
		    assertTrue(esArrived);
	     	
		    //buque Working
	     	terminalGestionada.darOrdenWorking(buqueImp);   	
	     	assertTrue(buqueImp.tieneOrdenWorking());
	     	
	     	buqueImp.actualizarPosicion(posicionT); //actualizamos de vuelta apra que cambie la fase
	     	
	     	boolean esWorking = buqueImp.getFase() instanceof Working;
	     	assertTrue(esWorking);
	     	
	     	//buque Departing
	     	terminalGestionada.darOrdenDepart(buqueImp);
	     	assertTrue(buqueImp.tieneOrdenDepart());
	     	buqueImp.actualizarPosicion(posicionT);
	     
	     	boolean esDeparting = buqueImp.getFase() instanceof Departing;
	     	assertTrue(esDeparting);
	     	
	     	//buque Outbound de vuelta
	     	Posicion posicionSalida = new Posicion(52,50);
	     	buqueImp.actualizarPosicion(posicionSalida);
	        
	        boolean esOutboundPartida = buqueImp.getFase() instanceof Outbound;
	        assertTrue(esOutboundPartida);
	        
	        verify(percy).recibirFactura(any(Factura.class));
	        verify(anna).recibirFactura(any(Factura.class));
	        
	        //vienen a retirar primera orden a tiempo
	        terminalGestionada.realizarRetiroDeCargaDeOrden(importacion2,camion, LocalDate.of(2023, 1, 1));
	        assertFalse(this.terminalGestionada.getOrdenesImportacion().contains(importacion2));
	        
	        //vienen a retirar segunda orden 10 dias tarde
			terminalGestionada.realizarRetiroDeCargaDeOrden(importacion3,camion, LocalDate.of(2023, 1, 11));
			assertFalse(this.terminalGestionada.getOrdenesImportacion().contains(importacion3));
			verify(importacion3, times(10)).agregarServicioDeTerminal(any(Almacenamiento.class));
				//ya se envio la facura antes!! nunca le cobramos el almacenamiento 
	        
	}
	
}
