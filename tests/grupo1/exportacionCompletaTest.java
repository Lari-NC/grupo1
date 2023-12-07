package grupo1;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;

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
import grupo1.containers.Dry;
import grupo1.servicios.Lavado;
import grupo1.servicios.Servicio;
import grupo1.transporte.Camion;
import grupo1.transporte.Chofer;

class exportacionCompletaTest {
	
	private TerminalGestionada terminalGestionada;
	private Posicion posicionT;
	private Buque buqueExpo;
	private Posicion posicionInicialB;
	private Orden exportacion;
	private Viaje viaje;
	private Consignee pepita;
	private Shipper anna;
	private Chofer mario;
	private Camion camion;
	private Dry container;
	private Lavado lavado;
	private ArrayList<Servicio> servicios = new ArrayList<>();
	
	@BeforeEach
	void setUp() throws Exception {
		this.posicionT = new Posicion(50,50);
		this.terminalGestionada = new TerminalGestionada(posicionT,300,200);
		this.posicionInicialB = new Posicion(0,0);
		this.buqueExpo = new Buque(terminalGestionada, posicionInicialB);
		
		this.pepita = mock(Consignee.class);
		
		this.anna = mock(Shipper.class);
		
		this.mario = mock(Chofer.class);
		this.camion = mock(Camion.class);
		
		when(this.camion.getChofer()).thenReturn(mario);
		
			
		this.viaje = mock(Viaje.class);
			when(this.viaje.getBuque()).thenReturn(buqueExpo);
		
		this.servicios.add(lavado);
		
		terminalGestionada.registrarExportacion(anna, pepita, container, viaje, LocalDate.of(2023, 1, 1), LocalDate.of(2023, 5, 15), camion, mario, servicios);
		
		this.exportacion = this.terminalGestionada.getOrdenesExportacion().get(0);
		
		terminalGestionada.registrarCamion(camion);
		terminalGestionada.registrarChofer(mario);
	}

	@Test
	void testCompleto() {
		
        	this.terminalGestionada.entraUnCamionALaTerminalConUnaOrden(camion, exportacion);
        	
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
	        verify(anna).recibirMailCargaEnviada();	  
	       
	}
	
}
