/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unidad_7_Tuttoring;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author User
 */
public class SerializingObjects {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String pathDir="C:\\Users\\User\\Documents\\NetBeansProjects\\OOP_Tuttoring\\src\\Unidad_7_Tuttoring\\";        
        String myfile="objSerialized.ser";
        String finalPath=pathDir+myfile;
        
        //outputs data to a file
        ObjectOutputStream output;
        
        Person p1=new Person("Ricardo",22,"Brazil");
        Person p2=new Person("Natasha",21,"Russia");
        Person p3=new Person("Alberto",24,"Mexico");
        Person p4=new Person("Juan",22,"Ecuador");
        
        try{
           
            output=new ObjectOutputStream(
                    Files.newOutputStream(Paths.get(finalPath)));
            
            output.writeObject(p1);
            output.writeObject(p2);
            output.writeObject(p3);
            output.writeObject(p4);
            
            output.close();
        }catch(IOException e){
            System.out.println(e);
        }
        
    }
    
}
