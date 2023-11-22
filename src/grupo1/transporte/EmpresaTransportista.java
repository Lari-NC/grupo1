package grupo1.transporte;

import java.util.ArrayList;
import java.util.List;

public class EmpresaTransportista {
	private List<Chofer> choferesRegistrados = new ArrayList<>();
	private List<Camion> camionesRegistrados = new ArrayList<>();
	
	
	public void addChofer(Chofer chofer) {
		this.choferesRegistrados.add(chofer);
	}
	
	public void addCamion(Camion camion) {
		this.camionesRegistrados.add(camion);
	}
}
