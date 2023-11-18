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

    public TerminalGestionada() {
        super();
    }

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
        for(Naviera naviera : this.navieras){
        	this.circuitosDeInteres.addAll(naviera.circuitosQuePasanPorTerminal(this));
        }
    }
    
    public void registrarExportacion (Shipper emisor, Consignee receptor, Container container, Viaje viaje, LocalDate fechaDeSalida, LocalDate fechaDeLlegada, Camion camion, Chofer chofer) {
    	Orden ordenARegistar = new Orden(emisor, receptor, container, viaje, fechaDeSalida, fechaDeLlegada, camion, chofer);
    	this.ordenes.add(ordenARegistar);
    }

	public List<Orden> getOrdenes() {
		return this.ordenes;
	}
	
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
	
	public void recibirOrdenDeImportación(Orden ordenDeImportacion) {
		if (ordenDeImportacion.terminalDestino() == this) {
			//eliminar carga de buque.
			this.agregarCarga_ACargasPorRetirar(ordenDeImportacion.getContainer());
			this.notificarAlCliente_RetiroDeCarga(ordenDeImportacion.getConsignee());
		}
	}
	
	public void notificarAlCliente_RetiroDeCarga(Consignee consignee) {
		this.enviarMailNotificandoA_(consignee);
	}
	
	public void agregarCarga_ACargasPorRetirar(Container carga) {
		this.getCargasPorRetirar().add(carga);
	}
	
	public List<Container> getCargasPorRetirar() {
		return this.cargasPorRetirar;
	}
	
	public void enviarMailNotificandoA_(Consignee consignee) {
		return;
	}
	
	public realizarRetiroDeCargaDeOrden_(Orden orden) {
		if (elCoferYCamionSonPermitidos() && not pasaron24HorasDesdeQueLlegoLaCarga) {
			this.getCargasPorRetirar().remove(posicionDeCarga(orden.getContainer()));
		}
	}
	
}