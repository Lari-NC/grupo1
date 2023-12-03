package grupo1.cliente;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConsigneeTest {

	private Consignee consignee;
    private PrintStream mockPrintStream;
    
    
    @BeforeEach
	void setUp() throws Exception {
    	this.consignee = new Consignee();
    	this.mockPrintStream = mock(PrintStream.class);
	}
    
    @Test
    void testRecibirMailParaRetiro() {
        System.setOut(this.mockPrintStream);
        consignee.recibirMailParaRetiro();
        verify(mockPrintStream).print("Su carga esta en camino! Dentro de 5 horas ya podra retirarla en nuestra Terminal. Recuerde que excedidas las 24hs se le cobrara un servicio de almacenamiento extra.");
    }
}