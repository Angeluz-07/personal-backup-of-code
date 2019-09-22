package structures.task5;




import java.util.LinkedList;


public class Pais {
    private String nombre;
    private int poblacion;
    private double area;
    private String fundacion;
    LinkedList<Ciudad> ciudades;
    public Pais(){
        this.poblacion = 0;
        this.area = 0;
        this.fundacion = null;
        this.ciudades = null;
    }
    public Pais(String nombre,int poblacion,double area,String fundacion,LinkedList ciudades){
            this.nombre=nombre;
            this.poblacion=poblacion;
            this.area=area;
            this.fundacion=fundacion;
            this.ciudades=ciudades;
    }
    
   
    public int getPoblacion() {
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
