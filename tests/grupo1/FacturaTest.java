package grupo1;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.*;


import grupo1.servicios.Servicio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FacturaTest {

    private Viaje viajeFactura;
    private Servicio servicioLavado;
    private  Servicio servicioAlmacenamiento;
    private List<Servicio> serviciosFactura = new ArrayList<>();;
    private Factura factura;

    @BeforeEach
    void setUp() throws Exception {
        //mocks
    	this.viajeFactura = mock(Viaje.class);
        when(this.viajeFactura.getPrecioViaje()).thenReturn(10000);

        this.servicioAlmacenamiento = mock(Servicio.class);
        when(this.servicioAlmacenamiento.getTipoServicio()).thenReturn("Almacenamiento");
        when(this.servicioAlmacenamiento.getPrecio()).thenReturn(400);

        this.servicioLavado = mock(Servicio.class);
        when(this.servicioLavado.getTipoServicio()).thenReturn("Lavado");
        when(this.servicioLavado.getPrecio()).thenReturn(500);

        this.serviciosFactura.add(this.servicioAlmacenamiento);
        this.serviciosFactura.add(this.servicioLavado);
    }

    @Test
    public void testGetDesgloce() {
    	
    	this.factura = new Factura(viajeFactura, serviciosFactura);
        String resultado = this.factura.getDesgloce();
        String resultadoEsperado = "Viaje Completo\t$10000\n\nServicios:\nAlmacenamiento\t$400\nLavado\t$500\n";

        assertEquals(resultadoEsperado, resultado);
    }
}