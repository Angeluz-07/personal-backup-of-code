/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unidad_4_Taller;

/**
 *
 * @author User
 */
public class Baseball extends Sport {
    Baseball play(){
        System.out.print("baseball ");
        return new Baseball();             
    }
    Sport play(int x){
        System.out.print("sport ");
        return new Sport();             
    }
   
    public static void main(String[] args) {
        new Baseball().play();
        new Baseball().play(7);
        //super.play();
        new Sport().play();
        Sport s=new Baseball();
        s.play();
        // TODO code application logic here
    }
    
}
