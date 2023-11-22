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
	
	
    private List<Naviera> navieras = new ArrayList<>();
    private List<Shipper> shippers = new ArrayList<>();
    private List<Consignee> consignees = new ArrayList<>();
    private List<EmpresaTransportista> empresas = new ArrayList<>();
    private List<Camion> camionesPermitidos = new ArrayList<>();
    private List<Chofer> choferesPermitidos = new ArrayList<>();
    private List<Circuito> circuitosDeInteres = new ArrayList<>();
    private List<Orden> ordenesExpo= new ArrayList<>();
    private List<Container> cargasPorRetirar = new ArrayList<>();
    //si tenemos las listas de todas las ordenes de impo y de expo?? 
    
    
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
    

    // GETTERS:
	public List<Orden> getOrdenes() {
		return this.ordenesExpo;
	}
	
	public List<Chofer> getChoferesPermitidos() {
        return choferesPermitidos;
    }

    public List<Camion> getCamionesPermitidos() {
        return camionesPermitidos;
    }
	
	public List<Container> getCargasPorRetirar() {
		return this.cargasPorRetirar;
	}
    
    // IMPORTACIÓN:
    // saco el if xq es algo que se asume que es 
	public void recibirOrdenDeImportación(Orden ordenDeImportacion) {// es recibir orden de impo? o es recibir una carga apra que retiren????
		//llega el buque, deja las cargas apra que retiren 
		this.agregarCargaACargasPorRetirar(ordenDeImportacion.getContainer());
		// lo hace la fase del buque que deja las cosas: this.notificarAlClienteRetiroDeCarga(ordenDeImportacion.getConsignee());
	}
	
	public void llegaUnaImportacion() {
		//refactor de ^^
	}
	
	public void notificarAlClienteRetiroDeCarga(Consignee consignee) {
		consignee.recibirMailParaRetiro();
	}
	
	public void agregarCargaACargasPorRetirar(Container carga) {
		// hacer q reciba una lista y agregue todas, porque l buque no deja de a 1
		this.getCargasPorRetirar().add(carga);
	}

	public void realizarRetiroDeCargaDeOrden(Orden orden, Camion camion) throws IllegalArgumentException {
		
		this.entraUnCamionALaTerminal(camion);
		this.realizarEntregaCarga(orden);
		this.agregarServicioAlmacenamiento(orden);
			
	}
	
	
	private void agregarServicioAlmacenamiento(Orden orden) {
		if (!this.pasaron24HorasDesdeQueLlegoLaCarga()) {
			orden.agregarServicioAlmacenamiento();
		}
	}

	private void realizarEntregaCarga(Orden orden) {
		this.getCargasPorRetirar().remove(orden.getContainer());
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