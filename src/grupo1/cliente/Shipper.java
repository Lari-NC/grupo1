package grupo1.cliente;

import grupo1.Factura;

public class Shipper extends Cliente {
    
    public Shipper (String nombre, int dni, String domicilio, int telefono, String mail) {
        super(nombre, dni, domicilio, telefono, mail);
    }

	public void recibirFactura(Factura facturaOrden) {
		System.out.print(facturaOrden.getDesgloce());
	}
}