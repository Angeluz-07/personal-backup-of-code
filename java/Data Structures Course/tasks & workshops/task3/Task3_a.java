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

public class Task3_a {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Coordenada c1,c2,c3;
        c1=new Coordenada();
        c2=new Coordenada(25.2,65.8);
        c3=new Coordenada(0,42.0);
        double disFromC1ToC2,disFromC1ToC3,disFromC2ToC3;
        disFromC1ToC2=Coordenada.distanceBetweenCoordinates(c1,c2);
        disFromC1ToC3=Coordenada.distanceBetweenCoordinates(c1,c3);
        disFromC2ToC3=Coordenada.distanceBetweenCoordinates(c2,c3);
        
        System.out.printf("La distancia entre c1 y c2 es: %.2f %n",disFromC1ToC2);
        System.out.printf("La distancia entre c1 y c3 es: %.2f %n",disFromC1ToC3);
        System.out.printf("La distancia entre c2 y c3 es: %.2f %n",disFromC2ToC3);
                
      
    
    }
    
}
