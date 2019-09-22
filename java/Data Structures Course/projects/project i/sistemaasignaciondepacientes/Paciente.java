package sistemaasignacionpacientes;

/**
 *
 * @author Miguel Murillo, Alejandro Mena
 */
public class Paciente extends Persona implements Comparable<Paciente>{

    private String alergias;
    private String dolencias;
    private int habitacion_asignada;
    private String cedula_medico_encargado;
    private int estado_emergencia; //Urgente = 3, Medio = 2, Baja = 1

    public Paciente(String cedula, String nombre, String sexo, String grupo_sanguineo,String alergias, String dolencias,int estado_emergencia) {
        super(cedula, nombre, sexo, grupo_sanguineo);
        this.alergias = alergias;
        this.dolencias = dolencias;
        this.estado_emergencia = estado_emergencia;
    }

    public String getAlergias() {
        return alergias;
    }

    public String getDolencias() {
        return dolencias;
    }

    public int getHabitacion_asignada() {
        return habitacion_asignada;
    }

    public String getCedula_medico_encargado() {
        return cedula_medico_encargado;
    }

    public int getEstado_emergencia() {
        return estado_emergencia;
    }

    
    
    public void setCedula_medico_encargado(String cedula_medico_encargado) {
        this.cedula_medico_encargado = cedula_medico_encargado;
    }

    public void setHabitacion_asignada(int habitacion_asignada) {
        this.habitacion_asignada = habitacion_asignada;
    }
    
    public static int estadoEmergenciaStringToInt(String s){
        if(s.equals("urgente")){
            return 3;
        }
        if(s.equals("medio")){
            return 2;
        }
        if(s.equals("baja")){
            return 1;
        }
        return 0;
    }

    @Override
    public int compareTo(Paciente o) {
        if(o.getEstado_emergencia()>this.getEstado_emergencia()){
            return 1;
        }
        if(o.getEstado_emergencia()<this.getEstado_emergencia()){
            return -1;
        }
        return 0;
    }
    
    
}
