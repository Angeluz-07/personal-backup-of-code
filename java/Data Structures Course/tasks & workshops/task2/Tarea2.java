/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structures.task2;

/**
 *
 * @author User
 */

import java.util.Scanner;
public class Tarea2 {
    
    public static void main (String[] args){
        
        Usuario u1,u2,u3,u4,u5;
        u1=new Usuario("Ricardo","vaka");
        u2=new Usuario("Mario","nuevacalle");
        u3=new Usuario("Fernanda","listo221");
        u4=new Usuario("Patricia","angel12");
        u5=new Usuario("Steven","casanegra");
        
        String nombres[]={u1.getNombre(),u2.getNombre(),u3.getNombre(),u4.getNombre(),u5.getNombre()};
        String claves[]={u1.getClave(),u2.getClave(),u3.getClave(),u4.getClave(),u5.getClave()};
       
       boolean seEquivoco=true;
       for(int k=0;k<3;k++){
            System.out.print("A continuacion ingrese su nombre de usuario: ");
            Scanner input=new Scanner(System.in);
            String nombreIngresado=input.nextLine();
            System.out.print("Ingrese su clave: ");
            String claveIngresada=input.nextLine();
            
            for(int i=0;i<nombres.length;i++){
                if (nombreIngresado.equals(nombres[i])){
                    if(claveIngresada.equals(claves[i])){
                        seEquivoco=false;
                    }   
                }
            }
            if(seEquivoco){
                if (k!=2){
                System.out.println("Intentelo de nuevo...");
                }
            }
            else{
                break;
            }
            }
        
        
        if(seEquivoco){
            System.out.println("Error, ya no puede acceder al sistema");
        }
        else{
            System.out.println("Fin del programa");
        }  
    }
    
}
