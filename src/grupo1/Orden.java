package grupo1;
import java.time.LocalDate;

import grupo1.cliente.Consignee;
import grupo1.cliente.Shipper;
import grupo1.containers.Container;
import grupo1.transporte.Camion;
import grupo1.transporte.Chofer;

public class Orden {
    
	private Shipper shipper;
	private Consignee consignee;
	private Container container;
	private Viaje viaje;
	private LocalDate fechaDeSalida;
	private LocalDate fechaDeLlegada;
	private Camion camion;
	private Chofer chofer;
	
    public Orden(Shipper emisor, Consignee receptor, Container container, Viaje viaje, LocalDate fechaDeSalida, LocalDate fechaDeLlegada, Camion camion, Chofer chofer) {
		this.shipper        = emisor;
		this.consignee      = receptor;
		this.container      = container;
		this.viaje          = viaje;
		this.fechaDeSalida  = fechaDeSalida;
		this.fechaDeLlegada = fechaDeLlegada;
		this.camion         = camion;
		this.chofer         = chofer;
    }

	public Shipper getShipper() {
		return this.shipper;
	}

	public Consignee getConsignee() {
		return this.consignee;
	}

	public Container getContainer() {
		return this.container;
	}

	public LocalDate getFechaDeSalida() {
		return this.fechaDeSalida;
	}

	public Viaje getViaje() {
		return this.viaje;
	}

	public LocalDate getFechaDeLlegada() {
		return this.fechaDeLlegada;
	}

	public Camion getCamion() {
		return this.camion;
	}

	public Chofer getChofer() {
		return this.chofer;
	}
    
}
