package grupo1;
import java.time.LocalDate;
import java.util.*;

import grupo1.circuito.Circuito;
import grupo1.cliente.Consignee;
import grupo1.cliente.Shipper;
import grupo1.containers.Container;
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
    private List<Orden> ordenes = new ArrayList<>();
    private List<Container> cargasPorRetirar = new ArrayList<>();

    public TerminalGestionada(Posicion p) {
        super(p);
    }

    // REGISTROS: 
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
		return this.ordenes;
	}
	
	public List<Chofer> getChoferesPermitidos() {
        return choferesPermitidos;
    }

    public List<Camion> getCamionesPermitidos() {
        return camionesPermitidos;
    }
	
    
    // IMPORTACIÓN:
	public void recibirOrdenDeImportación(Orden ordenDeImportacion) {
		if (ordenDeImportacion.getTerminalDestino() == this) {
			this.agregarCargaACargasPorRetirar(ordenDeImportacion.getContainer());
			this.notificarAlClienteRetiroDeCarga(ordenDeImportacion.getConsignee());
		}
	}
	
	public void notificarAlClienteRetiroDeCarga(Consignee consignee) {
		this.enviarMailNotificandoA(consignee);
	}
	
	public void agregarCargaACargasPorRetirar(Container carga) {
		this.getCargasPorRetirar().add(carga);
	}
	
	public List<Container> getCargasPorRetirar() {
		return this.cargasPorRetirar;
	}
	
	public void enviarMailNotificandoA(Consignee consignee) {
		return ; //no envía el mail pero lo dejamos a modo simbolico
	}
	
	public void realizarRetiroDeCargaDeOrden(Orden orden) throws IllegalArgumentException {
		
		this.entraUnCamionALaTerminal(orden.getCamion());
		
		if (!this.pasaron24HorasDesdeQueLlegoLaCarga()) {
			this.getCargasPorRetirar().remove(orden.getContainer());
		}
		
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
    public void registrarExportacion (Shipper emisor, Consignee receptor, Container container, Viaje viaje, LocalDate fechaDeSalida, LocalDate fechaDeLlegada, Camion camion, Chofer chofer) {
    	Orden ordenARegistar = new Orden(emisor, receptor, container, viaje, fechaDeSalida, fechaDeLlegada, camion, chofer);
    	this.ordenes.add(ordenARegistar);
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