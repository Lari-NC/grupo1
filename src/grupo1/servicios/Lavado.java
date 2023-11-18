package grupo1.servicios;

public class Lavado extends Servicio{
	private int precioMax;
	/*CREO que es una interfaz mejor dsps lo veo
	 * 
	 * 
	 * Consiste en el lavado de un container (exterior, no mercadería interna).
	 * Se establece un precio fijo según capacidad del container, un monto si
	 * el mismo supera 70 metros cúbicos y otro monto si está por debajo de ese volumen.
	*/
    public Lavado(int precio) {
        super(precio);
    }
    
    public int getPrecio() {
    	return super.getPrecio();
    }
}
