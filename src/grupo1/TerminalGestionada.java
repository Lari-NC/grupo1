package grupo1;

import java.time.LocalDate;
import java.util.*;

import grupo1.buque.Buque;
import grupo1.circuito.Circuito;
import grupo1.cliente.Consignee;
import grupo1.cliente.Shipper;
import grupo1.containers.Container;
import grupo1.servicios.Servicio;
import grupo1.transporte.Camion;
import grupo1.transporte.Chofer;
import grupo1.transporte.EmpresaTransportista;

public class TerminalGestionada extends Terminal{
	
	
    private List<Naviera> navieras 				= new ArrayList<>();
    private List<Shipper> shippers 				= new ArrayList<>();
    private List<Consignee> consignees 			= new ArrayList<>();
    private List<EmpresaTransportista> empresas = new ArrayList<>();
    private List<Camion> camionesPermitidos 	= new ArrayList<>();
    private List<Chofer> choferesPermitidos 	= new ArrayList<>();
    private List<Circuito> circuitosDeInteres 	= new ArrayList<>();
    private List<Orden> ordenesExpo 			= new ArrayList<>();
    private List<Orden> ordenesImpo 			= new ArrayList<>();
    private List<Orden> ordenesPorRetirar 		= new ArrayList<>();
    private List<Servicio> serviciosAOfrecer	= new ArrayList<>();
    
    
    public TerminalGestionada(Posicion p) {
        super(p);
    }

    // REGISTRAR: 
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
    
    public void registarCircuitosDeInteres() {
        for(Naviera naviera : this.navieras) {
        	this.circuitosDeInteres.addAll(naviera.circuitosQuePasanPorTerminal(this));
        }
    }
    
    public void registrarServiciosAOfrecer(List<Servicio> servicios) {
    	this.getServiciosAOfrecer().addAll(servicios);
    }
    
    public void registrarServicioAOfrecer(Servicio servicio) {
    	this.getServiciosAOfrecer().add(servicio);
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
	
	public List<Orden> getOrdenesPorRetirar() {
		return this.ordenesPorRetirar;
	}
	
	public List<Servicio> getServiciosAOfrecer() {
		return serviciosAOfrecer;
	}
    
    // IMPORTACIÓN:
	
	public void agregarOrdenImportacion(Orden orden) {
		this.ordenesImpo.add(orden);
	}
	
	public void llegaUnaBuque(Buque buque) {
		//refactor de ^^ xq creo que no es
	}
	
	public void notificarAlClienteRetiroDeCarga(Consignee consignee) {
		consignee.recibirMailParaRetiro();
	}
	
	public void agregarOrdenesPorRetirar(Buque buque) {
		// Ver lo de fechaaaa D:
		List<Orden> ordenesParaRetirar = new ArrayList<>();
		for (Orden o : this.getOrdenesImportacion()) {
			Container cont = o.getContainer();
			for (Container c : buque.getCargas()) {
				if(cont == c) {
					ordenesParaRetirar.add(o);
				}
			}
		}
		this.ordenesPorRetirar.addAll(ordenesParaRetirar);
	}

	public void realizarRetiroDeCargaDeOrden(Orden orden, Camion camion) throws IllegalArgumentException {
		
		this.entraUnCamionALaTerminal(camion);
		this.realizarEntregaCarga(orden);
		this.agregarServicioAlmacenamiento(orden);
			
	}
	
	private void agregarServicioAlmacenamiento(Orden orden) {
		// puede que la que la llame tmb le pase la fecha hora actual de cuando llega el camion
		// para poder comparar si pasaron 24 hs
		
		if (!this.pasaron24HorasDesdeQueLlegoLaCarga()) {
			orden.agregarServicioAlmacenamiento();//pequeño detalle el almacenamineto tiene un precio como lo paso? q tb deberia ser x
		}
	}

	private void realizarEntregaCarga(Orden orden) {
		// this.getCargasPorRetirar().remove(orden.getContainer());
		this.getOrdenesPorRetirar().remove(orden);
	}

	public boolean pasaron24HorasDesdeQueLlegoLaCarga() {
		return ;
	}
	
	
	public void entraUnCamionALaTerminal(Camion camion) {
        this.chequearSiElCamionEstaRegistrado(camion);
        this.chequearSiElChoferEstaRegistrado(camion.getChofer());
    }

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
    
    //HAY QUE VER COMO MANDAR LA FACTURA apra usar este mensaje 
    
    private void facturarOrden(Orden orden) {
    	// Se le envia la factura al shipper, el encargado de el pedido. Despues como deciden encargarse
    	// de dividirse los pagos no nos importa como terminal
    	
    	Factura facturaOrden = new Factura(orden.getViaje(), orden.getServicios());
    	(orden.getShipper()).recibirFactura(facturaOrden);
    }
    
    
    
    //EXPORTACIÓN:
    public void registrarExportacion (Shipper emisor, Consignee receptor, Container container, Viaje viaje, LocalDate fechaDeSalida, LocalDate fechaDeLlegada, Camion camion, Chofer chofer,List<Servicio> servicios) {
    	Orden ordenARegistar = new Orden(emisor, receptor, container, viaje, fechaDeSalida, fechaDeLlegada, camion, chofer, servicios);
    	this.ordenesExpo.add(ordenARegistar);
    }
    
    // FALTAN:
    public Circuito mejorCircuitoHasta_(Terminal terminalDestino) {
		/*3.Devolver el mejor circuito que une a la terminal con un determinado puerto destino.
		*/
		return ;
	}
    
	public int cantidadDeTiempoQueTardaLaNaviera_EnLlegarA_(Naviera naviera, Terminal terminalDestino) {
		/*4.Devolver cuánto tarda una naviera en llegar desde la terminal gestionada hacia 
			otra terminal, independientemente de las fechas de los viajes programados.
		*/
		return ;
	}
	
	public LocalDate proximaFechaDePartidaDelBuque_HastaTerminal_ (Buque buque, Terminal terminalDestino) {
		/*5.Devolver la próxima fecha de partida de un buque desde la terminal gestionada hasta 
		    otra terminal de destino.
		*/
		return ;
	}

}