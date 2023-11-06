public class Cliente {

    private String nombre;
    private int dni;
    private String domicilio;
    private int telefono;
    private String mail;

    public Cliente(String nombre, int dni, String domicilio, int telefono, String mail) {
        this.nombre = nombre;
        this.dni = dni;
        this.domicilio = domicilio; 
        this.telefono = telefono;
        this.mail = mail;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getDni() {
        return this.dni;
    }

    public String getDomicilio() {
        return this.domicilio;
    }

    public int getTelefono() {
        return this.telefono;
    }

    public String getMail() {
        return this.mail;
    }
}
