package sistemaasignacionpacientes;

/**
 *
 * @author Miguel Murillo, Alejandro Mena
 */
public class Dolencia {

    private String nombre;
    private String sintomas;

    public Dolencia(String nombre, String sintomas) {
        this.nombre = nombre;
        this.sintomas = sintomas;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

}
