/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unidad_7_Tuttoring;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author User
 */
public class DeserializingObjects {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String pathDir="C:\\Users\\User\\Documents\\NetBeansProjects\\OOP_Tuttoring\\src\\Unidad_7_Tuttoring\\";        
        String myfile="objSerialized.ser";
        String finalPath=pathDir+myfile;
        
        ObjectInputStream input;
        try{
            input=new ObjectInputStream(
                    Files.newInputStream(Paths.get(finalPath)));
            System.out.printf("%-10s%-12s%-12s%n", 
                               "Name", "Age", "Country");
            
            // loop until there is an EOFException
            while(true){
                Person p=(Person)input.readObject();                
                System.out.printf("%-10s%-12d%-12s%n", 
                               p.getName(),p.getAge(),p.getCountry());             
            }                
        }catch (EOFException endOfFileException){
            System.out.printf("No more records%n");
        }catch (ClassNotFoundException classNotFoundException){
            System.err.println("Invalid object type. Terminating.");
        }catch (IOException ioException){
            System.err.println("Error reading from file. Terminating.");
        }
    }
    
}
