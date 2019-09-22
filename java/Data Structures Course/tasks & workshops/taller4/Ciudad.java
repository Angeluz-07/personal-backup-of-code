

import java.util.LinkedList;

public class Ciudad {
    private String nombre;
    private int poblacion;
    private double area;
    private String fundacion;
    LinkedList<Coordenada> puntosR;
    public Ciudad(){
        this.poblacion = 0;
        this.area = 0;
        this.fundacion = null;
        this.puntosR = null;
    }
    public Ciudad(String nombre,int poblacion,double area,String fundacion,LinkedList puntosR){
            this.nombre=nombre;
            this.poblacion=poblacion;
            this.area=area;
            this.fundacion=fundacion;
            this.puntosR=puntosR;
    }
    
    public int getPoblacion(){
        return this.poblacion;
    }
    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }

    public double getArea() {
        return this.area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getFundacion() {
        return this.fundacion;
    }

    public void setFundacion(String fundacion) {
        this.fundacion = fundacion;
    }
    
   public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
