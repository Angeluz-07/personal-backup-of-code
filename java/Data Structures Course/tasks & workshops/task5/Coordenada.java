package structures.task5;


public class Coordenada implements Comparable<Coordenada> {
    private double latitud;
    private double longitud;
   
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
    
    @Override
    public int compareTo(Coordenada c){
        Coordenada zero= new Coordenada(0,0);
        if (this.calcularDistancia(zero)>c.calcularDistancia(zero)){
            return 1;
        }if (this.calcularDistancia(zero)<c.calcularDistancia(zero)){
            return -1;
        }
        return 0;
        
    }
    
    //Metodo para calcular dinstancia (recibe un parametro llamado parametroCoordenada que es del tipo Coordenada)
    public double calcularDistancia(Coordenada parametroCoordenada) {
        return Math.sqrt(Math.pow(this.latitud - parametroCoordenada.getLatitud(), 2) + Math.pow(this.longitud - parametroCoordenada.getLongitud(), 2)); 
    }
}
