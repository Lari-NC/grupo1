package grupo1;
import java.util.*;

public class TerminalGestionada extends Terminal{
	
	
    private List<Naviera> navieras = new ArrayList<>();
    private List<Shipper> shippers = new ArrayList<>();
    private List<Consignee> consignees = new ArrayList<>();
    private List<EmpresaTranportista> empresas = new ArrayList<>();
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
    
  
    public void registrarEmpresaTranportista(EmpresaTranportista empresa) {
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