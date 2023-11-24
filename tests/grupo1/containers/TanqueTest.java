package grupo1.containers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TanqueTest {

	private Tanque containerTanque;
	
	@BeforeEach
	void setUp() throws Exception {
		
		containerTanque = new Tanque(5,10,5,100);
	}

	@Test
	void cuandoUnContainerTanqueEsRecienCreadoConUnAncho5Metros_EntoncesSuAnchoSeraDe5Metros() {
		assertEquals(5, containerTanque.getAncho());
	}
	
	@Test
	void cuandoUnContainerTanqueEsRecienCreadoConUnLargoDe10Metros_EntoncesSuLargoSeraDe10Metros() {
		assertEquals(10, containerTanque.getLargo());
	}
	
	@Test
	void cuandoUnContainerTanqueEsRecienCreadoConUnaAlturaDe10Metros_EntoncesSuAlturaSeraDe10Metros() {
		assertEquals(5, containerTanque.getAlto());
	}
	
	@Test
	void cuandoUnContainerTanqueEsRecienCreadoConUnPesoDe100Kilos_EntoncesSuPesoSeraDe100Kilos() {
		assertEquals(100, containerTanque.getPesoTotal());
	}
	
	@Test 
	void cuandoUnContainerTanqueRecienCreadoConLasDimencionesDe5x10x5_EntoncesTendra250MetrosCubicos() {
		assertEquals(250, containerTanque.metrosCubicos());
	}

}
