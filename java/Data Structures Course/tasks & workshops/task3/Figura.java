/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structures.task3;
import java.util.Random;
/**
 *
 * @author User
 */
public abstract class Figura {
    private final Coordenada posicion;
    public Figura(){
        Random rand=new Random();
        double x=rand.nextDouble()*100;
        double y=rand.nextDouble()*100;
        this.posicion=new Coordenada(x,y);
    }
    public void getPosicion(){
        System.out.printf("( %.2f ; %.2f) %n",this.posicion.getX(),this.posicion.getY());
    }
    
    public boolean equals(Figura o){
        if (o==null){
            return false;
        }
        if (this.getArea()==o.getArea()){
            return true;
        }else{
            return false;
        } 
    }
    
    public abstract double getArea();
    public abstract double getPerimetro();
}
