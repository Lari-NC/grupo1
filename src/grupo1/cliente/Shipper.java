package grupo1.cliente;

import grupo1.Factura;

public class Shipper extends Cliente {
    
    public Shipper () {
    	
    }

	public void recibirFactura(Factura facturaOrden) {
		System.out.print(facturaOrden.getDesgloce());
	}
}