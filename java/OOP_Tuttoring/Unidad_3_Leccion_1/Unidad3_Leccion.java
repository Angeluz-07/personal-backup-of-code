/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unidad_3_Leccion_1;


/**
 *
 * @author User
 */
public class Unidad3_Leccion {
    //DEFAULT
    /*        
    i)  NO misma declaracion  
    int calcular(int a,int b, float c) {return 1;}   
    int calcular(int var1, int var2, float var3) {return 2;}
    */
   
    /*
    ii) No, solo cambia tipo de retorno
    int calcular(int a,int b) { return 1;}   
    float calcular(int var1, int var2){ return 2;} 
    */
    
    /*
    iii)si
    float calcular(int a,float b) { return 1;}   
    float calcular(float var1, int var2){ return 2;}     
    */
    
    /*
    iv)si
    int calcular(int a,int b) { return 1;}   
    int calcular(float var1, float var2){ return 2;}     
    */
    
    /*
    v)si
    int calcular(int a,int b) { return 1;}   
    int calcular(int num){ return 2;}     
    */
    private int state =0;
    //private String n;
    Unidad3_Leccion(int s){
        //n=name;
        state=s;
    }
    public static void main(String... hi){
        Unidad3_Leccion b1=new Unidad3_Leccion(1);
        Unidad3_Leccion b2=new Unidad3_Leccion(2);
        System.out.println(b1.go(b1)+" "+b2.go(b2));        
    }
    int go(Unidad3_Leccion b){
        
       if(state==2) {
           state=5;
           go(b);
       }           
       return ++state;
    }
}
