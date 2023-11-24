package grupo1.circuito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import grupo1.Terminal;

class CircuitoTest {

	private Terminal terminalA;
	private Terminal terminalB;
	private Terminal terminalC;
	private Tramo tramo1;
	private Tramo tramo2;
	private Circuito circuito;


	@BeforeEach
	void setUp() throws Exception {
		
	      terminalA = mock(Terminal.class);
	      terminalB = mock(Terminal.class);
	      terminalC = mock(Terminal.class);
	      tramo1 = new Tramo(terminalA, terminalB, 1, 1000);
	      tramo2 = new Tramo(terminalB, terminalC, 3, 2000);
	      // creo que tienen que ser mocks ^^ si testeamso circuito, el resto trien que ser mocks. 
	      circuito = new Circuito(LocalDate.of(2023, 11, 15));
	}

	@Test
	void cuandoUnCircuitoEsRecienCreadoNoTendraNingunTramo() {
		assertTrue(circuito.getTramos().isEmpty());
	}
	
	@Test
	void cuandoAgregamosUnTramoAUnCircuitoRecienCreado_EseCircuitoPasaATener1TramoEnTotal() {
		circuito.addTramo(tramo1);
		assertEquals(1, circuito.getTramos().size());
	}
	
	@Test
	void cuandoAgregamosUnTramoDesdeTermAHastaTermB_ElCircuitoIncluyeATermA() {
		circuito.addTramo(tramo1);
		assertTrue(circuito.incluyeATerminal(terminalA));
	}
	
	@Test
	void cuandoAgregamosUnTramoDesdeTermAHastaTermB_ElCircuitoIncluyeATermB() {
		circuito.addTramo(tramo1);
		assertTrue(circuito.incluyeATerminal(terminalB));
	}
	
	
	@Test
	void unCircuitoconoceTodasLasTerminalesQueRecorre() {
		
		circuito.addTramo(tramo1);
		circuito.addTramo(tramo2);
		
		List<Terminal> terminalesRecorridasEsperadas = new ArrayList<>();
		terminalesRecorridasEsperadas.add(terminalA);
		terminalesRecorridasEsperadas.add(terminalB);
		terminalesRecorridasEsperadas.add(terminalC);
		
		assertEquals(terminalesRecorridasEsperadas, circuito.terminalesRecorridas());
	}


	
	@Test
	void cuandoAgregamosUnTramoDesdeTermAHastaTermB_AUnCircuitoRecienCreado_LaPosiciónDeTermAEs0() {
		circuito.addTramo(tramo1);
		assertEquals(0, circuito.posicionDeTerminalEnRecorrido(terminalA));
	}
	
	
	
	@Test 
	void unCircuitoConUnTramoDesdeTermAHastaTermB_TieneUnRecorridoDeTerminalesDondePrimeroApareceTermAYLuegoTermB() {
		circuito.addTramo(tramo1);
		circuito.addTramo(tramo2);
		assertTrue(circuito.incluyeATerminalAntesDeTerminal(terminalA, terminalB));
	}
	
	@Test 

	void enUnCircuitoCon1Tramo_ElTiempoQueTardeEnCompletarseElMismo_SeraEquivalenteAlTiempoQueTardaraEseTramoQueTiene() {
		circuito.addTramo(tramo1);
		assertEquals(tramo1.getTiempo(), circuito.getTiempoTotal());
	}
	
	@Test 
	void enUnCircuitoCon1Tramo_ElPrecioTotalDelCircuito_SeraEquivalenteAlPrecioDelTramoQueContieneDichoCircuito() {
		circuito.addTramo(tramo1);
		assertEquals(tramo1.getPrecio(), circuito.getPrecioTotalDeCircuito());
	}
	
	@Test 
	void enUnCircuitoCon2Tramo_ElPrecioTotalDelCircuito_SeraEquivalenteALaSumatoriaDeLosTramos() {
		circuito.addTramo(tramo1);
		circuito.addTramo(tramo2);
		int precioEsperado = tramo1.getPrecio() + tramo2.getPrecio();
		assertEquals(precioEsperado, circuito.getPrecioTotalDeCircuito());
	}
	
	

}
