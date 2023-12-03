package grupo1.buscador;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import grupo1.Terminal;
import grupo1.TerminalGestionada;
/* 
import grupo1.buscador.Busqueda;
import grupo1.buscador.BusquedaAND;
import grupo1.buscador.BusquedaNOT;
import grupo1.buscador.BusquedaOR;
import grupo1.buscador.BusquedaPorFechaDeLlegada;
import grupo1.buscador.BusquedaPorFechaDeSalida;
import grupo1.buscador.BusquedaPorPuertoDestino;
SE SACAN?? */
import grupo1.circuito.Circuito;
import grupo1.circuito.Tramo;


class BuscadorTest {
	
	private ArrayList<Circuito> ofertaCircuitos = new ArrayList<>();
	
	private TerminalGestionada bsAs;
	private Terminal ushuaia;
	private Terminal valparaiso;
	private Terminal puertoChile;
	private Terminal sidney;
	private Terminal peru;
	
	private Circuito circuitoA;
		private Tramo tramoBsAs_Ush;
		private Tramo tramoUsh_Valp;
		
	private Circuito circuitoA1;
		private Tramo tramoBsAs1_Ush1;
		private Tramo tramoUsh1_Valp1;

	private Circuito circuitoB;
		private Tramo tramoBsAS_PChi;
		private Tramo tramoPChi_Syd;
	
	private Circuito circuitoC;
		private Tramo tramoBsAS_PChi2;
		private Tramo tramoPChi_Valp;
		private Tramo tramoValp_Peru;
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		//mock terminales
			this.bsAs = mock(TerminalGestionada.class);
			this.ushuaia = mock(Terminal.class);
			this.valparaiso = mock(Terminal.class);
			this.puertoChile = mock(Terminal.class);
			this.sidney = mock(Terminal.class);
			this.peru = mock(Terminal.class);
		
		//mocks circuitos
			//CIRCUITO A
		this.circuitoA = new Circuito(LocalDate.of(2023, 3, 1));
			this.tramoBsAs_Ush = mock(Tramo.class);
				when(this.tramoBsAs_Ush.getTerminalInicio()).thenReturn(bsAs);
				when(this.tramoBsAs_Ush.getTerminalLlegada()).thenReturn(ushuaia);
				when(this.tramoBsAs_Ush.getTiempo()).thenReturn(9);
			this.tramoUsh_Valp = mock(Tramo.class);
				when(this.tramoUsh_Valp.getTerminalLlegada()).thenReturn(valparaiso);
				when(this.tramoUsh_Valp.getTiempo()).thenReturn(10);
		
		this.circuitoA.addTramo(tramoBsAs_Ush);
		this.circuitoA.addTramo(tramoUsh_Valp);
		
			//CIRCUITO A1
		this.circuitoA1 = new Circuito(LocalDate.of(2023, 3, 3));
			this.tramoBsAs1_Ush1 = mock(Tramo.class);
				when(this.tramoBsAs1_Ush1.getTerminalInicio()).thenReturn(bsAs);
				when(this.tramoBsAs1_Ush1.getTerminalLlegada()).thenReturn(ushuaia);
				when(this.tramoBsAs1_Ush1.getTiempo()).thenReturn(8);
			this.tramoUsh1_Valp1 = mock(Tramo.class);
				when(this.tramoUsh1_Valp1.getTerminalLlegada()).thenReturn(valparaiso);
				when(this.tramoUsh1_Valp1.getTiempo()).thenReturn(8);
			
		this.circuitoA1.addTramo(tramoBsAs1_Ush1);
		this.circuitoA1.addTramo(tramoUsh1_Valp1);
		
		
		
			//CIRCUITO B
		this.circuitoB = new Circuito(LocalDate.of(2023, 3, 1));
			this.tramoBsAS_PChi = mock(Tramo.class);
				when(this.tramoBsAS_PChi.getTerminalInicio()).thenReturn(bsAs);
				when(this.tramoBsAS_PChi.getTerminalLlegada()).thenReturn(puertoChile);
				when(this.tramoBsAS_PChi.getTiempo()).thenReturn(23);
				
			this.tramoPChi_Syd = mock(Tramo.class);
				when(this.tramoPChi_Syd.getTerminalLlegada()).thenReturn(sidney);
				when(this.tramoPChi_Syd.getTiempo()).thenReturn(20);
				
		this.circuitoB.addTramo(tramoBsAS_PChi);
		this.circuitoB.addTramo(tramoPChi_Syd);
		

			//CIRCUITO C
		this.circuitoC = new Circuito(LocalDate.of(2023, 3, 1));
			this.tramoBsAS_PChi2 = mock(Tramo.class);
				when(this.tramoBsAS_PChi2.getTerminalInicio()).thenReturn(bsAs);
				when(this.tramoBsAS_PChi2.getTerminalLlegada()).thenReturn(puertoChile);
				when(this.tramoBsAS_PChi2.getTiempo()).thenReturn(20);
				
