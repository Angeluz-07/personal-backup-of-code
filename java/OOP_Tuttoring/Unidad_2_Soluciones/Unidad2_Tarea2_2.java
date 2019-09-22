/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unidad_2_Soluciones;


import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Unidad2_Tarea2_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] ordinalNumbers={"First","Second","Third",
                                 "Fourth","Fifth","Sixth",
                                 "Seventh","Eighth","Ninth",
                                 "Tenth","Eleventh","Twelfth"};
        String[] sentences={"Twelve drummers drumming",
                            "Eleven pipers piping",
                            "Ten lords a-leaping",
                            "Nine ladies dancing",
                            "Eight maids a-milking",
                            "Seven swans a-swimming",
                            "Six geese a-layin",
                            "Five golden rings",
                            "Four calling birds", 
                            "Three french hens",
                            "Two turtle doves",
                            "a partridge in a pear tree"};
        String s="";
        int l=sentences.length;
        for(int i=0; i<ordinalNumbers.length; i++){
            System.out.printf("On the %s day of Christmas my true love sent to me \n",ordinalNumbers[i]);            
            if(i==1){
                s=sentences[l-(i+1)]+"\n"+"And "+s;
            }else{
                s=sentences[l-(i+1)]+"\n"+s;            
            }            
            System.out.println(s);
        }
            
        
    }
}

