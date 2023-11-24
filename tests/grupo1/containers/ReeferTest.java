package grupo1.containers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReeferTest {
	
	private Reefer containerReefer;

	@BeforeEach
	void setUp() throws Exception {
		
		containerReefer = new Reefer(5,10,5,100);
		
	}

	@Test
	void cuandoUnContainerReeferEsRecienCreadoConUnAncho5Metros_EntoncesSuAnchoSeraDe5Metros() {
		assertEquals(5, containerReefer.getAncho());
	}
	
	@Test
	void cuandoUnContainerReefersRecienCreadoConUnLargoDe10Metros_EntoncesSuLargoSeraDe10Metros() {
		assertEquals(10, containerReefer.getLargo());
	}
	
	@Test
	void cuandoUnContainerReeferEsRecienCreadoConUnaAlturaDe10Metros_EntoncesSuAlturaSeraDe10Metros() {
		assertEquals(5, containerReefer.getAlto());
	}
	
	@Test
	void cuandoUnContainerReeferEsRecienCreadoConUnPesoDe100Kilos_EntoncesSuPesoSeraDe100Kilos() {
		assertEquals(100, containerReefer.getPesoTotal());
	}
	
	@Test 
	void cuandoUnContainerReeferRecienCreadoConLasDimencionesDe5x10x5_EntoncesTendra250MetrosCubicos() {
		assertEquals(250, containerReefer.metrosCubicos());
	}
	
	@Test
	void cuandoUnContainerReeferRecienCreado_SuConsumoSeraIgualACero() {
		assertEquals(0, containerReefer.getConsumo());
	}
	
	//Deberiamos Testear cuando consume energia.
	

}
