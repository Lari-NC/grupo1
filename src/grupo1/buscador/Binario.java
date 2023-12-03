package grupo1.buscador;

public abstract class Binario extends Busqueda {
	 private Busqueda busqueda1;
	 private Busqueda busqueda2;
	 
	   public Binario(Busqueda busqueda1, Busqueda busqueda2) {
	        this.busqueda1 = busqueda1;
	        this.busqueda2 = busqueda2;
	    }

	public Busqueda getBusqueda1() {
		return busqueda1;
	}

	public Busqueda getBusqueda2() {
		return busqueda2;
	}
}