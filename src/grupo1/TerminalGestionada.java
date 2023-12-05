package grupo1;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

import grupo1.buque.Buque;
import grupo1.circuito.Circuito;
import grupo1.circuito.Tramo;
import grupo1.cliente.Consignee;
import grupo1.cliente.Shipper;
import grupo1.containers.Container;
import grupo1.mejorCircuito.Naviera;
import grupo1.servicios.Almacenamiento;
import grupo1.servicios.Electricidad;
import grupo1.servicios.Pesado;
import grupo1.servicios.Servicio;
import grupo1.transporte.Camion;
import grupo1.transporte.Chofer;
import grupo1.transporte.EmpresaTransportista;

public class TerminalGestionada extends Terminal{

//INITIALIZE:	
    private List<Naviera> navieras 				= new ArrayList<>();
    private List<Shipper> shippers 				= new ArrayList<>();
    private List<Consignee> consignees 			= new ArrayList<>();
    private List<EmpresaTransportista> empresas = new ArrayList<>();
    private List<Camion> camionesPermitidos 	= new ArrayList<>();
    private List<Chofer> choferesPermitidos 	= new ArrayList<>();
    private List<Circuito> circuitosDeInteres 	= new ArrayList<>();
    private List<Orden> ordenesExpo 			= new ArrayList<>();
    private List<Orden> ordenesImpo 			= new ArrayList<>();
    private List<Servicio> serviciosAOfrecer	= new ArrayList<>();
    private int precioServicioPesado;
    private int precioServicioAlmacenamientoPorDiaExtra;
    private int precioServicioElectricidadPorDiaExtra;
    
    public TerminalGestionada(Posicion p, int precioP, int precioA, int precioE) { 
    	super(p);
    	this.precioServicioPesado = precioP;
    	this.precioServicioAlmacenamientoPorDiaExtra = precioA;
    	this.precioServicioElectricidadPorDiaExtra = precioE;
    }

   
    // IMPORTACIÓN:
	public void agregarOrdenImportacion(Orden orden) {
		this.ordenesImpo.add(orden);
	}
	
	public void notificarAlClienteRetiroDeCarga(Consignee consignee) {
		consignee.recibirMailParaRetiro();
	}
	
	public void realizarRetiroDeCargaDeOrden(Orden orden, Camion camion, LocalDate fechaRetiro) { 
		// Entra el camion, si tarda más de 24 hs el retiro de la carga se le agrega a la orden 
		// de la misma un servicio de almacenamiento por día que de retraso

        this.entraUnCamionALaTerminalConUnaOrden(camion, orden);
        int diasEntreRetiroYLlegada = (Period.between(orden.getFechaDeLlegada(), fechaRetiro)).getDays();
        
        for(int i = diasEntreRetiroYLlegada; i > 0; i--) {
        	this.agregarServicioAlmacenamientoA(orden);
        }
        
        for(int i = diasEntreRetiroYLlegada; i > 0; i--) {
        	this.agregarServicioElectricidadA(orden);
        }
        
        this.realizarEntregaCarga(orden);
	}

	private void realizarEntregaCarga(Orden orden) {
		this.getOrdenesImportacion().remove(orden);
	}
	
    private void agregarServicioAlmacenamientoA(Orden orden) {
    	Almacenamiento servicioAlmacenamientoAAsignar = new Almacenamiento(this.getPrecioServicioAlmacenamientoPorDiaExtra());
    	orden.agregarServicioDeTerminal(servicioAlmacenamientoAAsignar);
	}
    
    private void agregarServicioElectricidadA(Orden orden) {
    	Electricidad servicioElectricidadAAsignar = new Electricidad(this.getPrecioServicioElectricidadPorDiaExtra());
    	orden.agregarServicioDeTerminal(servicioElectricidadAAsignar);
	}

	public void recibirBuqueAvisoInbound(Buque buque) {
		// Da aviso a todos los clientes de nuestras ordenes de importación que tienen al buque que dió el aviso
		for(Orden o : this.ordenesImpo) {
			if(o.getViaje().getBuque() == buque) {
				this.notificarAlClienteRetiroDeCarga(o.getConsignee());
			}
		}
	}
	
