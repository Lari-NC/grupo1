package grupo1;
import java.util.*;

import grupo1.circuito.Circuito;
import grupo1.cliente.Consignee;
import grupo1.cliente.Shipper;
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
}