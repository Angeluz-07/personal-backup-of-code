/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structures.task3;
/**
 *
 * @author User
 */
public class Circulo extends Figura{
    private double radio;
    public Circulo(){
        super();
    }
    public Circulo(double radio){
        super();
        this.radio=radio;    
    }
    public double getRadio(){
        return this.radio;
    }
    @Override
    public double getArea(){
        double area=3.14*Math.pow(this.radio,2);
        return area;
    }
    @Override
    public double getPerimetro(){
        double perimetro=2*3.14*this.radio;
        return perimetro;
    }
    
    
    
}
