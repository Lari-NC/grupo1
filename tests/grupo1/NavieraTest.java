package grupo1;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import grupo1.circuito.Circuito;
import grupo1.circuito.Tramo;
import grupo1.mejorCircuito.BuscadorMejorCircuito;
import grupo1.mejorCircuito.MenorTiempo;
import grupo1.mejorCircuito.Naviera;

class NavieraTest {
	
	private Terminal terminalA;
	private Terminal terminalB;
	private Terminal terminalC;
	private Tramo tramo1;
	private Tramo tramo2;
	private Tramo tramo3;
	private Circuito circuito;
	private Circuito circuito1;
	private Naviera naviera;
	private BuscadorMejorCircuito buscador;
	
	@BeforeEach
	void setUp() throws Exception {
		
		terminalA   = mock(Terminal.class);
		terminalB   = mock(Terminal.class);
		terminalC   = mock(Terminal.class);
		tramo1      = new Tramo(terminalA,terminalB, 1, 1000);
		tramo2      = new Tramo(terminalA,terminalC, 2, 1000);
		tramo3      = new Tramo(terminalC,terminalB, 1, 1000);
		circuito    = new Circuito(LocalDate.of(2023, 11, 24));
		circuito1   = new Circuito(LocalDate.of(2023, 11, 24));
		buscador   	= new MenorTiempo();;
		naviera     = new Naviera(buscador);
		
	}

	@Test
	void cuandoUnaNavieraEsRecienCreada_NoTendraNingunCircuito() {
		assertTrue(naviera.getCircuitos().isEmpty());
	}
	
	@Test
	void cuandoUnaNavieraRecienCreadaAgregaUnCircuito_EsaNavieraPasaATenerUnCircuitoEnTotal() {
		naviera.addCircuito(circuito);
		
		assertEquals(1, naviera.getCircuitos().size());
	}
	
	@Test
	void siUnaNavieraTieneAlgunCircuitoQuePasaPorLaTerminalA_EntoncesEsaNavieraTieneSoloUnCircuitoQuePasePorEsaTerminal() {
		circuito.addTramo(tramo1);
		naviera.addCircuito(circuito);
		
		assertEquals(1, naviera.circuitosQuePasanPorTerminal(terminalA).size());
	}
	
	@Test
	void siUnaNavieraConDosCircuitosEnLosCualesAmbosPasanPorPrimeroPorTerminalAYLuegoPorTerminalB_EntoncesElTiempoDeEstaNavieraEnRecorrerEseViaje_EsEquivalenteALTiempoQueTardeElCircuitoQueTardeMenos() {
		circuito.addTramo(tramo1);
		circuito1.addTramo(tramo2);
		circuito1.addTramo(tramo3);
		naviera.addCircuito(circuito);
		naviera.addCircuito(circuito1);
		
		assertEquals(1, naviera.tiempoDeViajeDesdeHastaTerminal(terminalA, terminalB));
	}
}