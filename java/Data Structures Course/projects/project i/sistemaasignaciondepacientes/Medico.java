package sistemaasignacionpacientes;

/**
 *
 * @author Miguel Murillo, Alejandro Mena
 */
public class Medico extends Persona{
    
    private String especialidad;

    public Medico(String cedula, String nombre, int telefono, String especialidad) {
        super(cedula,nombre,telefono);
        this.especialidad = especialidad;
    }
   
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    
    
}
