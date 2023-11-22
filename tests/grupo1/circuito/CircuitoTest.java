package grupo1.circuito;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import grupo1.Posicion;
import grupo1.Terminal;

class CircuitoTest {

	private Posicion posicionDeA;
	private Posicion posicionDeB;
	private Terminal terminalA;
	private Terminal terminalB;
	private Tramo tramo1;
	private Posicion posicionDeC;
	private Posicion posicionDeD;
	private Terminal terminalC;
	private Terminal terminalD;
	private Tramo tramo2;
	private Circuito circuito1;
	private LocalDate fechaDeSalidaDeCircuito1 = LocalDate.of(2023, 11, 15);

	@BeforeEach
	void setUp() throws Exception {
		posicionDeA = new Posicion(1,1);
		posicionDeB = new Posicion(1,2); 
		terminalA = new Terminal(posicionDeA);
		terminalB = new Terminal(posicionDeB);
		tramo1 = new Tramo(terminalA,terminalB, 1, 1000);
		posicionDeC = new Posicion(1,3);
		posicionDeD = new Posicion(1,4); 
		terminalC = new Terminal(posicionDeC);
		terminalD = new Terminal(posicionDeD);
		tramo1 = new Tramo(terminalC, terminalD, 2, 1000);
		circuito1 = new Circuito(fechaDeSalidaDeCircuito1);
	}

	@Test
	void cuandoUnCircuitoEsRecienCreadoNoTendraNingunTramo() {
		assertTrue(circuito1.getTramos().isEmpty());
	}
	
	@Test
	void cuandoAgregamosUnTramoAUnCircuitoRecienCreado_EseCircuitoPasaATener1TramoEnTotal() {
		circuito1.addTramo(tramo1);
		assertEquals(1, circuito1.getTramos().size());
	}
	
	@Test
	void cuandoAgregamosUnTramoDesdeTermAHastaTermB_ElCircuitoIncluyeATermA() {
		circuito1.addTramo(tramo1);
		assertTrue(circuito1.incluyeATerminal(terminalA));
	}
	
	
	@Test
	void x() {
		circuito1.addTramo(tramo1);
		List<Terminal> terminales = new ArrayList<>();
		terminales.add(terminalA);
		terminales.add(terminalB);
		assertEquals(terminales, circuito1.getTerminalesRecorridas());
	}


	/*
	@Test
	void cuandoAgregamosUnTramoDesdeTermAHastaTermB_AUnCircuitoRecienCreado_LaPosiciónDeTermAEs0() {
		circuito1.addTramo(tramo1);
		assertEquals(0, circuito1.posicionDeTerminalEnRecorrido(terminalA));
	}
	*/
	
	/*
	@Test 
	void unCircuitoConUnTramoDesdeTermAHastaTermB_TieneUnRecorridoDeTerminalesDondePrimeroApareceTermAYLuegoTermB() {
		circuito1.addTramo(tramo1);
		circuito1.addTramo(tramo2);
		assertTrue(circuito1.incluyeATerminalAntesDeTerminal(terminalA, terminalB));
	}
	
	@Test 
	void enUnCircuitoCon1Tramo_ElTiempoQueTardeEnCompletarseElMismo_SeraEquivalenteAlTiempoQueTardaraEseTramoQueTiene() {
		circuito1.addTramo(tramo1);
		assertEquals(tramo1.getTiempo(), circuito1.getTiempoTotal());
	}
	
	@Test 
	void enUnCircuitoCon1Tramo_ElPrecioTotalDelCircuito_SeraEquivalenteAlPrecioDelTramoQueContieneDichoCircuito() {
		circuito1.addTramo(tramo1);
		assertEquals(tramo1.getPrecio(), circuito1.getPrecioTotalDeCircuito());
	}
	*/
	

}
