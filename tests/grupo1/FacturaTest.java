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
    private List<Servicio> serviciosFactura;
    private Factura factura;

    @BeforeEach
    void setUp() throws Exception {
        //mocks
    	viajeFactura = mock(Viaje.class);
        when(viajeFactura.getPrecioViaje()).thenReturn(10000);

        servicioAlmacenamiento = mock(Servicio.class);
        when(servicioAlmacenamiento.getTipoServicio()).thenReturn("Almacenamiento");
        when(servicioAlmacenamiento.getPrecio()).thenReturn(400);

        servicioLavado = mock(Servicio.class);
        when(servicioLavado.getTipoServicio()).thenReturn("Lavado");
        when(servicioLavado.getPrecio()).thenReturn(500);

        
        serviciosFactura.add(servicioAlmacenamiento);
        serviciosFactura.add(servicioLavado);
        
        factura = new Factura(viajeFactura, serviciosFactura);
    }

    @Test
    public void testGetDesgloce() {
    	
        String resultado = factura.getDesgloce();
        String resultadoEsperado = "Viaje Completo\t$10000\n\nServicios:\nAlmacenamiento\t$400\nLavado\t$500\n";

        assertEquals(resultadoEsperado, resultado);
    }
}