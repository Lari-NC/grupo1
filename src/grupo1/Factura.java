package grupo1;

import java.util.*;

import grupo1.servicios.Servicio;

public class Factura {

	private Viaje viaje;
	private List<Servicio> servicios = new ArrayList<>();
	
	public Factura(Viaje viaje, List<Servicio> serviciosACobrar) {
		this.viaje 		= viaje;
		this.servicios 	= serviciosACobrar;
	}

	public Viaje getViaje() {
		return this.viaje;
	}

	public List<Servicio> getServicios() {
		return this.servicios;
	}
	
	public String getDesgloce() {
		// FALTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
		return ;
	}
}
