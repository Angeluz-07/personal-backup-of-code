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
public class Unidad2_Tarea1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        //Ningun item tiene validacion.
        
        Scanner input= new Scanner(System.in);
        
        
        double tempCelsius,tempFahrenheit;
        System.out.print("Por favor ingrese la temperatura en grado Celsius : ");
        tempCelsius=input.nextDouble();
        
        //  Despejando de la formula. Se coloca 9.0 y 5.0 para que java los reconozca 
          //como datos tipo double, de lo contrario al efectuar la division  9/5
          //trabajara con el valor de 1 y el resultado sera erroneo;        
        
        
        tempFahrenheit=(9.0/5.0)*tempCelsius + 32;
        
        //Revisar salida de datos con formato
        System.out.printf("%.0f grados Celsius son %.0f grados Fahrenheit \n",tempCelsius,tempFahrenheit);
        
        
        
        
        /*
        //Tema 2
        
        //arreglo de tres valores
        double[] x=new double[3];
        for(int i=0; i<3; i++){
            System.out.printf("Ingrese X%d :",i+1);
            x[i]=input.nextDouble();
        }
        
        double mean=(x[0]+x[1]+x[2])/3;
        double variance= ( Math.pow(x[0]-mean,2) + Math.pow(x[1]-mean,2) + Math.pow(x[2]-mean,2) )/3 ;
        double std=Math.sqrt(variance);

        System.out.printf("La media es %.1f , la varianza es %.1f y la desviacion estandar %.1f", mean, variance,std);
        */
       
        
        /*
        //Tema 3
       
        // creo otra variable para que no se pierda el valor
        int a=1,b=2,c;
        System.out.printf("Antes : a = %d, b = %d \n", a,b);
        //primero guardo el valor de a
        c=a;
        //a apunta al valor de b
        a=b;
        //b apunta al valor de a, que c habia guardado.
        b=c;
        System.out.printf("Despues: a = %d, b = %d \n", a,b);
        
        */
        
        
        /*
        //tema 4
        //arreglo de tres valores
        double a,b,c;
        System.out.print("Ingrese a: ");        
        a=input.nextDouble();
        System.out.print("Ingrese b: ");                
        b=input.nextDouble();
        System.out.print("Ingrese c: ");               
        c=input.nextDouble();
        
        double determinante= Math.pow(b,2)-4*a*c;
        if(determinante<0){
            System.out.println("No existe solucion real.");
        }else{
            double x1,x2;
            System.out.println(-b+Math.sqrt(determinante));
            System.out.println(-b-Math.sqrt(determinante));
            x1= (-b+Math.sqrt(determinante))/(2*a);
            x2= (-b-Math.sqrt(determinante))/(2*a);
            System.out.println("x1 = " + x1 + ", x2 = " + x2);        
        }
        // 0/0 me devuelve NaN(not a number)
        // numero/0 me devuelve infinity
        */
        
        
        //tema 5
        
        /*
        int horas, minutos, segundos;
        System.out.print("Ingrese un valor en segundos: ");
        int segIngresados=input.nextInt();
        horas=segIngresados/3600;
        minutos=(segIngresados%3600)/60;
        segundos=segIngresados%60;
        System.out.printf("%d segundos equivalen a: %d horas, %d minutos y %d segundos.\n",segIngresados,horas,minutos,segundos);
        */
    }
    
}
