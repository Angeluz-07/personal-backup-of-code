/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unidad_2_Soluciones;

import java.util.Arrays;

/**
 *
 * @author User
 */
public class Unidad2_Taller1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       //int a=3,b=11;
       //System.out.println((b%a)+1);
       /*
       int a=3;
       int b=a++;
       int result=1;
       result+=a-b;
        System.out.println(result);
        System.out.println("");
       */
       /*
       String s="jjj";
       String t="xxx";
        System.out.println(s+s+t);
       */
       //for(int i=100;i>=1;i++) System.out.println(i);           
       /*
       int[] a={10,12,10,11,12};
       for(int i=0;i<a.length;i++){
           if(!estaDuplicado(a,i,a[i])){
               System.out.println(a[i]);
           }
       }
       */
       /*
       for(int i=0;i<10;i++){
           for(int j=0;j<5;j++)
               System.out.print("@");
           System.out.println("");
           
       }
         */  
       int[] c= {1};    
       String a="aaa.bbb.ccc";
       String[] l=a.split("\\.");
       System.out.println(Arrays.toString(l));
               
       }
    
    public static boolean estaDuplicado(int[] a,int i,int n){
            for(int k=0;k<a.length;k++){
                if(k!=i && a[k]==n){
                   return true;
                }
            }
        return false;
    }
}
