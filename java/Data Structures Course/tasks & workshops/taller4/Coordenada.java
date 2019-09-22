
public class Coordenada {
    private double latitud;
    private double longitud;
    public static int contador= 0;
   
    public Coordenada(){
	this.latitud  = -12.0;
	this.longitud =  12.0;
	}
  
    public Coordenada(double latitud, double longitud){
	this.latitud  = latitud;
	this.longitud = longitud;
    }
    
    public double getLatitud() {
        return this.latitud;
    }
    public double getLongitud() {
        return this.longitud;
    }
    public void setLatitud(double latitud) {
        this.latitud= latitud;
    }
    public void setLongitud(double longitud) {
        this.longitud= longitud;
    }

    
    public String toString() {
	return "(" +this.latitud+ "," + this.longitud+")";
    }
    //Overriding de metodo equals
    public boolean equals(Object obj){
        if (obj instanceof Coordenada){
             Coordenada coordenada = (Coordenada) obj;
           return this.latitud == coordenada.latitud && this.longitud == coordenada.longitud;
        }
        return false;
    }
    
    public void str2Coordenada (String linea){
        this.setLatitud(Double.parseDouble(linea.substring(1,linea.indexOf(','))));
        this.setLongitud(Double.parseDouble(linea.substring(linea.indexOf(',')+1,linea.length()-1)));
    }
}
