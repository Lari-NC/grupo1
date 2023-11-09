
package grupo1;

public class TerminalGestionada extends Terminal{
    
    private Array<Naviera> navieras = new Array<Naviera>();
    private Array<Shipper> shippers = new Array<Shipper>();
    private Array<Consignee> consignees = new Array<Consignee>();
    //private Array<EmpresaTranportista> empresas = new Array<EmpresaTranportista>();
    private Array<Camion> camionesPermitidos = new Array<Camion>();
    private Array<Chofer> choferesPermitidos = new Array<Chofer>();
    private Array<Circuitos> circuitosDeInteres = new Array<Circuitos>();

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
    /* 
    public void registrarEmpresaTranportista(EmpresaTranportista empresa) {
        this.empresas.add(empresa);
    }
    */

    public void registrarCamion(Camion camion) {
        this.camiones.add(camion);
    }

    public void registrarChofer(Chofer chofer) {
        this.choferes.add(chofer);
    }

    public void registarCircuitosDeInteres() {
        for(Naviera naviera : this.navieras){
            this.circuitosDeInteres.add(naviera.circuitosQuePasanPor(this));
        }
    }