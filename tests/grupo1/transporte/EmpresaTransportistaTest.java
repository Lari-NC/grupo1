package grupo1.transporte;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmpresaTransportistaTest {
	
	private EmpresaTransportista empresaTransportista;
	private Camion camion;
	private Chofer chofer;

	@BeforeEach
	void setUp() throws Exception {
		
		empresaTransportista = new EmpresaTransportista();
		camion = mock(Camion.class);
		chofer = mock(Chofer.class);
		
	}

	@Test
	void cuandoUnaEmpresaTransportistaEsRecienCreada_NoTendraRegistradoNingunChofer() {
		assertTrue(empresaTransportista.getChoferesRegistrados().isEmpty());
	}
	
	@Test
	void cuandoUnaEmpresaTransportistaEsRecienCreada_NoTendraRegistradoNingunCamion() {
		assertTrue(empresaTransportista.getCamionesRegistrados().isEmpty());
	}
	
	@Test
	void cuandoUnaEmpresaTransportistaEsRecienCreada_YAgregaUnNuevoChofer_EsaEmpresaTieneUnSoloChoferRegistradoEnTotal() {
		empresaTransportista.addChofer(chofer);
		
		assertEquals(1, empresaTransportista.getChoferesRegistrados().size());
	}
	
	@Test
	void cuandoUnaEmpresaTransportistaEsRecienCreada_YAgregaUnNuevoCamion_EsaEmpresaTieneUnSoloCamionRegistradoEnTotal() {
		empresaTransportista.addCamion(camion);
		
		assertEquals(1, empresaTransportista.getCamionesRegistrados().size());
	}

}
