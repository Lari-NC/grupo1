package grupo1.filtrado;


public abstract class Binario extends Buscador {
	 private Buscador filtro1;
	 private Buscador filtro2;
	 
	   public Binario(Buscador filtro1, Buscador filtro2) {
	        this.filtro1 = filtro1;
	        this.filtro2 = filtro2;
	    }

	public Buscador getFiltro1() {
		return filtro1;
	}

	public Buscador getFiltro2() {
		return filtro2;
	}
}
