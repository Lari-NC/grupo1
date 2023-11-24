package grupo1.containers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContainerTest {
	
	private Container container;

	@BeforeEach
	void setUp() throws Exception {
		
		container = new Container(5,10,5,100);
	}

	@Test
	void cuandoUnContainerEsRecienCreadoConUnAncho5Metros_EntoncesSuAnchoSeraDe5Metros() {
		assertEquals(5, container.getAncho());
	}
	
	@Test
	void cuandoUnContainerEsRecienCreadoConUnLargoDe10Metros_EntoncesSuLargoSeraDe10Metros() {
		assertEquals(10, container.getLargo());
	}
	
	@Test
	void cuandoUnContainerEsRecienCreadoConUnaAlturaDe10Metros_EntoncesSuAlturaSeraDe10Metros() {
		assertEquals(5, container.getAlto());
	}
	
	@Test
	void cuandoUnContainerEsRecienCreadoConUnPesoDe100Kilos_EntoncesSuPesoSeraDe100Kilos() {
		assertEquals(100, container.getPesoTotal());
	}
	
	@Test 
	void cuandoUnContainerRecienCreadoConLasDimencionesDe5x10x5_EntoncesTendra250MetrosCubicos() {
		assertEquals(250, container.metrosCubicos());
	}

}
