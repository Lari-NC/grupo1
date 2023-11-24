package grupo1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TerminalTest {
	
	private Terminal terminal;
	private Posicion posicionDeTerminal;

	@BeforeEach
	void setUp() throws Exception {
		
		posicionDeTerminal = new Posicion(1,1);
		terminal = new Terminal(posicionDeTerminal);
		
	}

	@Test
	void cuandoUnaTerminalEsCredaConLaPosicion1_1_EntoncesSuPosicionSera1_1() {
		assertEquals(posicionDeTerminal, terminal.getPosicion());
	}

}
