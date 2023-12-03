package grupo1.transporte;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ChoferTest {
	
	Chofer chofer;
	
	@BeforeEach
	void setUp() throws Exception {

	}

	@Test
	void testConstructor() {
	    this.chofer = new Chofer();
	    assertNotNull(chofer);
	}
}