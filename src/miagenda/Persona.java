package miagenda;

/**
 *
 * @author Angel
 */
public class Persona {
    
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private String telefono;
    private String corre;

    public Persona() {
    }

    public Persona(String nombre, String apPaterno, String apMaterno, String telefono, String corre) {
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.telefono = telefono;
        this.corre = corre;
    }

    public String getCorre() {
        return corre;
    }

    public void setCorre(String corre) {
        this.corre = corre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return nombre + "%" +apPaterno + "%" + apMaterno + "%" + telefono + "%" + corre;
    }
    public void mostrar() {
        System.out.println("Nombre: "+nombre+" "+apPaterno+" "+apMaterno);
        System.out.println("Telefono:"+telefono);
        System.out.println("Correo:"+corre);
    }
    
    
}
