/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structures.task3;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Task3_b {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Circulo cir1,cir2;
        Rectangulo rec1,rec2;
        
        cir1=new Circulo(3.2);
        cir2=new Circulo(5);
        
        rec1=new Rectangulo(20,5);
        rec2=new Rectangulo(10,10);
        
        System.out.print("El circulo 1 esta en la posicion ");
        cir1.getPosicion();
        System.out.printf("El circulo 1 tiene radio %.2f %n",cir1.getRadio());
        System.out.printf("El circulo 1 tiene area %.2f y perimetro %.2f %n",cir1.getArea(),cir1.getPerimetro());
        
        
        
        System.out.print("El circulo 2 esta en la posicion ");
        cir2.getPosicion();
        System.out.printf("El circulo 2 tiene radio %.2f %n",cir2.getRadio());
        System.out.printf("El circulo 2 tiene area %.2f y perimetro %.2f %n",cir2.getArea(),cir2.getPerimetro());
  
        
        
        
        System.out.print("El rectangulo 1 esta en la posicion ");
        rec1.getPosicion();
        System.out.printf("El rectangulo 1 tiene base %.2f y altura %.2f %n",rec1.getBase(),rec1.getAltura());
        System.out.printf("El rectangulo 1 tiene area %.2f y perimetro %.2f %n",rec1.getArea(),rec1.getPerimetro());
        
        
        
        
        System.out.print("El rectangulo 2 esta en la posicion ");
        rec2.getPosicion();
        System.out.printf("El rectangulo 2 tiene base %.2f y altura %.2f %n",rec2.getBase(),rec2.getAltura());
        System.out.printf("El rectangulo 2 tiene area %.2f y perimetro %.2f %n",rec2.getArea(),rec2.getPerimetro());
        
        if (cir1.equals(cir2)){
            System.out.println("El circulo 1 y 2 son iguales");
        }else{
        System.out.println("El circulo 1 y 2 no son iguales");
        
        }
        if (rec1.equals(rec2)){
            System.out.println("El rectangulo 1 y 2 son iguales");
        }else{
        System.out.println("El rectangulo 1 y 2 no son iguales");
        
        }
        
    }
    
}
