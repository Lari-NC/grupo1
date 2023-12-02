package grupo1.servicios;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import grupo1.containers.Container;
import grupo1.containers.Reefer;

class ServicioTest {
	
	private Pesado servicioPesado;
	private Almacenamiento servicioAlmacenamiento;
	private Lavado servicioLavado;
	private Electricidad servicioElectricidad;
	private Container container;
	private Container container1;
	private Reefer containerReefer;
	
	@BeforeEach
	void setUp() throws Exception {
		
		this.servicioPesado = new Pesado(900);
		this.servicioAlmacenamiento = new Almacenamiento(1200);
		this.servicioLavado = new Lavado(1000);
		servicioElectricidad = new Electricidad(900000000);
		container = new Container(5,10,5,100);
		container1 = new Container(2,6,2,70);
		/* Mock:
		this.servicioPesado = mock(Pesado.class);
	    when(this.servicioPesado.getTipoServicio()).thenReturn("Pesado");
	    when(this.servicioPesado.getPrecio()).thenReturn(900);
	    this.servicioAlmacenamiento = mock(Almacenamiento.class);
	    when(this.servicioAlmacenamiento.getTipoServicio()).thenReturn("Almacenamiento");
	    when(this.servicioAlmacenamiento.getPrecio()).thenReturn(1200);
	    */
		this.containerReefer = new Reefer(2,6,2,70,100);
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
	
	@Test
	void enUnServicioDePesadoCreadoConUnCostoDe900_SuPrecioSeraDe900() {
		assertEquals(900, servicioPesado.getPrecio());
	}
	
	@Test
	void siUnServicioDeLavadoDe1000EsUtilizadoEnUnContainerDe250MetrosCubicos_EntoncesElCostoDeServicioSeraDe2000_PorSuperarElVolumenPermitido() {
		assertEquals(2000, servicioLavado.getPrecioPara(container));
	}
	
	@Test
	void siUnServicioDeLavadoDe1000EsUtilizadoEnUnContainerDe24MetrosCubicos_EntoncesElCostoDeServicioSeraDe1000_PorNOSuperarElVolumenPermitido() {
		assertEquals(1000, servicioLavado.getPrecioPara(container1));
	}
	
	@Test
	void enUnServicioDeElectricidadCreadoConUnCostoDe900000000_SuPrecioSeraDe900000000() {
		assertEquals(900000000, servicioElectricidad.getPrecio());
	}
	
	
	@Test
	void alMomentoDePreguntarPorElDelServicioDeElectricidadParaUnContainerEnEspecifico_NosDaraComoResultado() {
		assertEquals(2.16E12, this.servicioElectricidad.getPrecioPara(containerReefer));
	}
	/*
	@Test
	void alMomentoDePreguntarPorElDelServicioDeElectricidadParaUnContainerEnEspecifico_NosDaraComoResultado() {
		assertEquals((this.containerReefer.getConsumo()*this.servicioElectricidad.getPrecio()*24), this.servicioElectricidad.getPrecioPara(containerReefer));
	}
	*/
}
