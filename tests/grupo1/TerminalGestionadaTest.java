package grupo1;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import grupo1.circuito.Circuito;
import grupo1.circuito.Tramo;
import grupo1.cliente.Consignee;
import grupo1.cliente.Shipper;
import grupo1.containers.Container;
import grupo1.mejorCircuito.BuscadorMejorCircuito;
import grupo1.mejorCircuito.MenorTiempo;
import grupo1.mejorCircuito.Naviera;
import grupo1.servicios.Lavado;
import grupo1.servicios.Pesado;
import grupo1.servicios.Servicio;
import grupo1.transporte.Camion;
import grupo1.transporte.Chofer;
import grupo1.transporte.EmpresaTransportista;

class TerminalGestionadaTest {
	
	private Naviera naviera;
	private BuscadorMejorCircuito buscador;
    private Shipper shipper;
    private Consignee consignee;
    private EmpresaTransportista empresaTranportista;
    private Camion camion;
    private Chofer chofer;
    private Circuito circuito;

    private Posicion posicionTerminalGestionada;
    private TerminalGestionada terminalGestionada;
    
    
    private List<Servicio> servicios = new ArrayList<>();
	private Lavado servicioLavado;
	private Pesado servicioPesado;
	private Container container;
    private Viaje viaje;
	private LocalDate fechaSalida;
	private LocalDate fechaLlegada;
    private Orden orden;
    private Chofer chofer1;
    private Camion camion1;
    private Orden ordenDePruebaEnErroresDeChekeos;
    
    private Terminal terminalA;
    private Terminal terminalB;
    private Tramo tramo1;
    private Tramo tramo2;
    
    private Posicion posicionTerminalA;
    private Posicion posicionTerminalB;
    
	@BeforeEach
	void setUp() throws Exception {
		
		this.buscador   		 = mock(MenorTiempo.class);
		this.naviera     		 = new Naviera(buscador);
		this.shipper 			 = mock(Shipper.class);
		this.consignee 			 = mock(Consignee.class);
		this.empresaTranportista = mock(EmpresaTransportista.class);
		this.camion 			 = mock(Camion.class);
		this.chofer 			 = mock(Chofer.class);
		this.circuito 			 = new Circuito(LocalDate.of(2023, 11, 15));
		
		this.posicionTerminalGestionada = mock(Posicion.class);
		this.terminalGestionada 	    = new TerminalGestionada(posicionTerminalGestionada, 5000, 7000, 200);
		
		this.servicioLavado = mock(Lavado.class);
        this.servicioPesado = mock(Pesado.class);
        
        servicios.add(servicioLavado);
        servicios.add(servicioPesado);
        this.container    = mock(Container.class);
		this.viaje 		  = mock(Viaje.class);
		this.fechaSalida  = LocalDate.of(2023, 1, 1);
        this.fechaLlegada = LocalDate.of(2023, 1, 15);
		this.orden 		  = new Orden(shipper, consignee, container, viaje, fechaSalida, fechaLlegada, camion, camion.getChofer(), servicios);
		
		this.camion1 	  = mock(Camion.class); 
		this.chofer1 	  = mock(Chofer.class);
		this.ordenDePruebaEnErroresDeChekeos = new Orden(shipper, consignee, container, viaje, fechaSalida, fechaLlegada, camion1, chofer, servicios);
		
		this.posicionTerminalA = mock(Posicion.class);
		this.posicionTerminalB = mock(Posicion.class);
		this.terminalA = new Terminal(posicionTerminalA);
		this.terminalB = new Terminal(posicionTerminalB);
		this.tramo1    = new Tramo(terminalA, this.terminalGestionada, 1, 1000);
		this.tramo2    = new Tramo(this.terminalGestionada, terminalB, 1, 1000);
	
	}

