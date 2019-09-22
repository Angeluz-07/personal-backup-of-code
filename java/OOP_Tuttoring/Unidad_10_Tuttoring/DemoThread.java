/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unidad_10_Tuttoring;

/**
 *
 * @author User
 */
public class DemoThread extends Thread{
    private String nombre;
    public DemoThread(String nombre){
        this.nombre = nombre;
    }    
    public void run(){
        try{
            int x = (int)(Math.random()*5000);
            Thread.sleep(x);
            System.out.println("I'm " + nombre+" ("+x+")");
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public static void main(String[] args){
        DemoThread t1 = new DemoThread("Flash");
        DemoThread t2 = new DemoThread("Quick Silver");
        DemoThread t3 = new DemoThread("Carrerin");     
        t1.start();
        t2.start();
        t3.start();
    }
}
