/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unidad_7_Tuttoring;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class ReadingFiles {
   
    public static void main(String[] args) throws InterruptedException {
        Scanner input;

        String pathDir="C:\\Users\\User\\Documents\\NetBeansProjects\\OOP_Tuttoring\\src\\Unidad_7_Tuttoring\\";                
        String horseASCII="horseASCII.txt";
        String dragonASCII="dragonASCII.txt";
        String myFile="myFile.txt";
        String russianExpressions="russianExpressions.txt";
        String aa="values.csv";
        String finalPath=pathDir+aa;
        
        Formatter output;
        String outputPath="C:\\Users\\User\\Documents\\NetBeansProjects\\OOP_Tuttoring\\src\\Unidad_7_Tuttoring\\valuesO.txt";
        
        String[] sTemp;
        try{
            //input=new Scanner(new File(finalPath));
            
            input=new Scanner(Paths.get(finalPath));
            
            output=new Formatter(outputPath); 
            
            //System.out.printf("%-20s%-20s%-20s%n","English","Literal T","Phonetical T");          
                
            while(input.hasNext()){                                                                                  
                /* 
                   input.nextLine() get each entire line
                   input.next() get each value separated 
                   by white-space. If values are divides 
                   by character different from whitespace
                   input.next() and input.nextLine() get
                   the same. In that case to get especific
                   substrings, split will be necesary.                   
                */
                
                //should use nextLine()                                
                //sTemp=input.nextLine().split(",");
                /*
                System.out.printf("%-20s%-20s%-20s%n",
                                  sTemp[0],
                                  sTemp[1],
                                  sTemp[2]);
                */                                
                //leer linea por linea                
                String line=input.nextLine();                
                line=line.replaceAll("\\.", ",");
                output.format(line +"\n");
                System.out.println(line);                
                
                //Thread.sleep(1000);                             
            }            
            output.close();
            input.close();
            
            /*
                IOException for Path.
                FileNotFoundException,InterruptedExceptio for File
            */
        }catch(Exception e){
            System.out.println(e);              
        }                       
    }
    
}
