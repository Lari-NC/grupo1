package grupo1.containers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReeferTest {
	
	private Reefer containerReefer;

	@BeforeEach
	void setUp() throws Exception {
		
		containerReefer = new Reefer(5,10,5,100,180);
		
	}

	@Test
	void seCreaUnReefer() {
	
		assertEquals(5, containerReefer.getAncho());
		assertEquals(10, containerReefer.getLargo());
		assertEquals(5, containerReefer.getAlto());
		assertEquals(100, containerReefer.getPesoTotal());
		assertEquals(180, containerReefer.getConsumo());

	}
	
	
	@Test 
	void cuandoUnContainerReeferRecienCreadoConLasDimencionesDe5x10x5_EntoncesTendra250MetrosCubicos() {
		assertEquals(250, containerReefer.metrosCubicos());
	}
	
		

}
