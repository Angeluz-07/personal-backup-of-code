/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unidad_7_Tuttoring;

import java.io.FileInputStream;

/**
 *
 * @author User
 */
public class ReadingFiles2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String pathDir="C:\\Users\\User\\Documents\\NetBeansProjects\\OOP_Tuttoring\\src\\Unidad_7_Tuttoring\\";                
        String horseASCII="horseASCII.txt";
        String dragonASCII="dragonASCII.txt";
        String finalPath=pathDir+dragonASCII;
        
        int b;
        
        FileInputStream input=null;
        try{
            input=new FileInputStream(finalPath);                        
            /*
            // read bytes until EOF is encountered
            do {
                b = input.read();
                if(b != -1) 
                    System.out.print((char) b);
            } while(b != -1);//when -1 EOF reached
            */            
            while((b=input.read())!=-1){               
                System.out.print((char)b);
            }
        }catch(Exception e){
            System.out.println(e);
        }finally{
            try{
                input.close();
            }catch (Exception e){
                System.out.println("Error on closing");
            }
        }
    }
    
}
