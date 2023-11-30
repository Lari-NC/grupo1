package grupo1;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import grupo1.circuito.Circuito;
import grupo1.cliente.Consignee;
import grupo1.cliente.Shipper;
import grupo1.servicios.Servicio;
import grupo1.transporte.Camion;
import grupo1.transporte.Chofer;
import grupo1.transporte.EmpresaTransportista;

class TerminalGestionadaTest {
	
	private Naviera naviera;
    private Shipper shipper;
    private Consignee consignee;
    private EmpresaTransportista empresaTranportista;
    private Camion camion;
    private Chofer chofer;
    private Circuito circuito;

    private Posicion posicionTerminalGestionada;
    private TerminalGestionada terminalGestionada;

	@BeforeEach
	void setUp() throws Exception {
		
		this.naviera = mock(Naviera.class);
		this.shipper = mock(Shipper.class);
		this.consignee = mock(Consignee.class);
		this.empresaTranportista = mock(EmpresaTransportista.class);
		this.camion = mock(Camion.class);
		this.chofer = mock(Chofer.class);
		this.circuito = mock(Circuito.class);
		
		this.posicionTerminalGestionada = mock(Posicion.class);
		this.terminalGestionada = new TerminalGestionada(posicionTerminalGestionada, 5000, 7000, 200);
		
	}

	@Test
	void siEnUnaTerminalGestionadaRecienCreadaRegistroAUnaNaviera_EntoncesEsaNavieraFormaraParteDeLaTerminal() {
		this.terminalGestionada.registrarNaviera(naviera);
		//erdon guille fijate que el agregamos el precio de el servicio de electricidad apra reacer lo necesario
		assertTrue//(this.terminalGestionada.getNavieras().contains(naviera));
	}
	
	@Test
	void siEnUnaTerminalGestionadaRecienCreadaRegistroAUnShipper_EntoncesEseShipperFormaraParteDeLaTerminal() {
		this.terminalGestionada.registrarShipper(shipper);
		
		assertTrue(this.terminalGestionada.getShippers().contains(shipper));
	}
	
	@Test
	void siEnUnaTerminalGestionadaRecienCreadaRegistroAUnConsignee_EntoncesEseConsigneeFormaraParteDeLaTerminal() {
		this.terminalGestionada.registrarConsignee(consignee);
		
		assertTrue(this.terminalGestionada.getConsignees().contains(consignee));
	}
	
	@Test
	void siEnUnaTerminalGestionadaRecienCreadaRegistroAUnaEmpresaTransportista_EntoncesEsaEmpresaFormaraParteDeLaTerminal() {
		this.terminalGestionada.registrarEmpresaTranportista(empresaTranportista);
		
		assertTrue(this.terminalGestionada.getEmpresasTransportistas().contains(empresaTranportista));
	}
	
	@Test 
	void siEnUnaTerminalGestionadaRecienCreadaRegistroAUnCamion_EntoncesEseCamionFormaraParteDeLaTerminal() {
		this.terminalGestionada.registrarCamion(camion);
		
		assertTrue(this.terminalGestionada.getCamionesPermitidos().contains(camion));
	}
	
	@Test
	void siEnUnaTerminalGestionadaRecienCreadaRegistroAUnChofer_EntoncesEseChoferFormaraParteDeLaTerminal() {
		this.terminalGestionada.registrarChofer(chofer);
		
		assertTrue(this.terminalGestionada.getChoferesPermitidos().contains(chofer));
	}

}