	@Test
	void siEnUnaTerminalGestionadaRecienCreadaRegistroAUnaNaviera_EntoncesEsaNavieraFormaraParteDeLaTerminal() {
		this.terminalGestionada.registrarNaviera(naviera);
		assertTrue(this.terminalGestionada.getNavieras().contains(naviera));
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
	
	@Test
	void siEnUnaTerminalGestionadaRecienCreadaAgregoUnaNuevaOrdenDeImportacion_EntoncesEsaOrdenEsaOrdenEstaraAlmacenadaDentroDeLaTerminal() {
		this.terminalGestionada.agregarOrdenImportacion(orden);
		assertTrue(this.terminalGestionada.getOrdenesImportacion().contains(orden));
	}
	
	@Test
	void siUnaTerminalGestionadaRealizaUnRetiroDeCargaDeUnaOrdenDeImportacion_EntoncesEsaOrdenPodraSerRemovidaDeLasOrdenesImportacionDeLaTerminal() {
		this.camion.asignarChofer(chofer);
		this.terminalGestionada.registrarCamion(camion);
		this.terminalGestionada.registrarChofer(camion.getChofer());
		this.terminalGestionada.agregarOrdenImportacion(orden);
		this.terminalGestionada.realizarRetiroDeCargaDeOrden(orden, camion, LocalDate.of(2023, 1, 15));
		
		assertFalse(this.terminalGestionada.getOrdenesImportacion().contains(orden));
	}
	
	@Test
	void siEnUnaTerminalGestionadaRecienCreadaSeRegistranNuevosServiciosAOfrecer_EntoncesEsosServiciosSonLosUnicosQueOfreceraLaTerminalPorElMomento() {
		this.servicios.remove(servicioLavado);
		this.terminalGestionada.registrarServicioAOfrecer(servicioLavado);
		this.terminalGestionada.registrarServiciosAOfrecer(servicios);
		
		assertTrue(this.terminalGestionada.getServiciosAOfrecer().contains(servicioLavado));
		assertTrue(this.terminalGestionada.getServiciosAOfrecer().contains(servicioPesado));
	}
	
	@Test
	void siUnaTerminalGestionadaRelizaUnRegistroDeExportacion_EntoncesEsaExportacionEstaraAlmacenadaComoUnaOrdenDentroDeLasOrdenesDeExportacionDeLaTerminal() {
		this.terminalGestionada.registrarExportacion(shipper, consignee, container, viaje, fechaSalida, fechaLlegada, camion, camion.getChofer(), servicios);
		
		assertEquals(shipper, this.terminalGestionada.getOrdenesExportacion().get(0).getShipper());
		assertEquals(consignee, this.terminalGestionada.getOrdenesExportacion().get(0).getConsignee());
		assertEquals(container, this.terminalGestionada.getOrdenesExportacion().get(0).getContainer());
		assertEquals(viaje, this.terminalGestionada.getOrdenesExportacion().get(0).getViaje());
		assertEquals(fechaSalida, this.terminalGestionada.getOrdenesExportacion().get(0).getFechaDeSalida());
		assertEquals(fechaLlegada, this.terminalGestionada.getOrdenesExportacion().get(0).getFechaDeLlegada());
		assertEquals(camion, this.terminalGestionada.getOrdenesExportacion().get(0).getCamion());
		assertEquals(camion.getChofer(), this.terminalGestionada.getOrdenesExportacion().get(0).getChofer());
		assertEquals(servicios, this.terminalGestionada.getOrdenesExportacion().get(0).getServicios());
	}
	
	@Test
	void siUnaTerminalGestiondaModificaLosPreciosDeLosServiciosDePesadoAlmacenamientoYElectricidad_EntoncesLosPreciosDeclaradosAlMomentoDeCrearEsaTerminalSeModificaranPorLosNuevos() {
		this.terminalGestionada.modificarPrecioServicioPesado(6000);
		this.terminalGestionada.modificarPrecioServicioAlmacenamientoPorHoraExtra(8000);
		this.terminalGestionada.modificarPrecioServicioElectricidadPorDiaExtra(300);
		
		assertEquals(6000, this.terminalGestionada.getPrecioServicioPesado());
		assertEquals(8000, this.terminalGestionada.getPrecioServicioAlmacenamientoPorDiaExtra());
		assertEquals(300, this.terminalGestionada.getPrecioServicioElectricidadPorDiaExtra());
	}
	
	@Test 
	void siUnaTerminalGestionadaRealizaUnRetiroDeCarga_PeroElCamionNoEstaRegistradoNosSaldraUnError() {
		assertThrows(IllegalArgumentException.class, () -> {this.terminalGestionada.realizarRetiroDeCargaDeOrden(orden, camion,LocalDate.of(2023, 1, 15));});
	}
	
	@Test 
	void siUnaTerminalGestionadaRealizaUnRetiroDeCarga_PeroElChoferNoEstaRegistradoNosSaldraUnError() {
		this.terminalGestionada.registrarCamion(camion);
		assertThrows(IllegalArgumentException.class, () -> {this.terminalGestionada.realizarRetiroDeCargaDeOrden(orden, camion,LocalDate.of(2023, 1, 15));});
	}
	
	@Test 
	void siUnaTerminalGestionadaRealizaUnRetiroDeCarga_PeroElChoferNoEsElMismoQueEstaDeclaradoEnLaOrdenNosSaldraUnError() {
		this.camion.asignarChofer(chofer1);
		this.terminalGestionada.registrarCamion(camion1);
		this.terminalGestionada.registrarChofer(camion1.getChofer());
		this.terminalGestionada.agregarOrdenImportacion(ordenDePruebaEnErroresDeChekeos);
		
		assertThrows(IllegalArgumentException.class, () -> {this.terminalGestionada.realizarRetiroDeCargaDeOrden(ordenDePruebaEnErroresDeChekeos, camion1, LocalDate.of(2023, 1, 15));});
	}
	
	@Test 
	void siUnaTerminalGestionadaRealizaUnRetiroDeCarga_PeroElCamionNoEsElMismoQueEstaDeclaradoEnLaOrdenNosSaldraUnError() {
		this.camion.asignarChofer(chofer);
		this.terminalGestionada.registrarCamion(camion);
		this.terminalGestionada.registrarChofer(camion.getChofer());
		this.terminalGestionada.agregarOrdenImportacion(ordenDePruebaEnErroresDeChekeos);
		
		assertThrows(IllegalArgumentException.class, () -> {this.terminalGestionada.realizarRetiroDeCargaDeOrden(ordenDePruebaEnErroresDeChekeos, camion, LocalDate.of(2023, 1, 15));});
	}
	
	@Test
	void enUnaTerminalGestionadaRecienCreada_NoHabraNingunCircuitoDeInteres_YaQueNoTendraNavierasTodavia() {
		this.terminalGestionada.registrarCircuitosDeInteres();
		
		assertEquals(0, this.terminalGestionada.getCircuitosDeInteres().size());
	}
	
	@Test
	void cuandoUnaTerminalGestionadaQuiereRegistrarRegistrarCircuitosDeInteres_YSoloTieneUnaSolaNavieraQueTieneUnSoloCircuitoQuePasaPorLaTerminalGestionada_EntoncesLaTerminalSoloVaATener1SoloCircuitoDeInteres() {
		this.circuito.addTramo(tramo1);
		this.naviera.addCircuito(circuito);
		this.terminalGestionada.registrarNaviera(naviera);
		this.terminalGestionada.registrarCircuitosDeInteres();
		
		assertEquals(1, this.terminalGestionada.getCircuitosDeInteres().size());
	}

	@Test
	void siUnaTerminalGestionadaNotificaAlClienteRetiroDeCarga_SeImprimiraElMensajeCorrespondienteEnConsignee() {
		this.terminalGestionada.notificarAlClienteRetiroDeCarga(consignee);
		verify(this.consignee, times(1)).recibirMailParaRetiro();
	}
	
	@Test
	void cuandoUnaTerminalGestionadaQuiereSaberCuandoTiempoTardaUnaNavieraEnLlegarAUnaTerminalDada_ElTiempoSeraEquivalenteAlTiempoQueLleveIrDesdeLaTerminalGestionadaHastaLaTerminalDadaDentroDeAlgunosDeLosCircuitosDeLaNaviera() {
		this.circuito.addTramo(tramo1);
		this.circuito.addTramo(tramo2);
		this.naviera.addCircuito(circuito);
		this.terminalGestionada.registrarNaviera(naviera);
		
		assertEquals(this.tramo2.getTiempo(),this.terminalGestionada.cantidadDeTiempoQueTardaLaNaviera_EnLlegarA_(naviera, terminalB));
	}
	
	@Test
	void testLaProximaFechaDePartidaDeUnBuqueDesdeLaTerminalGestionadaHastaTerminalB() {
		this.circuito.addTramo(tramo1);
		this.circuito.addTramo(tramo2);
		this.naviera.addCircuito(circuito);
		this.terminalGestionada.registrarNaviera(naviera);
		this.terminalGestionada.registrarCircuitosDeInteres();

		assertEquals(LocalDate.of(2023, 11, 16),this.terminalGestionada.proximaFechaDePartidaATerminal(terminalB));
	}
	

}
