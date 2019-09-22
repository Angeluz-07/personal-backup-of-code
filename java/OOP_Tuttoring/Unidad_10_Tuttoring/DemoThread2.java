/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unidad_10_Tuttoring;

import static java.lang.Thread.yield;

/**
 *
 * @author User
 */
public class DemoThread2 implements Runnable{
    private String nombre;
    public DemoThread2(String nombre){
        this.nombre = nombre;
    }
    public void run(){
        try{
            int x = (int)(Math.random()*5000);
            Thread.sleep(x);
            System.out.println("I'm "+nombre+" ("+x+")");           
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public static void main(String[] args) throws Exception{
        
        Thread t1 = new Thread(new DemoThread2("Flash"));      
        Thread t2 = new Thread(new DemoThread2("QuickSilver"));       
        Thread t3 = new Thread(new DemoThread2("Carrerin"));       
        t1.start();
        t2.start();
        t3.start();
        
        t1.join();
        t2.join();
        t3.join();
        System.out.println("Ok the race finished.");
    }
}