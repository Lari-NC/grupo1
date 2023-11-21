package grupo1;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.*;


import grupo1.servicios.Servicio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestFactura {

    private Viaje viaje;
    private List<Servicio> servicios;

    @BeforeEach
    void setUp() throws Exception {
        this.viaje = mock(Viaje.class);
        when(viaje.getPrecioViaje()).thenReturn(10000);

        Servicio servicioAlmacenamiento = mock(Servicio.class);
        when(servicioAlmacenamiento.getTipoServicio()).thenReturn("Almacenamiento");
        when(servicioAlmacenamiento.getPrecio()).thenReturn(400);

        Servicio servicioLavado = mock(Servicio.class);
        when(servicioLavado.getTipoServicio()).thenReturn("Lavado");
        when(servicioLavado.getPrecio()).thenReturn(500);

        servicios = new ArrayList<>();
        servicios.add(servicioAlmacenamiento);
        servicios.add(servicioLavado);
    }

    @Test
    public void testGetDesgloce() {
        Factura factura = new Factura(viaje, servicios);

        String resultado = factura.getDesgloce();
        String resultadoEsperado = "Viaje Completo\t$10000\n\nServicios:\nAlmacenamiento\t$400\nLavado\t$500\n";

        assertEquals(resultadoEsperado, resultado);
    }
}