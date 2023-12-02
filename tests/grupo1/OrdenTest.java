package grupo1;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import grupo1.cliente.Consignee;
import grupo1.cliente.Shipper;
import grupo1.containers.Container;
import grupo1.servicios.Almacenamiento;
import grupo1.servicios.Lavado;
import grupo1.servicios.Pesado;
import grupo1.servicios.Servicio;
import grupo1.transporte.Chofer;
import grupo1.transporte.Camion;

class OrdenTest {

	private Orden orden;
	private Shipper shipper;
	private Consignee consignee;
	private Container container;
	private Viaje viaje;
	private LocalDate fechaSalida;
	private LocalDate fechaLlegada;
	private Camion camion;
	private Chofer chofer;
	private List<Servicio> servicios = new ArrayList<>();
	private Lavado servicioLavado;
	private Pesado servicioPesado;
	private Terminal terminal;
	 
    @BeforeEach
    public void setUp() {
        
        this.shipper = mock(Shipper.class);
        this.consignee = mock(Consignee.class);
        this.container = mock(Container.class);
        this.viaje = mock(Viaje.class);
        	when(this.viaje.getTerminalDestino()).thenReturn(terminal);
        this.camion = mock(Camion.class);
        this.chofer = mock(Chofer.class);
        this.servicioLavado = mock(Lavado.class);
        this.servicioPesado = mock(Pesado.class);
        
        servicios.add(servicioLavado);
        servicios.add(servicioPesado);
        
        this.fechaSalida = LocalDate.of(2023, 1, 1);
        this.fechaLlegada = LocalDate.of(2023, 1, 15);
        
        this.orden = 	new Orden(shipper,consignee,container,viaje,
						fechaSalida,fechaLlegada,camion,chofer,servicios);
        
       this.terminal = mock(Terminal.class);
    }

    @Test
    public void unaOrdenSePuedeCrear() {
    	
    	assertEquals(orden.getShipper(),shipper);
    	assertEquals(orden.getConsignee(),consignee);
    	assertEquals(orden.getContainer(),container);
    	assertEquals(orden.getViaje(),viaje);
    	assertEquals(orden.getFechaDeSalida(),fechaSalida);
    	assertEquals(orden.getFechaDeLlegada(),fechaLlegada);
    	assertEquals(orden.getCamion(),camion);
    	assertEquals(orden.getChofer(),chofer);
    	assertEquals(orden.getServicios(),servicios);
 
    }

   

    @Test
    public void aUnaOrdenYaCreadaSeLePuedeAgregarServiciosDeAlmacenamiento() {
    	Almacenamiento sAlmacenamiento = mock(Almacenamiento.class);
        this.orden.agregarServicioDeTerminal(sAlmacenamiento); 
        
    	assertTrue(orden.getServicios().contains(sAlmacenamiento));
    }
    
    @Test
    void seCreaUnFacturaParaLaOrden() {
    	assertEquals(viaje,this.orden.crearFactura().getViaje());
    	assertEquals(servicios,this.orden.crearFactura().getServicios());
    }
    
    @Test
    void laTerminalDestinoDelViajeDeLaOrden_DebeSerLaMismaQueLaTerminalDestinoDeLaOrden() {
    	assertEquals(this.viaje.getTerminalDestino(), this.orden.getTerminalDestino());
    }
}