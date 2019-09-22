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
public class Rectangulo extends Figura {
    double base;
    double altura;
    public Rectangulo(){
        super();
    }
    public Rectangulo(double base, double altura){
        super();
        this.base= base;
        this.altura= altura;
    }
    
    public double getBase(){
        return this.base;
    }
    
    public double getAltura(){
        return this.altura;
    }
    @Override
    public double getArea(){
        return this.base*this.altura;
    }
    @Override
    public double getPerimetro(){
        double perimetro=(2*this.base)+(2*this.altura);
        return perimetro;
    }
}
