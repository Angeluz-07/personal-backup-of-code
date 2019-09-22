/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unidad_2_Soluciones;

import java.lang.reflect.Array;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Unit2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        //in "array" each the rows represent article, noun, verb, preposition
        String[][] array2={
                        {"the","a","one","some","any"}, 
                        {"boy","girl","dog","cat","town"},
                        {"drove","jumped","ran","walked","skipped"},
                        {"to","from","under","over","on"}
                       };
        String[][] array={
                        {"el","un","cierto","ningun"}, 
                        {"musico","mago","pintor","poeta"},
                        {"recordo","admiro","reconocio","imagino"},
                        {"tus ojos","tu forma de ser","tu rostro","tus mentiras"}
                       };
        String s="";
        int randInd;
        for(int i=0;i<array.length;i++){
            randInd=(int)(Math.random()*4);
            s+=array[i][randInd]+" ";
        }
        System.out.println(s);       
    }
    
       
        /*
        //bar chart
        int[] array = { 0, 0, 0, 2, 5, 10, 20, 23, 2, 1, 0  };
        System.out.println("Grade distribution:");
        // for each array element, output a bar of the chart
        for (int i = 0; i < array.length; i++) {
            // output bar label ("00-09: ", ..., "90-99: ", "100: ")
            if (i== 10) System.out.printf("%5d: ", 100);
            else System.out.printf("%02d-%02d: ",i * 10, i * 10 + 9);
            
            for (int stars = 0; stars < array[i]; stars++)
                System.out.print("*");
            System.out.println();
            }
        }
        */
        
        /* Circle
        int n = 20;

        for (int i = -n; i <= n; i++) {
            for (int j = -n; j <= n; j++) {
                if (i*i + j*j <= n*n) System.out.print("* ");
                else                  System.out.print("_ ");
            }
            System.out.println();
        }
        }*/
        
        // TODO code application logic here
        
}

    

