package grupo1;

import java.util.*;

import grupo1.servicios.Servicio;

public class Factura {
//aaaa
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
        StringBuilder desgloce = new StringBuilder();
        desgloce.append("Viaje Completo")
        .append("\t$")
        .append(viaje.getPrecioViaje())
        .append("\n")
        .append("\n")
        .append("Servicios:")
        .append("\n");
        
        for (Servicio s : servicios) {
            desgloce.append(s.getTipoServicio())
                    .append("\t$")
                    .append(s.getPrecio())
                    .append("\n");
        }

        return desgloce.toString();
    }

}
	

