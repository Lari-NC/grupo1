package grupo1.cliente;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.PrintStream;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import grupo1.Factura;


class ShipperTest {

	private Shipper shipper;
    private PrintStream mockPrintStream;
    private Factura factura;
  

    
    @BeforeEach
	void setUp() throws Exception {
    	this.shipper = new Shipper();
    	this.mockPrintStream = mock(PrintStream.class);
    	this.factura = mock(Factura.class);
    	when(this.factura.getDesgloce()).thenReturn("test123");
	}
    
    @Test
    void testRecibirMailParaRetiro() {
 
        System.setOut(this.mockPrintStream);

        shipper.recibirMailCargaEnviada();

        verify(mockPrintStream).print("Su carga fue enviada! Puede realizar el seguimiento de la misma desde nuestra página web con su nro de DNI.");

    }
    
    @Test
    void recibirFactura() {
 
        System.setOut(this.mockPrintStream);

        shipper.recibirFactura(factura);

        verify(mockPrintStream).print("test123");

    }
}
