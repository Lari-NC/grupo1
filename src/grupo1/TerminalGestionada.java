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
    private List<Servicio> serviciosAOfrecer	= new ArrayList<>();
    
   public TerminalGestionada(Posicion p) { super(p); }

   
    // IMPORTACIÓN:
	public void agregarOrdenImportacion(Orden orden) {
		this.ordenesImpo.add(orden);
	}
	
	public void notificarAlClienteRetiroDeCarga(Consignee consignee) {
		consignee.recibirMailParaRetiro();
	}
	
	public void realizarRetiroDeCargaDeOrden(Orden orden, Camion camion) throws IllegalArgumentException {
		//entra el camion, si tardo mas de 24 hs se le agrega un servicio de almacenamiento por dia que tardo, se elimina la orden de nuestras ordenes de importacion
		LocalDate fechaRetiro = LocalDate.now();

        this.entraUnCamionALaTerminal(camion);
        this.asegurarseQueElCamionRetireLaOrdenCorrecta(camion, orden);
        if(fechaRetiro.isAfter(orden.getFechaDeLlegada())) {
        	this.agregarServicioAlmacenamientoA(orden);
        }
        
        this.realizarEntregaCarga(orden);	
	}

	private void realizarEntregaCarga(Orden orden) {
		this.getOrdenesImportacion().remove(orden);
	}
	
    
    private void agregarServicioAlmacenamientoA(Orden orden) {
	//no
		for(Servicio servicio : this.getServiciosAOfrecer()) {
			if(servicio.getTipoServicio() == "Almacenamiento") {
				orden.agregarServicioAlmacenamiento(servicio)//;
			}
		}
	}

    
	public void recibirBuqueAvisoInbound(Buque buque) {
		// dar aviso a todas nuestras ordenes de importación que tienen al buque que dio el aviso
		for(Orden o : this.ordenesImpo) {
			if(o.getViaje().getBuque() == buque) {
				this.notificarAlClienteRetiroDeCarga(o.getConsignee());
			}
		}
	}
	
	public void recibirBuqueAvisoOutbound(Buque buque) {
		// dar aviso a todas nuestras ordenes de importación que tienen al buque que dio el aviso
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
    
    
    //SEGURIDAD
	private void entraUnCamionALaTerminal(Camion camion) {
		//chequea si el camion y el chofer estan registrados en la terminal
        this.chequearSiElCamionEstaRegistrado(camion);
        this.chequearSiElChoferEstaRegistrado(camion.getChofer());
    }
    private void asegurarseQueElCamionRetireLaOrdenCorrecta(Camion camion, Orden orden) {
    	//chequea si el camion y el chofer son los declarados en al orden
    	chequearSiElCamionEstaDeclaradoEnLaOrden(camion, orden);
    	chequearSiElChoferEstaDeclaradoEnLaOrden(camion.getChofer(), orden);
    	
	}
    
    //MANEJO BUQUES
    public void darOrdenWorking(Buque buque) {
    	buque.recibirOrdenWorking();
    }
    
    public void darOrdenDepart(Buque buque) {
    	buque.recibirOrdenDepart();
    }
	
    
    //EXPORTACIÓN:
    public void registrarExportacion (Shipper emisor, Consignee receptor, Container container, Viaje viaje, LocalDate fechaDeSalida, LocalDate fechaDeLlegada, Camion camion, Chofer chofer,List<Servicio> servicios) {
    	Orden ordenARegistar = new Orden(emisor, receptor, container, viaje, fechaDeSalida, fechaDeLlegada, camion, chofer, servicios);
    	this.ordenesExpo.add(ordenARegistar);
    }
    
	public void recibirBuqueAvisoDepart(Buque buque) {
		// dar aviso a todas nuestras ordenes de importación que tienen al buque que dio la orden
		for(Orden o : this.ordenesExpo) {
			if(o.getViaje().getBuque() == buque) {
				this.notificarAlClienteSalidaDeCarga(o.getShipper());
			}
		}
	}
    
    private void notificarAlClienteSalidaDeCarga(Shipper shipper) {
    	shipper.recibirMailCargaEnviada();
	}
    
    
    
    //Otras cositas :)
    public int cantidadDeTiempoQueTardaLaNaviera_EnLlegarA_(Naviera naviera, Terminal terminalDestino) {
		//4. Devuelve cuanto tarda una naviera en llegar desde la terminal gestionada hacia otra terminal, independientemente de las fechas de los viajes programados.
		return naviera.tiempoDeViajeDesdeHastaTerminal(this, terminalDestino);
	}
    
    
				// FALTAN:
			    public Circuito mejorCircuitoHasta_(Terminal terminalDestino) {
					//3.Devolver el mejor circuito que une a la terminal con un determinado puerto destino.
					// mejor circuito en base a que??? NAVIERA STRATEGY
					
					return ;
				}
			    
				
				
				public LocalDate proximaFechaDePartidaDelBuque_HastaTerminal_ (Buque buque, Terminal terminalDestino) {
					//5. Devolver la próxima fecha de partida de un buque desde la terminal gestionada hasta otra terminal de destino.
					
					return ;
				}

    
    // REGISTRAR(setters): 
    public void registrarNaviera(Naviera naviera) {
        this.navieras.add(naviera); }

    public void registrarShipper(Shipper shipper) {
        this.shippers.add(shipper); }

    public void registrarConsignee(Consignee consignee) {
        this.consignees.add(consignee); }
    
    public void registrarEmpresaTranportista(EmpresaTransportista empresa) {
        this.empresas.add(empresa); }

    public void registrarCamion(Camion camion) {
        this.camionesPermitidos.add(camion); }

    public void registrarChofer(Chofer chofer) {
        this.choferesPermitidos.add(chofer); }
    
    public void registrarServiciosAOfrecer(List<Servicio> servicios) {
    	this.getServiciosAOfrecer().addAll(servicios);
    }
    
    public void registrarServicioAOfrecer(Servicio servicio) {
    	this.getServiciosAOfrecer().add(servicio);
    }
    
    public void registarCircuitosDeInteres() {
        for(Naviera naviera : this.navieras) {
        	this.circuitosDeInteres.addAll(naviera.circuitosQuePasanPorTerminal(this));
        }
    }
    
    // GETTERS:
	public List<Orden> getOrdenesExportacion() {
		return this.ordenesExpo; }
	
	public List<Orden> getOrdenesImportacion() {
		return this.ordenesImpo; }
	
	public List<Chofer> getChoferesPermitidos() {
        return choferesPermitidos; }

    public List<Camion> getCamionesPermitidos() {
        return camionesPermitidos; }
	
	
	public List<Servicio> getServiciosAOfrecer() {
		return serviciosAOfrecer; }
	
	
	//ERRORES:
    private void chequearSiElCamionEstaRegistrado(Camion camion) {
    	if (!this.getCamionesPermitidos().contains(camion)) {
        	throw new IllegalArgumentException("El camion no tiene el ingreso permitido a la terminal");
        }  }

    private void chequearSiElChoferEstaRegistrado(Chofer chofer) {
    	if (!this.getChoferesPermitidos().contains(chofer)) {
        	throw new IllegalArgumentException("El chofer no tiene el ingreso permitido a la terminal");
    	} }
 
	public void chequearSiElChoferEstaDeclaradoEnLaOrden(Chofer chofer, Orden orden) {
		if (!(orden.getChofer()==chofer)) {
        	throw new IllegalArgumentException("El chofer no es el declarado en la orden");
    	} }

	public void chequearSiElCamionEstaDeclaradoEnLaOrden(Camion camion, Orden orden) {
		if (!(orden.getCamion()==camion)) {
        	throw new IllegalArgumentException("El camion no es el declarado en la orden");
    	} }
}