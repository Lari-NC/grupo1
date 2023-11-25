package grupo1.transporte;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CamionTest {
	
	private Camion camion;
	private Chofer choferPepe;


	@BeforeEach
	void setUp() throws Exception {
		
		camion = new Camion();
		choferPepe = mock(Chofer.class);
		
	}
	
	@Test
	void cuandoUnCamionEsRecienCreado_NoTendraNingunChoferAsignado() {
		assertNull(camion.getChofer());
	}
	
	@Test
	void cuandoAUnCamionRecienCreado_SeLeAsignaElChoferPepe_EseCamionTendraComoChoferAPepe() {
		camion.asignarChofer(choferPepe);
		assertNotNull(camion.getChofer());
		assertEquals(choferPepe, camion.getChofer());
	}

}
