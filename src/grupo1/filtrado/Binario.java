package grupo1.filtrado;


public abstract class Binario extends Busqueda {
	 private Busqueda filtro1;
	 private Busqueda filtro2;
	 
	   public Binario(Busqueda filtro1, Busqueda filtro2) {
	        this.filtro1 = filtro1;
	        this.filtro2 = filtro2;
	    }

	public Busqueda getFiltro1() {
		return filtro1;
	}

	public Busqueda getFiltro2() {
		return filtro2;
	}
}