			this.tramoPChi_Valp = mock(Tramo.class);
				when(this.tramoPChi_Valp.getTerminalLlegada()).thenReturn(valparaiso);
				when(this.tramoPChi_Valp.getTiempo()).thenReturn(9);
				
			this.tramoValp_Peru = mock(Tramo.class);
				when(this.tramoValp_Peru.getTerminalLlegada()).thenReturn(peru);
				when(this.tramoValp_Peru.getTiempo()).thenReturn(8);
		
		
		this.circuitoC.addTramo(tramoBsAS_PChi2);
		this.circuitoC.addTramo(tramoPChi_Valp);
		this.circuitoC.addTramo(tramoValp_Peru);
		
		
		this.ofertaCircuitos.add(circuitoA);
		this.ofertaCircuitos.add(circuitoA1);
		this.ofertaCircuitos.add(circuitoB);
		this.ofertaCircuitos.add(circuitoC);
		
	}

	@Test
	void casoPruebaLlegaAValparaisoOalPeurtoDeChileAntesdel22demarzo() {
		// (PuertoDestino = Valparaiso AND fechaLlegadaValpaiso < 22/3/23) OR (PuertoDestino = PuertoChile AND fechaLlegadaPuertoChile < 22/3/23) AND
		LocalDate llegada = LocalDate.of(2023, 3, 22);
		
		
		Busqueda busquedaValparaiso = new BusquedaPorPuertoDestino(this.valparaiso);
		Busqueda busquedaPuertoChile = new BusquedaPorPuertoDestino(this.puertoChile);
		Busqueda busquedaFechaLlegadaVal = new BusquedaPorFechaDeLlegada(valparaiso, llegada);
		Busqueda busquedaFechaLlegadaPchile = new BusquedaPorFechaDeLlegada(puertoChile, llegada);

		Busqueda primeraCondicion = new BusquedaAND(busquedaValparaiso, busquedaFechaLlegadaVal);
		Busqueda segundaCondicion = new BusquedaAND(busquedaPuertoChile, busquedaFechaLlegadaPchile);
		
		Busqueda busquedaCompleta = new BusquedaOR(primeraCondicion, segundaCondicion);
		
		ArrayList<Circuito> resultadoBusqueda = busquedaCompleta.buscar(this.ofertaCircuitos);
		
		
		assertTrue(resultadoBusqueda.contains(this.circuitoA));
		assertTrue(resultadoBusqueda.contains(this.circuitoA1));
		assertFalse(resultadoBusqueda.contains(this.circuitoB));
		assertTrue(resultadoBusqueda.contains(this.circuitoC));
		
	}
	
	@Test
	void casoPruebaLlegaAlPuertoChilePeroNOAValparaisoYsaleEl1DeMarzo() {
		// PuertoDestino = puertoChile AND NOT(PuertoDestino = Valpaiso) AND fechaSalida == 1/3/23)
		LocalDate salida = LocalDate.of(2023, 3, 1); 
		
		
		Busqueda busquedaPuertoChile = new BusquedaPorPuertoDestino(this.puertoChile);
		Busqueda busquedaValparaiso = new BusquedaPorPuertoDestino(this.valparaiso);
		Busqueda busquedaFechaSalida = new BusquedaPorFechaDeSalida(salida);
		
		Busqueda noValparaiso = new BusquedaNOT(busquedaValparaiso);
		Busqueda primeraCondicion = new BusquedaAND(busquedaPuertoChile, noValparaiso);
		
		Busqueda busquedaCompleta = new BusquedaAND(primeraCondicion, busquedaFechaSalida);
		
		ArrayList<Circuito> resultadoBusqueda = busquedaCompleta.buscar(this.ofertaCircuitos);
		
		
		assertFalse(resultadoBusqueda.contains(this.circuitoA));
		assertFalse(resultadoBusqueda.contains(this.circuitoA1));
		assertTrue(resultadoBusqueda.contains(this.circuitoB));
		assertFalse(resultadoBusqueda.contains(this.circuitoC));
		
	}
	
	@Test
	void casoPruebaNoSaleEl1erMarzo() {
		// NOT ( fechaSalida = 1/3/23)
		LocalDate salida = LocalDate.of(2023, 3, 1); 
		//configurar mocks
		
		Busqueda busquedaFechaSalida = new BusquedaPorFechaDeSalida(salida);
		
		Busqueda no1DeMarzo = new BusquedaNOT(busquedaFechaSalida);
		
		
		ArrayList<Circuito> resultadoBusqueda = no1DeMarzo.buscar(this.ofertaCircuitos);
		
		
		assertFalse(resultadoBusqueda.contains(this.circuitoA));
		assertTrue(resultadoBusqueda.contains(this.circuitoA1));
		assertFalse(resultadoBusqueda.contains(this.circuitoB));
		assertFalse(resultadoBusqueda.contains(this.circuitoC));
		
	}

}