	public void recibirBuqueAvisoOutbound(Buque buque) {
		// Da aviso a todos los clientes de nuestras ordenes de importación que tienen al buque que dió el aviso
		for(Orden o : this.getOrdenesImportacion()) {
			if(o.getViaje().getBuque() == buque) {
				this.facturarOrden(o);
			}
		}
	}
	
	 private void facturarOrden(Orden orden) {
	    // Se genera la factura de una orden y se la envia al shipper.
	    Factura facturaOrden = new Factura(orden.getViaje(), orden.getServicios());
	    (orden.getShipper()).recibirFactura(facturaOrden);
	}
    
    
    //SEGURIDAD:
	public void entraUnCamionALaTerminalConUnaOrden(Camion camion, Orden orden) {
		// Chequea si el camion y el chofer estan registrados en la terminal
        this.chequearSiElCamionEstaRegistrado(camion);
        this.chequearSiElChoferEstaRegistrado(camion.getChofer());
        this.chequearSiElCamionEstaDeclaradoEnLaOrden(camion, orden);
    	this.chequearSiElChoferEstaDeclaradoEnLaOrden(camion.getChofer(), orden);
    }
    
    //MANEJO BUQUES:
    public void darOrdenWorking(Buque buque) {
    	buque.recibirOrdenWorking();
    }
    
    public void darOrdenDepart(Buque buque) {
    	buque.recibirOrdenDepart();
    }
	
    
    //EXPORTACIÓN:
    public void registrarExportacion (Shipper emisor, Consignee receptor, Container container, Viaje viaje, LocalDate fechaDeSalida, LocalDate fechaDeLlegada, Camion camion, Chofer chofer, List<Servicio> servicios) {
    	Orden ordenARegistar = new Orden(emisor, receptor, container, viaje, fechaDeSalida, fechaDeLlegada, camion, chofer, servicios);
    	Pesado servicioPesadoAAsignar = new Pesado(this.getPrecioServicioPesado());
    	ordenARegistar.agregarServicioDeTerminal(servicioPesadoAAsignar);
    	this.ordenesExpo.add(ordenARegistar);
    }
    
	public void recibirBuqueAvisoDepart(Buque buque) {
		// Da aviso a todos los clientes de nuestras ordenes de importación que tienen al buque que dió el aviso
		for(Orden o : this.ordenesExpo) {
			if(o.getViaje().getBuque() == buque) {
				this.notificarAlClienteSalidaDeCarga(o.getShipper());
			}
		}
	}
    
    private void notificarAlClienteSalidaDeCarga(Shipper shipper) {
    	shipper.recibirMailCargaEnviada();
	}
    
    
 // REGISTRAR(setters): 
    public void registrarNaviera(Naviera naviera) {
        this.navieras.add(naviera); 
    }

    public void registrarShipper(Shipper shipper) {
        this.shippers.add(shipper); 
    }

    public void registrarConsignee(Consignee consignee) {
        this.consignees.add(consignee); 
    }
    
    public void registrarEmpresaTranportista(EmpresaTransportista empresa) {
        this.empresas.add(empresa); 
    }

    public void registrarCamion(Camion camion) {
        this.camionesPermitidos.add(camion); 
    }

    public void registrarChofer(Chofer chofer) {
        this.choferesPermitidos.add(chofer); 
    }
    
    public void registrarServiciosAOfrecer(List<Servicio> servicios) {
    	this.getServiciosAOfrecer().addAll(servicios);
    }
    
    public void registrarServicioAOfrecer(Servicio servicio) {
    	this.getServiciosAOfrecer().add(servicio);
    }
    
    public void registrarCircuitosDeInteres() {
        for(Naviera naviera : this.navieras) {
        	this.circuitosDeInteres.addAll(naviera.circuitosQuePasanPorTerminal(this));
        }
    }
    
    public void modificarPrecioServicioPesado(int precio) {
    	this.precioServicioPesado = precio;
    }
    
    public void modificarPrecioServicioAlmacenamientoPorHoraExtra(int precio) {
    	this.precioServicioAlmacenamientoPorDiaExtra = precio;
    }
    
