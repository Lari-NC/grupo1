package grupo1.cliente;

import grupo1.Factura;

public class Shipper {

    public void recibirFactura(Factura facturaOrden) {
		System.out.print(facturaOrden.getDesgloce());
	}
    
    public void recibirMailCargaEnviada() {
		System.out.print("Su carga fue enviada! Puede realizar el seguimiento de la misma desde nuestra página web con su nro de DNI.");
	}
}