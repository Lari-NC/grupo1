package grupo1.containers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DryTest {

	private Dry containerDry;
	
	@BeforeEach
	void setUp() throws Exception {
		containerDry = new Dry(5,10,5,100);
	}

	@Test
	void seCreaUnDry() {
		assertEquals(5, containerDry.getAncho());
		assertEquals(10, containerDry.getLargo());
		assertEquals(5, containerDry.getAlto());
		assertEquals(100, containerDry.getPesoTotal());
	}
	
	
	@Test 
	void cuandoUnContainerDryRecienCreadoConLasDimencionesDe5x10x5_EntoncesTendra250MetrosCubicos() {
		assertEquals(250, containerDry.metrosCubicos());
	}
}