package grupo1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PosicionTest {

	@BeforeEach
	void setUp() throws Exception {
		
	}
	
	@Test
	public void seCreaUnaPosicionYObtenerSusCoordenadas() {
		Posicion posicion = new Posicion(3, 5);
	        
		assertEquals(3, posicion.getCoordenadaX());
		assertEquals(5, posicion.getCoordenadaY());
	}
}