    public void modificarPrecioServicioElectricidadPorDiaExtra(int precio) {
    	this.precioServicioElectricidadPorDiaExtra = precio;
    }
    
    
    // GETTERS:
	public List<Orden> getOrdenesExportacion() {
		return this.ordenesExpo; 
	}
	
	public List<Orden> getOrdenesImportacion() {
		return this.ordenesImpo; 
	}
	
	public List<Chofer> getChoferesPermitidos() {
        return choferesPermitidos; 
    }

    public List<Camion> getCamionesPermitidos() {
        return camionesPermitidos; 
    }
	
	public List<Servicio> getServiciosAOfrecer() {
		return serviciosAOfrecer; 
	}
	
	public int getPrecioServicioPesado() {
		return this.precioServicioPesado;
	}
	
	public int getPrecioServicioAlmacenamientoPorDiaExtra() {
		return this.precioServicioAlmacenamientoPorDiaExtra;
	}
	
	public int getPrecioServicioElectricidadPorDiaExtra() {
		return this.precioServicioElectricidadPorDiaExtra;
	}
	
	public List<Circuito> getCircuitosDeInteres(){
		return this.circuitosDeInteres;
	}
	
	public List<Naviera> getNavieras() {
		return this.navieras;
	}
	
	public List<Shipper> getShippers() {
		return this.shippers;
	}
	
	public List<Consignee> getConsignees() {
		return this.consignees;
	}
	
	public List<EmpresaTransportista> getEmpresasTransportistas() {
		return this.empresas;
	}
	
	
    //Otros getters :)
    public int cantidadDeTiempoQueTardaLaNaviera_EnLlegarA_(Naviera naviera, Terminal terminalDestino) {
		// 4. Devuelve cuanto tarda una naviera en llegar desde la terminal gestionada hacia otra terminal, independientemente 
    	// de las fechas de los viajes programados.
		return naviera.tiempoDeViajeDesdeHastaTerminal(this, terminalDestino);
	}
    
	public LocalDate proximaFechaDePartidaATerminal(Terminal terminalDestino) {
		// 5. Devolver la próxima fecha de partida de un buque desde la terminal gestionada hasta otra terminal 
		// de destino.
		
		List<Circuito> circuitosATerminalDestino = this.circuitosQueIncluyenTramoATerminal(terminalDestino);
		LocalDate fechaMinimaAlMomento = LocalDate.MAX;
		for(Circuito c : circuitosATerminalDestino) {
			Tramo tramoDesdeTerminalGestionada = c.getTramoConSalidaDesde(this);
			LocalDate fechaSalidaTramo = c.getFechaSalidaTramo(tramoDesdeTerminalGestionada);
			if(fechaSalidaTramo.isBefore(fechaMinimaAlMomento)) {
				fechaMinimaAlMomento = fechaSalidaTramo;
			}
		}
		return fechaMinimaAlMomento;     
	}
	
	public List<Circuito> circuitosQueIncluyenTramoATerminal(Terminal terminalDestino){
		List<Circuito> cs = new ArrayList<>();
		for(Circuito c : this.getCircuitosDeInteres()) {
			if(c.incluyeATerminalAntesDeTerminalB(this, terminalDestino)) {
				 cs.add(c);
			}
		}
		return cs;
	}
	
	
	//Errores seguridad:
    private void chequearSiElCamionEstaRegistrado(Camion camion) {
    	if (!this.getCamionesPermitidos().contains(camion)) {
        	throw new IllegalArgumentException("El camion no tiene el ingreso permitido a la terminal");
        }  
    }

    private void chequearSiElChoferEstaRegistrado(Chofer chofer) {
    	if (!this.getChoferesPermitidos().contains(chofer)) {
        	throw new IllegalArgumentException("El chofer no tiene el ingreso permitido a la terminal");
    	} 
    }
 
	public void chequearSiElChoferEstaDeclaradoEnLaOrden(Chofer chofer, Orden orden) {
		if (!(orden.getChofer()==chofer)) {
        	throw new IllegalArgumentException("El chofer no es el declarado en la orden");
    	} 
	}

	public void chequearSiElCamionEstaDeclaradoEnLaOrden(Camion camion, Orden orden) {
		if (!(orden.getCamion()==camion)) {
        	throw new IllegalArgumentException("El camion no es el declarado en la orden");
    	} 
	}
}
