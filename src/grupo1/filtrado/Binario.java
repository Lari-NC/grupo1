package grupo1.filtrado;


public abstract class Binario extends Filtrador {
	 private Filtrador filtro1;
	 private Filtrador filtro2;
	 
	   public Binario(Filtrador filtro1, Filtrador filtro2) {
	        this.filtro1 = filtro1;
	        this.filtro2 = filtro2;
	    }

	public Filtrador getFiltro1() {
		return filtro1;
	}

	public Filtrador getFiltro2() {
		return filtro2;
	}
}
