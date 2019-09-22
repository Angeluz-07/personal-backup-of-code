package proyectouno;

/**
 * Proyecto Uno - Segundo Parcial Estructuras de Datos
 *
 * @author Miguel Murillo, Roberto Mena
 */
public class Aeropuerto {

    private int ID;
    private String nombre;
    private String nombreCiudad;
    private String nombrePais;
    private String CodigoIATAFAA;
    private String CodigoICAO;
    private String latitud;
    private String longitud;
    private String altitud;
    private String zonaHorario;
    private String DTS;
    private String zona;

    public Aeropuerto(int ID, String nombre, String nombreCiudad, String nombrePais, String CodigoIATAFAA, String CodigoICAO, String latitud, String longitud, String altitud, String zonaHorario, String DTS, String zona) {
        this.ID = ID;
        this.nombre = nombre;
        this.nombreCiudad = nombreCiudad;
        this.nombrePais = nombrePais;
        this.CodigoIATAFAA = CodigoIATAFAA;
        this.CodigoICAO = CodigoICAO;
        this.latitud = latitud;
        this.longitud = longitud;
        this.altitud = altitud;
        this.zonaHorario = zonaHorario;
        this.DTS = DTS;
        this.zona = zona;
    }

    public int getID() {
        return ID;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public String getCodigoIATAFAA() {
        return CodigoIATAFAA;
    }

    public String getCodigoICAO() {
        return CodigoICAO;
    }

    public String getLatitud() {
        return latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public String getAltitud() {
        return altitud;
    }

    public String getZonaHorario() {
        return zonaHorario;
    }

    public String getDTS() {
        return DTS;
    }

    public String getZona() {
        return zona;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public void setCodigoIATAFAA(String CodigoIATAFAA) {
        this.CodigoIATAFAA = CodigoIATAFAA;
    }

    public void setCodigoICAO(String CodigoICAO) {
        this.CodigoICAO = CodigoICAO;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public void setAltitud(String altitud) {
        this.altitud = altitud;
    }

    public void setZonaHorario(String zonaHorario) {
        this.zonaHorario = zonaHorario;
    }

    public void setDTS(String DTS) {
        this.DTS = DTS;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

}
