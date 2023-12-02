package grupo1.circuito;

import grupo1.Terminal;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TramoTest {
	
	private Terminal terminalA;
	private Terminal terminalB;
	private Tramo tramo1;
	private Tramo tramo2;
	
	@BeforeEach
	void setUp() throws Exception {
		
		this.terminalA = mock(Terminal.class);
		this.terminalB = mock(Terminal.class);
		this.tramo1 = mock(Tramo.class);
			when(this.tramo1.getTerminalInicio()).thenReturn(terminalA);
		    when(this.tramo1.getTerminalLlegada()).thenReturn(terminalB);
		    when(this.tramo1.getTiempo()).thenReturn(1);
		    when(this.tramo1.getPrecio()).thenReturn(1000);
		this.tramo2 = new Tramo(terminalA, terminalB, 1, 1000);
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
		assertEquals(1000, tramo2.getPrecio());
	}
	
	@Test
	void cuandoUnTramoEsCreadoConUnTiempoDe1Dia_ElTiempoQueTardaraElTramoEnLlegarDesdeLaTermInicialALaTermFinal_SeraDe1Dia() {
		assertEquals(1, tramo1.getTiempo());
	}
}
