/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unidad_6_Tuttoring;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Main {
   
    public static void main(String args[]){      
        TicTacToe game=new TicTacToe();
        Scanner input=new Scanner(System.in);        
       
        boolean continueLoop=true;
        int option,i,j;
        Sign sTemp;
        do{
            try{
                game.printBoard();
               
                System.out.print("Input 1:X or 2:O to mark in the board: ");
                
                //If user enters a string gets caught
                option=input.nextInt();            
                                
                switch(option){
                    case 1:
                        sTemp=Sign.X; 
                        break;
                    case 2:    
                        sTemp=Sign.O;
                        break;
                    default:
                        //if enters a value not especified...gets caught
                        throw new IllegalArgumentException("Ingrese Valores entre 1 y 2");                       
                }
                System.out.print("Enter i: ");
                
                i=input.nextInt();
                
                if(!TicTacToe.indexIsValid(i)){
                    throw new IllegalArgumentException("valor de i invalido.");
                }
                
                System.out.print("Enter j: ");
                j=input.nextInt();
                                
                if(!TicTacToe.indexIsValid(j)){
                    throw new IllegalArgumentException("valor de j invalido.");                                    
                }
                game.mark(sTemp, i, j);
                              
            }catch(InputMismatchException e){
                System.out.println(e);
                input.nextLine(); 
            }catch(IllegalArgumentException e){
                System.out.println(e);
            }catch(Exception e){                                          
                System.out.println("otra excepcion");
            }
            
        }while(continueLoop);
    }
}
