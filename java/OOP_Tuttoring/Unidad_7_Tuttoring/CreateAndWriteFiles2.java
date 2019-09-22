    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unidad_7_Tuttoring;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Formatter;

/**
 *
 * @author User
 */
public class CreateAndWriteFiles2 {
    
    public static void main(String[] args) {
        
        Formatter output;
        
        String pathDir="C:\\Users\\User\\Documents\\NetBeansProjects\\OOP_Tuttoring\\src\\Unidad_7_Tuttoring\\";        
        String myfile="myFile.txt";
        String finalPath=pathDir+myfile;
        
        /*
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        System.out.println("Current relative path is: " + s);
        */
        
        try{
            output=new Formatter(finalPath);                      
            /* 
                %n is portable across platforms, works for
                .format() and .printf(). however doesn't work 
                in .print() or .println() use \n in those cases.
            */
            
            //write in the file            
            output.format("%s %s %s%n","Name","LastName","Age");
            output.format("%s %s %s%n","Captain","America","21");            
            output.format("%s %s %s%n","Lorena","Rodriguez","21");
            
            String name="Ricardo",lastName="Medina",age="23";
            
            //could use variables, like .printf()
            output.format("%s %s %s %n",name,lastName,age);
            
            for(int i=1; i<=10;i++){
                output.format("%d %n", i);
            }
            //don't forget close the file
            output.close();
        }catch(FileNotFoundException e){
            System.out.println("Couldn't create the file");
        }
        
    }
    
}
