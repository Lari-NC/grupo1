package grupo1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PosicionTest {

	@BeforeEach
	void setUp() throws Exception {}
	@Test
	   public void seCreaUnaPosicionYObtenerSusCoordenadas() {
	      Posicion posicion = new Posicion(3, 5);
	        
	      assertEquals(3, posicion.getCoordenadaX());
	      assertEquals(5, posicion.getCoordenadaY());
	    }

	@Test
	  public void unaposicionPuedeCalcualrLaDistanciaHastaOtraPosicion() {
	      Posicion posicion1 = new Posicion(1, 2);
	      Posicion posicion2 = new Posicion(4, 6);

	      int distancia = posicion1.distanciaHasta(posicion2);

	      assertEquals(5, distancia);
	    }

	 @Test
	   public void distanciaEntrePosicionesConNegativos() {
	      Posicion posicion1 = new Posicion(-1, -2);
	      Posicion posicion2 = new Posicion(2, 3);

	      int distancia = posicion1.distanciaHasta(posicion2);

	      assertEquals(5, distancia);
	    }
	}