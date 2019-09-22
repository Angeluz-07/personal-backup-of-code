package sistemaasignacionpacientes;

/**
 *
 * @author Miguel Murillo, Alejandro Mena
 */
public class Persona {

    private String cedula;
    private String nombre;
    private String sexo;
    private String grupo_sanguineo;
    private int telefono;

    public Persona(String cedula, String nombre, int telefono) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public Persona(String cedula, String nombre, String sexo, String grupo_sanguineo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.sexo = sexo;
        this.grupo_sanguineo = grupo_sanguineo;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public String getGrupo_sanguineo() {
        return grupo_sanguineo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setGrupo_sanguineo(String grupo_sanguineo) {
        this.grupo_sanguineo = grupo_sanguineo;
    }

}
