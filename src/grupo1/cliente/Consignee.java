package grupo1.cliente;

public class Consignee extends Cliente {
    
    public Consignee (String nombre, int dni, String domicilio, int telefono, String mail) {
        super(nombre, dni, domicilio, telefono, mail);
    }

	public void recibirMailParaRetiro() {
		System.out.print("Su carga esta en camino! Dentro de 5 horas ya podra retirarla en nuestra Terminal. Recuerde que excedidas las 24hs se le cobrara un servicio de almacenamiento extra.");
	}
}