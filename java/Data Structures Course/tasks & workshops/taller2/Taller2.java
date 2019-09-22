/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structures.taller2;

/**
 *
 * @author User
 */
import java.util.Scanner;
public class Taller2 {
    public static void main(String[] args){
        Cuenta cuenta=null;
        Scanner input=new Scanner(System.in);
        int option;
        System.out.println("-Menu-");
        System.out.println("1. Crear una cuenta vacia");
        System.out.println("2. Crear una cuenta con saldo inicial");
        System.out.print("Seleccione una opcion: ");
        option=input.nextInt();
        switch(option){
            case 1: 
                cuenta=new Cuenta();
                System.out.println("Se ha creado una cuenta vacia");
                System.out.println(cuenta.saldo);
                break;
            case 2:
                System.out.print("Ingrese un valor inicial: ");
                float valorInicial=input.nextFloat();
                cuenta=new Cuenta(valorInicial);
                System.out.printf("Se ha creado una cuenta con %f de saldo inicial \n",valorInicial);
                break;
        }
        boolean esteEnElPrograma=true;
        do{
        System.out.println("--Menu--");
        System.out.println("3. Ingresar Dinero");
        System.out.println("4. Sacar Dinero");
        System.out.println("5. Ver Saldo");
        System.out.println("6. Salir");
        System.out.print("Escoja una opcion: ");
        option=input.nextInt();
        switch(option){
            case 3: 
                System.out.print("Ingrese un valor a depositar: ");
                float ingreso=input.nextFloat();
                cuenta.ingresar(ingreso);
                System.out.printf("Se ha ingresado %f a la cuenta \n",ingreso);
                break;
            case 4:
                System.out.print("Ingrese el valor a sacar: ");
                float retiro=input.nextFloat();
                while(retiro>cuenta.getSaldo()){
                    System.out.print("No puede retirar esa cantidad, pruebe con otro valor: ");
                    retiro=input.nextFloat();
                }
                cuenta.extraer(retiro);
                System.out.printf("Se ha retirado %f de la cuenta \n",retiro);
                break;
            case 5:
                
                System.out.printf("Usted tiene %f en la cuenta \n",cuenta.getSaldo());
                break;
            case 6:
                esteEnElPrograma=false;
                break;
            }
        }while(esteEnElPrograma);
        
        
            
        }
        
        
    }

