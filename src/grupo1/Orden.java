package grupo1;

import java.time.LocalDate;
import java.util.*;

import grupo1.cliente.Consignee;
import grupo1.cliente.Shipper;
import grupo1.containers.Container;
import grupo1.transporte.Camion;
import grupo1.transporte.Chofer;
import grupo1.servicios.Servicio;

public class Orden {
    
	private Shipper shipper;
	private Consignee consignee;
	private Container container;
	private Viaje viaje;
	private LocalDate fechaDeSalida;
	private LocalDate fechaDeLlegada;
	private Camion camion;
	private Chofer chofer;
	private List<Servicio> servicios = new ArrayList<>();
	
    public Orden(Shipper emisor, Consignee receptor, Container container, Viaje viaje, LocalDate fechaDeSalida, LocalDate fechaDeLlegada, Camion camion, Chofer chofer, List<Servicio> servicios) {
		// Los servicios son una lista de servicios solicitados por el cliente que realiza la orden, sin contar los establecidos por la terminal.
    	this.shipper        = emisor;
		this.consignee      = receptor;
		this.container      = container;
		this.viaje          = viaje;
		this.fechaDeSalida  = fechaDeSalida;
		this.fechaDeLlegada = fechaDeLlegada;
		this.camion         = camion;
		this.chofer         = chofer;
		this.servicios 		= servicios;
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
	
	public Terminal getTerminalDestino() {
		return this.getViaje().getTerminalDestino();
	}

	public List<Servicio> getServicios() {
		return servicios;
	}
	
	public Factura getFactura() {
		// precioViaje(PrecioCircuito), precioPorServicio, precioTotal.
		Factura factura = new Factura(this.getViaje(), this.getServicios());
		return factura;
	}
	
	public void agregarServicioAlmacenamiento() {
		//this.getServicios().add(??); 
		// FALTA COMPORTAMIENTO.
	}
	
	public void agregarServicioPesado() {
		//this.getServicios().add(??);
	}
}
