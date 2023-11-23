package grupo1.servicios;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ServicioTest {

	private Pesado servicioPesado;
	private Almacenamiento servicioAlmacenamiento;
	
	@BeforeEach
	void setUp() throws Exception {
		this.servicioPesado = new Pesado(900);
		this.servicioAlmacenamiento = new Almacenamiento(1200);
		/* Mock:
		this.servicioPesado = mock(Pesado.class);
	    when(this.servicioPesado.getTipoServicio()).thenReturn("Pesado");
	    when(this.servicioPesado.getPrecio()).thenReturn(900);
	    this.servicioAlmacenamiento = mock(Almacenamiento.class);
	    when(this.servicioAlmacenamiento.getTipoServicio()).thenReturn("Almacenamiento");
	    when(this.servicioAlmacenamiento.getPrecio()).thenReturn(1200);
	    */
	}

	@Test
	void testTipoServicioPesado() {
		String resultado = this.servicioPesado.getTipoServicio();
		assertEquals("Pesado", resultado);
	}
	
	@Test
	void testTipoServicioAlmacenamiento() {
		String resultado = this.servicioAlmacenamiento.getTipoServicio();
		assertEquals("Almacenamiento", resultado);
	}

}
