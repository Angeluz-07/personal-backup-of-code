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
public class Sport {
    Sport play(){
        System.out.print("play ");
        return new Sport();             
    }
    Sport play(int x){
        System.out.print("play x");
        return new Sport();             
    }
    
}
