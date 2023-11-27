package grupo1;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import grupo1.buque.Buque;
import grupo1.circuito.Circuito;
import grupo1.circuito.Tramo;



class ViajeTest {
	
	private Terminal terminalInicial;
	private Terminal terminalDestino;
	private Tramo tramo;
	private Circuito circuito;
	private Buque buque;
	private Viaje viaje;
	
    @BeforeEach
    public void setUp() {
    	
    	this.terminalInicial = mock(Terminal.class);
    	this.terminalDestino = mock(Terminal.class);
    	
    	this.tramo = mock(Tramo.class);

			when(this.tramo.getTerminalInicio()).thenReturn(terminalInicial);
		    when(this.tramo.getTerminalLlegada()).thenReturn(terminalDestino);
		    when(this.tramo.getTiempo()).thenReturn(1);
		    when(this.tramo.getPrecio()).thenReturn(1000);
		    
		this.circuito = new Circuito(LocalDate.of(2023, 11, 15));
		
		this.buque = mock(Buque.class);
				
    	this.viaje = new Viaje(circuito, buque, terminalInicial, terminalDestino);
    }
    

	@Test
    void x() {
    	circuito.addTramo(tramo);
    	assertEquals(0, circuito.posicionDeTramoConTerminalInicial(terminalInicial));
    }

    /*
    @Test
    public void viajeSeCreaCorrectamente() {
    	assertEquals(buque, viaje.getBuque());
    }
    */
    
    /*
    @Test
    public void viajeSeCreaCorrectamente1() {
    	assertEquals(circuito.crearCircuitoEspecificoPara_Y_(terminalInicial, terminalDestino), viaje.getCircuito());
    }
    
    @Test
    public void viajeSeCreaCorrectamente2() {
    	assertEquals(terminalInicial, viaje.getTerminalInicial());

    }
    
    @Test
    public void viajeSeCreaCorrectamente3() {
    	assertEquals(terminalDestino, viaje.getTerminalDestino());
    }
    
    @Test
    public void elPrecioDeUnViaje_EsEquivalenteAlPrecioDelRecorridoQueHaceElCircuitoDesdeLaTerminalInicialHastaLaTerminalDestino() {
    	assertEquals(1000, viaje.getPrecioViaje());
    }
    */
}