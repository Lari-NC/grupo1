package grupo1.circuito;

import grupo1.Posicion;
import grupo1.Terminal;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TramoTest {
	
	private Posicion posicionDeA;
	private Posicion posicionDeB;
	private Terminal terminalA;
	private Terminal terminalB;
	private Tramo tramo1;
	
	@BeforeEach
	void setUp() throws Exception {
		posicionDeA = new Posicion(1,1);
		posicionDeB = new Posicion(1,2); 
		terminalA   = new Terminal(posicionDeA);
		terminalB   = new Terminal(posicionDeB);
		tramo1      = new Tramo(terminalA,terminalB, 1, 1000);
	}

	@Test
	void cuandoUnTramoEsCreadoParaQueVayaDesdeTermAHaciaTermB_SuTerminalDeInicioSeraTermA() {
		assertEquals(terminalA, tramo1.getTerminalInicio());
	}
	
	@Test
	void cuandoUnTramoEsCreadoParaQueVayaDesdeTermAHaciaTermB_SuTerminalDeFinSeraTermB() {
		assertEquals(terminalB, tramo1.getTerminalLlegada());
	}
	
	@Test
	void cuandoUnTramoEsCreadoConUnPrecioFijoDe1000_ElPrecioDeEseTramoEsDe1000() {
		assertEquals(1000, tramo1.getPrecio());
	}
	
	@Test
	void cuandoUnTramoEsCreadoConUnTiempoDe1Dia_ElTiempoQueTardaraElTramoEnLlegarDesdeLaTermInicialALaTermFinal_SeraDe1Dia() {
		assertEquals(1, tramo1.getTiempo());
	}
}
