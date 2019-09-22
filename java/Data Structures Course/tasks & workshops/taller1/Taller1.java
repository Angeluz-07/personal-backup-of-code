
import java.util.Scanner;

public class Taller1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        System.out.println("A continuacion se desarrolla el literal 1...");
       
       Scanner input= new Scanner(System.in);
      
       System.out.print("Ingrese un Nombre: ");
       String nombre= input.nextLine();
       System.out.print("Ingrese un numero: ");
       int num1= input.nextInt();
       System.out.print("Ingrese otro numero: ");
       int num2= input.nextInt();
       int mayor;
       if (num1>num2){
           mayor= num1;
       } 
       else{
           mayor=num2;
       }
       System.out.println("Hola "+nombre+" tus números son: "+ num1 +" y "+ num2 + " .El numero mayor es: " + mayor);
       
       System.out.println("A continuacion se desarrolla el literal 2...");
       System.out.print("Ingrese un numero: ");
       int num3=input.nextInt();
       method(num3);
            
    }
    
           
        public static void method(int number){
        if (number<1){
            System.out.println("El numero es menor que 1");
        }
        else{
            int suma=0;
            for(int i=1;i<=number;i++){
                suma+=i;
            }
            System.out.println("La suma de los numeros del 1 hasta el numero ingresado es "+suma);
           
        }
    }
    
}

