package Unidad_2_Soluciones;

import java.util.Scanner;

public class Unidad2_Leccion1 {
   public static void main(String args[]) {
        /*
        //declarar tipo de variable
        int i=1;
        
        //colocar llave en vez de punto y coma
        while(i<=10){
               ++i;
        }       
        //la salida es 11
        System.out.println(i);       
       */
                
        /*
        //declarar tipo de variable
        int counter= 2;
       
        do{
            System.out.println(counter);
            counter+=2;
        
        //colocar el igual en la condicion del while y poner "While" en minuscula
        }while(counter<=100);        
        //la salida son los pares del 2 al 100       
        */
               
        Scanner input= new Scanner(System.in);
        
        //Almaceno en un arreglo de strings los 5 numeros
        String [] numTelefonicos= new String[5];
        for(int i=0;i<5;i++){
            System.out.printf("Ingrese el No telefonico [%d]: ",i+1);
            numTelefonicos[i]=input.nextLine();
        }
        System.out.println("");
        
        String phone;
        for(int i=0;i<5;i++){
            //Tomare cada numero y trabajare sobre el.
            phone=numTelefonicos[i];
            
            System.out.printf("El numero %s ",phone);
            
            //verifico sus dos primeros digitos
            switch(phone.substring(0,2)){
                case "02":System.out.println("pertenece a Quito"); break;
                case "03":System.out.println("pertenece a Tungurahua"); break;
                case "04":System.out.println("pertenece a Guayas"); break;
                case "09":System.out.println("es un celular"); break;
                default:System.out.println("tiene un codigo de area no registrado"); break;
            }
          
            //Tomo la parte del numero a partir del guion
            System.out.print("Este numero sin codigo de area es : ");
            System.out.println(phone.substring(phone.indexOf("-")+1));
            
            //tomo un arreglo de caracteres del string para contar las instancias del numero 9    
            char[] data=phone.toCharArray();
            int n=0;
            for(int k=0;k<data.length;k++){                                 
                if(data[k]=='9') n+=1;                
            }
            //Finalmente imprimo los resultados, nota: revisar "short if-else"                          
            System.out.printf("El numero 9 aparece %d %s \n", n, (n==1? "vez":"veces"));                       
            System.out.println("Este numero en formato Internacional es: " + "593-" + phone.substring(1)+"\n");
        }
       
   }
}
