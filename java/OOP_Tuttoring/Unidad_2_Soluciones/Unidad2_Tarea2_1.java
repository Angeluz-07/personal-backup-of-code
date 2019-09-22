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
public class Unidad2_Tarea2_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean[] seats = new boolean[10];
        System.out.println(Arrays.toString(seats));
        int option;
        String viajarEnOtraClase;
        Scanner input= new Scanner(System.in);
        do{
            System.out.println(Arrays.toString(seats));        
            System.out.println("Escoja donde desea viajar. Ingrese, ");
            System.out.println("1 para Primera Clase.");
            System.out.println("2 para Economico.");
            System.out.println("3 para imprimir el boarding pass.");
            System.out.print("4 para salir : ");

            option=input.nextInt(); 
            if(option==4){
                break;            
            }else if(option==3){
                for(int i=0; i<seats.length;i++){
                    System.out.printf("Asiento %d , %s \n",i+1, (i<5?"Primera Clase":"Clase Economica"));
                }
            }else if(hayAsientoDisponible(seats,option)){            
                asignarAsiento(seats,option);                
            }else{
                System.out.println("No hay asiento libre alli.");
                System.out.printf("Desea viajar en la otra clase ? (si/no):");
                
                input.nextLine();  // Consume newline left-over
                viajarEnOtraClase=input.nextLine();               
                
                if("si".equals(viajarEnOtraClase)){
                    if(hayAsientoDisponible(seats,changeOption(option))){
                        asignarAsiento(seats,changeOption(option));                  
                    }else{
                        System.out.println("Lo sentimos tampoco hay espacio aqui");
                    }                
                }else{            
                    System.out.println("Puede esperar el proximo vuelo que sera en tres horas.");
                }
            }
            System.out.println("");
        }while(true);
        
    }
    //for each function need to make sure, option should be 1 or 2
    public static boolean hayAsientoDisponible(boolean[] seats,int tipo){         
            if(tipo==1){
                for(int i=0; i<5; i++){
                    if(seats[i]==false){
                        return true;
                    }                          
                }
                return false;    
            }    
            else{
                for(int i=5; i<seats.length ; i++){
                    if(seats[i]==false) return true;       
                }
                return false;                   
            }              
    }
 
    public static void asignarAsiento(boolean[] seats ,int tipo){
            if(tipo==1){
                for(int i=0; i<5; i++) {
                    if(seats[i]==false){
                        seats[i]=true;
                        return;
                    }                                          
                }    
            }    
            else{
                for(int i=5; i<seats.length; i++){
                     if(seats[i]==false){
                        seats[i]=true;
                        return;
                    }   
                }
            }
    }
    
    public static int changeOption(int option){
        if(option==1){
            return 2;
        }else{
            return 1;
        }        
    }
}

