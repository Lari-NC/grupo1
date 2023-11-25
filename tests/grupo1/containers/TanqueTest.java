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
	void seCreaUnTanque() {
	
		assertEquals(5, containerTanque.getAncho());
		assertEquals(10, containerTanque.getLargo());
		assertEquals(5, containerTanque.getAlto());
		assertEquals(100, containerTanque.getPesoTotal());
	

	}
	
	
	@Test 
	void cuandoUnContainerTanqueRecienCreadoConLasDimencionesDe5x10x5_EntoncesTendra250MetrosCubicos() {
		assertEquals(250, containerTanque.metrosCubicos());
	}
	
		


}
