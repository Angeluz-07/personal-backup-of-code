package sistemaasignacionpacientes;

/**
 *
 * @author Miguel Murillo, Alejandro Mena
 */
public class Habitacion {

    private int numero;
    private int num_camas;
    private String cedula_medico_encargado;

    public Habitacion(int num, int n_c, String ced) {
        numero = num;
        num_camas = n_c;
        cedula_medico_encargado = ced;
    }

    public int getNumero() {
        return numero;
    }

    public int getNum_camas() {
        return num_camas;
    }

    public String getCedula_medico_encargado() {
        return cedula_medico_encargado;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setNum_camas(int num_camas) {
        this.num_camas = num_camas;
    }

    public void setCedula_medico_encargado(String cedula_medico_encargado) {
        this.cedula_medico_encargado = cedula_medico_encargado;
    }

}
